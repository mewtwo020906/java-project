package annotation.annotation2;

// 表示这个类已过时
public class AnnotationTest03 {
    public static void main(String[] args) {
        AnnotationTest03 at = new AnnotationTest03();
        at.dosome();
    }

    @Deprecated
    public void dosome() {
        System.out.println("dosome");
    }

    // Deprecated这个注解标注的元素已过时。
    // 这个注解主要是向其他程序员传达一个信息，告知已过时，有更好的解决方案存在。
    @Deprecated
    public static void doOther() {
        System.out.println("doOther");
    }
}

class T{
    public static void main(String[] args) {
        AnnotationTest03 at = new AnnotationTest03();
        at.dosome();
        AnnotationTest03.doOther();
    }
}