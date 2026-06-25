package people;

import people.customExceptions.PersonDoNotHaveATeamException;
import team.Team;

public class Manager extends Person {

    Manager(String nome, String sobrenome, int age) {
        super(nome, sobrenome,age);
    }

    private int overrall;
    private double trainingFactor;

    @Override
    public Team getCurrentTeam() {
        if(currentTeam == null){
            throw new PersonDoNotHaveATeamException("Manager");
        }
        return currentTeam;
    }

}
