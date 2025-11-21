package exception;

import exception.MyStack;
import exception.MyStackOperationException;

// 测试改良之后的MyStack
// 该例子是异常最重要的案例，是自定义异常在实际开发中的应用。
public class MyStackTest {
    public static void main(String[] args) {
        // 创建栈对象
        MyStack stack = new MyStack();

        // 压栈
        try{
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            // 这里栈满了
            stack.push(new Object());
        }catch (MyStackOperationException e){
            e.printStackTrace();
            // 输出异常的简单信息。
            System.out.println(e.getMessage());
        }

        // 弹栈
        try{
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            // 弹栈失败
            stack.pop();
        }catch (MyStackOperationException e){
            e.printStackTrace();
            // 输出异常的简单信息。
            System.out.println(e.getMessage());
        }


    }
}
