public class KeyInputTest {
    public static void main(String[] args){

    //第一步：创建键盘扫描器对象
    java.util.Scanner s = new java.util.Scanner(System.in);

    //第二步：调用Scanner对象的next()方法开始接受用户键盘输入
    //程序执行到这里会停下来，等待用户的输入
    //当用户输入的时候，并且最终敲回车键的时候，键入的信息会自动赋值给userInputContent
    //程序执行到这里，用户输入的信息已经到内存中了。
    //接收文本[以字符串的形式接收]
    String userInputContent = s.next();

    //接收数字[以整数型int的形式来接收]
    int num =s.nextInt();

    //将内存中的数据输出到控制台
    System.out.println("您输入了：" + userInputContent);

    System.out.println("您输入的数字是" + num);
    System.out.println("计算结果：" + (num + 100));
    }
}
