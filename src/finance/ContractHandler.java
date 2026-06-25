package finance;

import people.Person;
import people.Player;
import team.Team;
import team.TeamValidator;

import java.util.HashMap;
import java.util.Map;

public final class ContractHandler {


    private static final Map<String, Team> accounts = new HashMap<>();

    public static void hireContractSolver(int years, double salary, Player player, Team team){
        // todos metodos que chamam esta classe devem adicionar o jogador no elenco, caso contrario, será gerada uma exceção
        TeamValidator.validarSeJogadorExistenoElenco(player, team);
        //esta verificacao protege o sistema, pois este e um método publico

        player.setTeam(team);
        player.setContract(years,salary);
        Bank.addAnualBill(team, player.getAnualSalary());
        System.out.println(team.getName() + " annual bill: " +  Bank.getAnualBill(team) );
    }
    public static void fireContractSolver(Player player){
        Team team = player.getCurrentTeam();
        double anualSalary = player.getAnualSalary();
        player.sairDoClube();
        Bank.removeAnualBill(team, anualSalary);
        System.out.println(team.getName() + " annual bill: " +  Bank.getAnualBill(team) );


    }

}
