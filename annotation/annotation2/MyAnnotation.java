package annotation.annotation2;

public @interface MyAnnotation {
    /**
     * 我们通常在注解当中可以定义属性，以下这个是MyAnnotation的name属性。
     * 看着像1个方法，但实际上我们称之为属性name
     * @return
     */
    String name();

    String color();

    int age() default 25; // 属性指定默认值
}
