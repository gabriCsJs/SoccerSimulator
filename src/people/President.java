package people;

import people.customExceptions.PersonDoNotHaveATeamException;
import team.Team;

public class President extends Person{

    President(String nome, String sobrenome, int age) {
        super(nome, sobrenome, age);
    }

    @Override
    public Team getCurrentTeam() {
        if(currentTeam == null){
            throw new PersonDoNotHaveATeamException("President");
        }
        return currentTeam;
    }
}
