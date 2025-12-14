package annotation.annotation3;
/*
如果一个注解的属性的名字是value的话，在使用的时候，该属性名可以省略。
 */
public class MyAnnotationTest {

    @MyAnnotation(value = "amagi")
    public void doSome(){

    }

    @MyAnnotation("阿么西多多")
    public void doOther(){
    }
    public static void main(String[] args) {}
}
