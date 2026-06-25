package finance;

import finance.customExceptions.InsufficientFundsException;
import team.Team;

import java.util.*;

public final class Bank {

    private static final Map<Team, BankClient> accounts = new HashMap<>();

    private Bank() {
        throw new UnsupportedOperationException("Esta classe não pode ser instanciada.");
    }

    public static void createAccount(Team team) {
        if (!accounts.containsKey(team)) {
            accounts.put(team, new BankClient());
        }
    }

    public static void transferMoney(Team paga, Team recebe, double amount) {
        if (accounts.containsKey(paga) && accounts.containsKey(recebe)) {
            accounts.get(paga).takeMoney(amount);
            accounts.get(recebe).receiveMoney(amount);
        }
    }

    static void addAnualBill(Team team, double amount) {
        accounts.get(team).addAnualBill(amount);
    }

    static void removeAnualBill(Team team, double amount) {
        accounts.get(team).removeAnualBill(amount);
    }

    public static void pagarContas(Team team) {
        double total = getAnualBill(team);
        try {
            accounts.get(team).takeMoney(total);
            System.out.println("Valor pago: "+ total);
        } catch (InsufficientFundsException e) {
            System.out.println("Voce faliu");
            abrirProcessoDeFalencia();
        }
    }

    static void abrirProcessoDeFalencia(){
        System.out.println("Abrir processo de falencia");
    }

    //--------------Support-----------------\\
    //getters
   public static double getAnualBill(Team team) {
        return accounts.get(team).getAnnualBill();
    }

}
