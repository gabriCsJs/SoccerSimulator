package people;

import people.customExceptions.PersonDoNotHaveATeamException;
import team.Team;
import team.TeamValidator;

public abstract class Player extends Person {

    private double power;
    private double expPerMatch;
    private double value;
    protected final boolean star;

//    protected Player(String nome, String sobrenome, int age,double power, double expPerMatch, boolean star) {
//        super(nome, sobrenome, age);
//        this.power = power;
//        this.expPerMatch = expPerMatch;
//        this.star = star;
//    }

    protected Player(String name, String lastName, int age, boolean star) {
        super(name, lastName, age);
        this.star = star;
    }

    protected abstract void calculateStatus(int age, boolean star);

    void setGainOfPower( int matches) {
        this.power = this.power +(expPerMatch*matches) ;
    }

    public void setPower(double power) {
        if(!this.star) { //nao pensei em restriçoes
            this.power = power >= 80 ? 79 : power;
            calculateValue(power, getAge());
        } else {this.power = power >= 100 ? 99 : power;}

    }
    public double getPower() {return this.power;}

    public void setExpPerMatch(double expPerMatch) {
        if(expPerMatch >= 0.8) { //a experiência nunca vai ser maior ou igual a 8 nem menor do que 2
            System.out.println("Nobody is that good, try again.");
        } else if(expPerMatch < 0.2) {
            System.out.println("Nobody is that bad, try again.");
        } else if(expPerMatch >= 0.2) {
            if(!this.star){ // jogadores normais podem ganhar no maximo 0.5 de experiência
                if(expPerMatch > 0.5){
                    System.out.println(name + " is not that good, try again.");
                } else {this.expPerMatch = expPerMatch;}

            } else {this.expPerMatch = expPerMatch;}
        }
    }
    public double getExpPerMatch() {return this.expPerMatch;}

    private void calculateValue(double power, int age) {
        // 1. Definimos um valor base baseado no poder do jogador (ex: quanto mais poder, mais caro multiplicando exponencialmente)
        double baseValue = Math.pow(power, 2) * 100; // Se power for 80, base é 640.000

        double multiplicadorIdade = 1.0;

        // 2. Lógica de mercado baseada na idade (Auge vs Fim de Carreira)
        if (age <= 21) {
            // Muito jovem e promissor: ganha um bônus de valorização pelo futuro
            multiplicadorIdade = 1.5;
        } else if (age <= 27) {
            // No auge físico e técnico: valor máximo de mercado
            multiplicadorIdade = 1.2;
        } else if (age <= 32) {
            // Experiente: valor começa a estabilizar ou cair levemente
            multiplicadorIdade = 0.8;
        } else {
            // Acima de 32 (Fim de carreira): o valor de mercado despenca, mesmo se tiver power alto
            multiplicadorIdade = 0.4;
        }

        // 3. Se o jogador for uma Estrela (star), o valor dele triplica pelo marketing e camisas vendidas!
        double multiplicadorEstrela = this.star ? 3.0 : 1.0;

        // 4. Calculamos o valor final
        this.value = baseValue * multiplicadorIdade * multiplicadorEstrela;
    }

    public double getValue() {
        return this.value;
    }

    public boolean getStar() {
        return this.star;
    }

    @Override
    public void setTeam(Team team){
            TeamValidator.validarSeJogadorExistenoElenco(this, team);
            this.timesEmQueJogou.add(team);
            this.currentTeam = team;
    }
    @Override
    public void sairDoClube(){
        TeamValidator.validarSeJogadorExistenoElenco(this, this.currentTeam);
        this.currentTeam = null;
        this.contract = null;
    }

    @Override
    public Team getCurrentTeam() {
        if(currentTeam == null){
            throw new PersonDoNotHaveATeamException("player");
        }
        return currentTeam;
    }
}
