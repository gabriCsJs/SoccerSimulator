package team.customExceptions;

public class PersonDoNotBelongsToThisTeamException extends RuntimeException {
    String message = "Essa Pessoa nao atua nesse time";

    public PersonDoNotBelongsToThisTeamException() {

    }

    public String getMessage() {
        return message;
    }
}
