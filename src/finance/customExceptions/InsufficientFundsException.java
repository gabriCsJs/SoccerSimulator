package finance.customExceptions;

public class InsufficientFundsException extends RuntimeException {

    private String message = "O clube nao tem verba suficiente para executar essa acao";
    public InsufficientFundsException() {
    }

    public String getMessage() {
        return message;
    }

}
