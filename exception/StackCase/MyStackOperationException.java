package exception.StackCase;

/**
 * 栈操作异常：自定义异常！
 */
public class MyStackOperationException extends Exception {
    public MyStackOperationException() {

    }

    public MyStackOperationException(String s) {
        super(s);
    }
}
