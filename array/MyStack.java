public class MyStack {

    // 栈空间
    private Object[] elements;

    // 栈帧指针（指向下一个可用位置）
    private int index = 0;

    // 带容量的构造方法
    public MyStack(int capacity) {

        elements = new Object[capacity];
    }

    // 压栈
    public void push(Object obj) {
        if (index == elements.length) {
            System.out.println("栈已满，压栈失败");
            return;
        }
        elements[index++] = obj;
    }

    // 弹栈
    public Object pop() {
        if (index == 0) {
            System.out.println("栈已空，弹栈失败");
            return null;
        }
        Object obj = elements[--index];
        elements[index] = null;
        return obj;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D"); // 栈满提示

        System.out.println(stack.pop()); // C
        System.out.println(stack.pop()); // B
        System.out.println(stack.pop()); // A
        System.out.println(stack.pop()); // 栈空提示
    }
}
