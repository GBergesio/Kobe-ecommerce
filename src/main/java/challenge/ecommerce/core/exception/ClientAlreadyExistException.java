package challenge.ecommerce.core.exception;

public class ClientAlreadyExistException extends Exception{
    public ClientAlreadyExistException() {
        super();
    }

    public ClientAlreadyExistException(String message) {
        super(message);
    }

    public ClientAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
