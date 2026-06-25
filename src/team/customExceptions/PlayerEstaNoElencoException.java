package team.customExceptions;

public class PlayerEstaNoElencoException extends RuntimeException {
    String message = "Esse jogador esta no elenco";

    public PlayerEstaNoElencoException() {

    }

    public String getMessage() {
        return message;
    }
}
