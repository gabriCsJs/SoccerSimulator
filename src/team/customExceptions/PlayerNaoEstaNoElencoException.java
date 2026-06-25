package team.customExceptions;

public class PlayerNaoEstaNoElencoException extends RuntimeException {
    String message = "Esse jogador nao esta no elenco";

    public PlayerNaoEstaNoElencoException() {

    }

    public String getMessage() {
        return message;
    }
}
