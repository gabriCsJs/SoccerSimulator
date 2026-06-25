package people;

import competitions.Title;
import finance.Contract;
import team.Team;
import team.customExceptions.PersonDoNotBelongsToThisTeamException;

import java.util.*;

public abstract class Person {

    final String id;
    final String name;
    final String lastName;
    private int age;
    private final List<Title> trophies;
    final Set<Team> timesEmQueJogou;  //tentar colocar como privado

    Contract contract; //tentar colocar como privado
    protected Team currentTeam;

    Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.trophies = new ArrayList<>();
        this.timesEmQueJogou = new HashSet<>();
        this.age = age;
        this.id = UUID.randomUUID().toString();
    }

    public void setTeam(Team team){
        if(team != null){
            this.timesEmQueJogou.add(team);
            this.currentTeam = team;
        } else{//mandar erro se for null
        }
    }

    void sairDoClube(){
        this.currentTeam = null;
        this.contract = null;
    }

    public int getAge(){
        return this.age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    void setTitle(Title title){
        this.trophies.add(title);
    }

    //--------------Contract-----------------\\
    public void setContract(int anos, double salarioSemanal){
        this.contract = new Contract(anos, salarioSemanal);
    }

    public double getAnualSalary(){
        return contract.getAnnualSalary();
    }

    public abstract Team getCurrentTeam();

    @Override
    public String toString() {
        return this.name + " " + this.lastName + " (Idade: " + this.age + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}