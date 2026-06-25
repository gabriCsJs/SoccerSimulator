package finance;

import finance.customExceptions.InsufficientFundsException;
import team.Team;

import java.util.ArrayList;

public class BankClient {

    private double availableBalance;
    private final ArrayList<Loan> loans;
    private double annuaBills;

    BankClient() {
        this.loans = new ArrayList<>();
        this.availableBalance = 100500.99;
    }

    void takeMoney(double amount) {
        verificaSePodeGastar(amount);
        this.availableBalance -= amount;
    }

    void receiveMoney(double amount) {
        this.availableBalance += amount;
    }

    void addAnualBill(double amount) {
        this.annuaBills += amount;
    }

    void removeAnualBill(double amount) {
        this.annuaBills -= amount;
    }

    double getAnnualBill() {
        return this.annuaBills;
    }

    void verificaSePodeGastar(double amount){
        if (availableBalance < amount) {
            throw new InsufficientFundsException();
        }
    }

}
