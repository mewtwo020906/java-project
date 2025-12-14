package annotation.annotation4;

public class OtherAnnotationTest {

    // 数组是大括号
    @OtherAnnotation(age = 25, email = {"zhangsan@123.com","zhangsan@souhu.com",},seasonArray = {Season.SPRING,Season.AUTUMN,Season.SUMMER})
    public void doSome(){

    }

    // 如果数组中只有1个元素：大括号可以省略。
    @OtherAnnotation(age = 25, email = "zhangsan@123.com",seasonArray = Season.WINTER)
    public void doOther(){
    }

}
