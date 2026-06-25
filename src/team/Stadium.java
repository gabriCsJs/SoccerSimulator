package team;

import java.util.Scanner;

public class Stadium {

    private final String name;
    private final int capacity;
    private double entryprice;

    Stadium(String name, int capacity, double entryprice) { //this is for the auto construction
        this.name = name;
        this.capacity = capacity;
        this.entryprice = entryprice;
    }

    public void setEntryprice(double entryprice) {
        if(entryprice < 0){
            System.out.println("the entry price can't be less than 0");
        } else {
            this.entryprice = entryprice;
        }
    }

    public double getEntryprice() {
        return this.entryprice;
    }

    @Override
    public String toString() {
        return  "Stadium name: " + this.name + ", capacity: " + this.capacity + ", entryprice: " + this.entryprice;
    }
}
