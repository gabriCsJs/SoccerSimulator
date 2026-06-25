package people.positions;

import people.Player;

public class Goalkeeper extends Player {

    private int defesa;
    private int flexibilidade;

    public Goalkeeper(String name, String lastName, int age, boolean star, int defesa, int flexibilidade) {
        super(name, lastName, age, star);
        this.defesa = defesa;
        this.flexibilidade = flexibilidade;
        calculateStatus(age, star);

    }

//    public Goalkeeper(String nome, String sobrenome, int age, double power, double expPerMatch, boolean star, int defesa, int flexibilidade) {
//        super(nome, sobrenome, age, power, expPerMatch, star);
//        this.defesa = defesa;
//        this.flexibilidade = flexibilidade;
//    }

    @Override
    protected void calculateStatus(int age, boolean star) {
        // Agora sim: modificadorAtributos vai usar os valores reais passados no contrutor!
        double modificadorAtributos = (this.defesa + this.flexibilidade) / 2.0;

        if (age <= 17) {
            this.setPower((star ? 75 : 65) + (modificadorAtributos * 0.1));
            this.setExpPerMatch(star ? 0.6 : 0.3);
        } else if (age <= 25) {
            this.setPower((star ? 80 : 70) + (modificadorAtributos * 0.1));
            this.setExpPerMatch(star ? 0.4 : 0.35);
        } else {
            this.setPower((star ? 90 : 75) + (modificadorAtributos * 0.05));
            this.setExpPerMatch(star ? 0.2 : 0.2);
        }
    }
}
