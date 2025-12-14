package annotation.annotation2;

public class MyAnnotationTest {
    // 报错的原因：如果一个注解当中有属性，那么必须给属性赋值。(除非该属性使用default指定了默认值。)
    /*@MyAnnotation2
    public void doOther() {
        System.out.println("doOther");
    }*/

    // @MyAnnotation2(属性名 = 属性值，属性名 = 属性值，属性名 = 属性值)
    @MyAnnotation(name = "amagi", color = "红色")
    public void doSome(){

    }
    public static void main(String[] args) {}
}
