package exceptions;

public class TransactionIncompleteException extends  RuntimeException{
    public TransactionIncompleteException(String message) {
        super(message);
    }
}
