package team.customExceptions;

public class PersonBelongsToThisTeamException extends RuntimeException {
    String message = "Essa Pessoa ja atua nesse time";

    public PersonBelongsToThisTeamException() {

    }

    public String getMessage() {
        return message;
    }
}
