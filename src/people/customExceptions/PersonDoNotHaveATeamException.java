package people.customExceptions;

public class PersonDoNotHaveATeamException extends RuntimeException {
    private final String type;

    public PersonDoNotHaveATeamException(String type) {
        this.type = type;
    }
    public String getMessage() {
        return "Esse " + type + " Nao tem um time";
    }
}
