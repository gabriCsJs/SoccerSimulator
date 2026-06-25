package finance;

import team.Team;

public class Contract {



    private int years;
    private double salary;
    private double annualSalary;
    private double Total;

    public Contract(int years, double salary){ //nao faz sentido atacar ele por enquanto
        this.years = years;
        this.salary = salary;
        this.annualSalary = 12 * salary;
        this.Total = this.annualSalary * years;
    }


    public int getYears() {
        return years;
    }

    public double getSalary() {
        return salary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public double getTotal() {
        return Total;
    }
}