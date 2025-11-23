package exception;

/**
 * 自定义异常
 */
public class IrrationalNameException extends Exception {
    public IrrationalNameException() {

    }

    public IrrationalNameException(String message) {
        super(message);
    }
}
