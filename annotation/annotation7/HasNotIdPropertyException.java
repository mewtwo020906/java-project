package annotation.annotation7;

/*
自定义异常
 */
public class HasNotIdPropertyException extends RuntimeException {
    public HasNotIdPropertyException() {

    }
    public HasNotIdPropertyException(String message) {
        super(message);
    }
}
