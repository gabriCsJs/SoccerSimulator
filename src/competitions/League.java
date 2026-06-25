package competitions;

import team.Team;

import java.util.ArrayList;

public class League {

    private String name;
    private Title title;
    private double prize;
    private int numberOfCompetitors;
    private int edition;
    private ArrayList<Team> winners;
    private  int partidasPorTime;
    private ArrayList<Team> teamsCompetitors;
    private int points;

    League(String name, Title title, double prize, int numberOfCompetitors, int points) {
        this.name = name;
        this.title = title;
        this.prize = prize;
        this.edition = 1;
        this.points = points;
        if (numberOfCompetitors < 4 || numberOfCompetitors > 16) {
            //jogue um erro dizendo que o numero de competidores nao pode ser menor que 4 ou maior que 16
            int x;
        }
        else {
            this.numberOfCompetitors = numberOfCompetitors;
            this.partidasPorTime = (numberOfCompetitors - 1) * 2;
        }
    }

    void simularLiga(){
        // para cada numero de competidores pedir pro usuario adicionar um time e adicionar o nome do time em um dicionario Time / INT pontos
        // criar uma lista para cada time excluindo o time em questao que vamos chamar de lista de partida
        // um laço que pede para ser executado duas vezes com um sub-laço que percorre a lista de partida
        // chamando a classe match pra cada time e adicionando points para cada vitoria e ao final adicionar o valor total para o pontos do time correspondente
        //depois
        // verificar qual time tem o mais pontos e chamar a funçao de desenhar tabela
        // adicionar o premio para o time
        // adicionar o titulo para a sala de trofeus do time e seus funcionarios
        this.edition += 1;
        // limpar todos os competidores e se tiver mais alguma coisa para limpar tem que limpar
    }

    void removeTeam(Team team) {}

}
