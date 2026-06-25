package team;

import java.util.Scanner;

public class FanClub {

    private final String name;
    private int members;

    FanClub(String name){ // construtor manual
       this.name =  name;
       this.members = 100;
    }

    public String getName() {
        return name;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "FanClub: " + this.name  + ", Members: " + this.members;
    }
}