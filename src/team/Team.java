package team;

import finance.Bank;
import finance.ContractHandler;
import people.Manager;
import people.Player;
import people.President;

import java.util.*;

public class Team {

    private final String id;

    private final String name;
    private final Stadium stadium;
    private final FanClub fanClub;
    private final TrophyRoom trophyRoom;
    private final Set<Player> elenco;

    private double teamTotalValue;
    private Manager manager;
    private President president;

    //--------------Constructors-----------------\\

    public Team(String teamName, String stadiumName,int stadiumCapacity, double
            stadiumEntryPrice, String fanclubName) {
        this.name = teamName;
        this.stadium = new Stadium(stadiumName, stadiumCapacity, stadiumEntryPrice);
        this.fanClub = new FanClub(fanclubName);
        this.trophyRoom = new TrophyRoom();
        this.elenco = new HashSet<>();
        this.id = UUID.randomUUID().toString();
        Bank.createAccount(this);
    }

    double DefinirTeamTotalValue() {
        return teamTotalValue;
    }  //todo

    //--------------President-----------------\\
    void hirePresident(President president, int years, double salary){
        this.president = president;
//        ContractHandler.hireContractSolver(years, salary, president,this);

    } // todo
    void firePresident(){}
    President getPresident(){return president;}

    //--------------Manager-----------------\\
    void hireManager(Manager manager, int years, double salary ) {
        this.manager = manager;
//        ContractHandler.hireContractSolver(years, salary, manager,this);
    }
    public void fireManager(Player player){} //todo
    Manager getManager(){return manager;}

    //--------------Players-----------------\\

    public void hireElenco(Queue<Player> players/*,Queue<int> anos, Queue<Double> salarioSemanal*/){
        for(Player player : players){
            elenco.add(player);
            /*contractManager(anos,salarioSemanal, player);*/
            // isso aqui parece nivel medio
            //nada que uma gambiarra não resolva por enquanto
        }
    } //todo

    public void buyPlayer(Player player, int years, double salary,double amount){
        //compra um jogador de um time
        Team seller = player.getCurrentTeam();
        TeamValidator.validarSePessoaNaoAtuaNoClube(player, this);
        Bank.transferMoney(this,seller, amount);
        transferenciaSolver(player, years, salary, this);
    }
    public void promoverJogador(Player player, Team team,int years, double salary){
        // adiciona um jogador sem time ao elenco
        elenco.add(player);
        ContractHandler.hireContractSolver(years, salary, player, team);
    }
    private void transferenciaSolver(Player player, int years, double salary, Team team){
        elenco.add(player);
        Team seller = player.getCurrentTeam();
        ContractHandler.fireContractSolver(player);
        if (seller != null) {
            seller.elenco.remove(player);
        }
        ContractHandler.hireContractSolver(years, salary, player, team);
    }
    public void firePlayer(Player player){
        elenco.remove(player);
        ContractHandler.fireContractSolver(player);}
    //--------------Actions-----------------\\

    //--------------Support-----------------\\

    //--------------Getters-----------------\\
    public String getName() {
        return name;
    }  // todo
    public Stadium getStadium() {
        return stadium;
    } //todo
    public FanClub getFanClub() {
        return fanClub;
    }//todo
    public ArrayList<String> getElenco(){
        ArrayList<String> jogadores = new ArrayList<>();
        for(Player player : elenco){
            jogadores.add(player.getName());
        }
        return  jogadores;
    }
    //--------------Setters-----------------\\


    //--------------Hashcode and Equals-----------------\\
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Team team = (Team) object;
        return Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}