
# javaSE进阶1
## 关于IDEA工具的快捷键以及一些简单的设置

1. 快速生成main方法：psvm
2. 快速生成System.out.println():sout
3. 删除一行：ctrl + y
4. 左侧窗口中的列表怎么展开？怎么关闭？
   - 左箭头关闭
   - 右箭头展开
   - 上下箭头移动
5. IDEA中退出任何窗口，都可以使用esc键
6. 怎么运行：ctrl + shift +F10
7. 任何新增/新建/添加的快捷键是：alt + insert
8. 窗口变大，变小：ctrl + shift + F12
9. 切换java程序：alt + 左右箭头
10. Alt + Enter是最重要的快捷键之一，通常被称为 “万能快捷键”或 “快速修复”快捷键。
11. 注释：
- 单行注释：ctrl + /
- 多行注释：ctrl + shift + /
**注意：IDEA是自动保存，不需要ctrl + s**

## final关键字
1. final是一个关键字，表示最终的，不可变的。
2. final修饰的类无法被继承
3. final修饰的方法无法被覆盖
4. final修饰的变量一旦赋值之后，不可重新赋值[不可二次赋值]
5. final修饰的实例变量：
    - 使用final修饰之后，必须手动赋值，不能采用系统默认值。
    - final int age = 10;
    - 本质上都是在构造方法执行过程当中给实例变量赋值。
6. final修饰的引用：
    - 一旦指向某个对象之后，不能再指向其他对象，那么被指向的对象无法被垃圾回收器回收。
    - 虽然指向某个对象之后不能再指向其他对象，但是所指向的对象内部的内存是可以被修改的。
7. final修饰的实例变量是不可变的，这种变量一般和static联合使用，被称为“常量”
    - 常量的定义语法格式：
      - public static final 类型 常量名 = 值;
    - java规范中要求所有常量的名字全部大写，每个单词之间使用下划线连接。

**类库一般包括三个部分**
- 源码[可以看源码来理解程序]
- 字节码[程序开发的过程中使用的就是这部分]
- 帮助文档[对源码的解释说明被提取出来，更方便程序的开发]

## 抽象类和接口以及抽象类和接口的区别

### 抽象类
1. 什么是抽象类
   - 类和类之间具有共同特征，将这些共同特征提取出来，形成的就是抽象类。类本身是不存在的，所以抽象类无法创建对象[无法实例化]

2. 抽象类属于什么类型？
   - 抽象类也属于引用数据类型。

3. 抽象类怎么定义？
   - 语法：
        <pre>
        [修饰符列表] abstract class 类名{
            类体;
        }
        </pre>
4. 抽象类是无法实例化，无法创建对象的，所以抽象类是用来被子类继承的。
5. final和abstract不能联合使用，这两个关键字是对立的。
6. 抽象类的子类可以是抽象类。
7. 抽象类虽然无法实例化，但是抽象类有构造方法，这个构造方法是供子类使用的。
8. 抽象类关联到一个概念：抽象方法。什么是抽象方法？
   - 抽象方法表示没有实现的方法，没有方法体的方法。
   - 例如：public abstract void doSome();
     - 特点1：没有方法体，以分号结尾。
     - 特点2：前面修饰符列表中有abstract关键字。
9. 抽象类中不一定有抽象方法。抽象方法必须出现在抽象类中。
10. 向上转型，结合定义抽象类。Animal = new Bird();其中Animal是抽象类，Bird是子类继承抽象类。这就是面向抽象编程，以后调用都是a.xxx，不面向具体编程，降低程序的耦合度，提高程序的拓展力。这种编程思想符合OCP原则。
11. 一个非抽象类，继承抽象类，必须将抽象类中的抽象方法进行覆盖、重写，也可以叫做实现。(对抽象的实现。)

**面试题(判断题)：java语言中凡是没有方法体的方法都是抽象方法**
- 错误。Object类中就有很多方法都没有方法体，都是以";"结尾的，但是它们都不是抽象方法，例如：public native int hashCode();这个方法底层调用了C++写的动态链接库程序。前面修饰符列表中没有:abstract。有一个native。表示调用JVM本地程序。

### 接口
#### 接口的基础语法
1. 接口也是一种"引用数据类型"。编译之后也是一个class字节码文件。
2. 接口是完全抽象的。(抽象类是半抽象。)或者也可以说接口是特殊的抽象类。
3. 接口怎么定义，语法是什么？

        [修饰符列表] interface 接口名{ }

4. 接口支持多继承，一个接口可以继承多个接口。 
5. 接口中只包含两部分内容，一部分是：常量。一部分是：抽象方法。
6. 接口中所有的元素都是public修饰的。
7. 接口中的抽象方法的public abstract修饰符可以省略。
8. 接口中常量的public static final可以省略。 
9. 接口中的方法都是抽象方法，抽象方法不能有方法体。
10. 一个非抽象的类，实现接口的时候，必须将接口中所有的抽象方法全部实现(覆盖、重写)。
11. 一个类可以实现多个接口。
    - 接口和接口之间支持多继承，一个类可以同时实现多个接口。而java中类和类只支持单继承。实际上单继承是为了简单而出现的，现实世界中存在多继承，java中的接口弥补了单继承带来的缺陷。
<pre>
    interface X{    
    }
    interface Y{
    }
    class Z implements X{
    }

    X x = new Z();
    Y y = (Y)x;
    // 经过测试：接口和接口之间在进行强制类型转换的时候，没有继承关系，也可以强转。
    // 但一定要注意，运行时可能会出现ClassCastException异常。
</pre>
**无论向上转型还是向下转型，两种类型之间必须要有继承关系，没有继承关系编译器会报错。(这句话不适用在接口方面。)最终实际上和之前还是一样，需要加：instanceof运算符进行判断。向下转型养成好习惯。转型之前先if+instanceof进行判断。**

12. extends和implements可以共存，extends在前，implements在后。
    - 类和类之间叫做继承，类和接口之间叫做实现。
    - 继承使用extends关键字完成。实现使用implements关键字完成
13. 使用接口，写代码的时候，可以使用多态(父类型引用指向子类型对象)
<pre>
    //动物类：父类
    class Animal(){        
    }

    // 可飞翔的接口(是一对翅膀)
    // 能插拔的就是接口。(没有接口你怎么插拔)
    // 内存条插到主板上，他们之间有接口，内存条可以更换。
    // 接口通常提取的是行为动作。
    interface Flyable{
        void fly();
    }

    // 动物类子类：猫类
    // Flyable是一个接口，是一对翅膀的接口，通过接口插到猫身上，让猫变的可以飞翔。
    class Cat extends Animal implements Flyable{
        public void fly(){
            System.out.println("Cat is flying");
        }
    }
</pre>

#### 接口在开发中的作用
**面向接口编程，可以降低程序的耦合度，提高程序的拓展力。符合OCP开发原则。接口的使用离不开多态机制(接口+多态才可以达到降低耦合度。)**
1. 任何一个接口都有调用者和实现者，接口可以将调用者和实现者解耦合。
2. 调用者面向接口调用，实现者面向接口编写实现。
3. 以后进行大项目的开发，一般都是将项目分离成一个模块一个模块的，模块和模块之间采用接口衔接。降低耦合度。
- 餐馆点菜场景(面向抽象编程)
<pre>
// 中餐厨师
class ChineseCook implements FoodMenu{
    // 西红柿炒鸡蛋
    public void dish1(){
        System.out.println("中餐师傅做的西红柿炒鸡蛋");
    }

    // 鱼香肉丝
    public void dish2(){
        System.out.println("中餐师傅做的鱼香肉丝");
    }
}

// 西餐厨师
class AmericanCook implements FoodMenu{
    // 西红柿炒鸡蛋
    public void dish1(){
        System.out.println("西餐师傅做的西红柿炒鸡蛋");
    }

    // 鱼香肉丝
    public void dish2(){
        System.out.println("西餐师傅做的鱼香肉丝");
    }
}

// 接口：菜单，抽象的
interface FoodMenu{
    // 西红柿炒鸡蛋
    void dish1();

    // 鱼香肉丝
    void dish2();
}

// 顾客类
class Customer{
    // Customer has a FoodMenu; 顾客手里有一个菜单。
    private FoodMenu f;

    public Customer(){
    }

    public Customer(FoodMenu f){
        this.f = f;
    }

    public void setF(FoodMenu f){
        this.f = f;
    }

    public FoodMenu getF(){
        return f;
    }

    public void order(){
        f.dish1();
        f.dish2();
    }
}

// 测试类
public class Test{
    public static void main(String[] args){

        // 创建厨师对象
        FoodMenu cook1 = new AmericanCook();

        // 创建顾客对象
        Customer c = new Customer(cook1);

        // 顾客点菜
        c.order();
    }
}
</pre>

#### 抽类型和接口有什么区别？
1. 抽象类是半抽象的，接口是完全抽象的。
2. 抽象类中有构造方法，接口中没有构造方法。
3. 接口和接口之间支持多继承，类合理之间只能单继承。
4. 一个类可以同时实现多个接口，一个抽象类只能继承一个类(单继承)。
5. 接口中只允许出现常量和抽象方法。
   
## 类型和类型之间的关系
### is a(继承)、has a(关联)、like a(实现)
1. is a：
   - Cat is a Pet.(猫是一个宠物)
   - 凡是能够满足is a的表示“继承关系”
   - A extends B
2. has a：
   - Customer has a FoodMenu(顾客有一份菜单)
   - 凡是能够满足has a关系的表示“关联关系”
   - 关联关系通常以“属性”的形式存在。
    A{
        B b;
    }
3. like a：
   - Cooker like a FoodMenu(厨师像一个菜单一样)
   - 凡是能够满足like a关系的表示“实现关系”
   - 实现关系通常是：类实现接口。
   - A implements B

## 源码及API文档概述
### 什么是API
- 应用程序编程接口。(Application Program Interface)
- 整个JDK的类库就是一个javase的API。
- 每一个API都会配置一套API帮助文档。
- SUN公司提前写好的这套类库就是API。(一般每一份API都对应一份API帮助文档。)
### 目前需要知道的几个方法
- protected Object clone()      // 负责对象克隆的。
- int hashCode()                // 获取对象哈希值的一个方法。
- boolean equals(Object obj)    // 判断两个对象是否相等
- String toString()             // 将对象转换成字符串形式
- protected void finalize       // 垃圾回收器负责调用的方法
### 关于Object类中的toString()方法
1. 源代码长什么样？
<pre>
    public String toString(){
        return this.getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
</pre>
   - 源代码上toString()方法的默认实现是：
     - 类名@对象的内存地址转换为十六进制的形式
2. SUN公司设计toString()方法的目的是什么？
   - toString()方法的作用是什么？
     - toString()方法的设计目的是：通过调用这个方法可以将一个"java"对象转化成"字符串表示形式"
3. SUN公司开发java语言的时候，建议所有的子类都去重写toString()方法。
   - toString()方法应该是一个简洁的、详实的、易阅读的。
**输出引用的时候，会自动调用该引用的toString()方法**
### 关于Object类中的equals方法
1. equals方法的源代码
<pre>
public boolean equals(Object obj){
    return (this == obj);
}
</pre>
2. SUN公司设计equals方法的目的是什么？
   - 以后编程的过程当中，都要通过equals方法来判断两个对象是否相等。
   - equals方法是判断两个对象是否相等的。 
3. 我们需要研究一下Object类给的这个默认的equals方法够不够用
   - 在Object类中的equals方法当中，默认采用的是"=="判断两个java对象是否相等。而"=="判断的是两个java对象的内存地址，我们应该判断两个java对象的内容是否相等。所以老祖宗的equals方法不够用，需要子类重写equals。
4. 判断两个java对象是否相等，不能使用“==”。因为“==”比较的是两个对象的内存地址。
### java语言当中的字符串String有没有重写toString方法，有没有重写equals方法
1. String类已经重写了equals方法，比较两个字符串不能使用==，必须使用equals。equals是通用的。
2. String类已经重写了toString方法。
### 大结论
1. java中什么类型的数据可以使用"=="判断
   - java中基本数据类型比较是否相等，使用==
2. java中什么类型的数据需要使用equals判断
   - java中所有的引用数据类型统一使用equals方法来判断是否相等。
### 关于Object类中的finalize()方法。--亡语
1. 在Object类中的源代码：
   - protected void finalize() throws Throwable{    }
   - GC: 负责调用finalize()方法
2. finalize()方法只有一个方法体，里面没有代码，而且这个方法是protected修饰的。
3. 这个方法不需要程序员手动调用，JVM的垃圾回收器负责调用这个方法。不像equals toString,equals和toString()方法是需要你写代码调用的。finalize()只需要重写，重写完将来自动会有程序来调用。
4. finalize()方法的执行时机：
   - 当一个java对象即将被垃圾回收器回收的时候，垃圾回收器负责调用finalize()方法。
5. finalize()方法实际上是SUN公司为java程序员准备的一个时机，垃圾销毁时机。如果希望在对象销毁时机执行一段代码的话，这段代码要写到finalize()方法当中
6. 静态代码块的作用是什么？
<pre>
    static{
        ...
    }
</pre>
   - 静态代码块在类加载时刻执行，并且只执行一次。这是一个SUN准备的类加载时机。
   - finalize()方法同样也是SUN为程序员准备的一个时机。这个时机是垃圾回收时机。
7. java中的垃圾回收器不是轻易启动的，垃圾太少，或者时间没到，种种条件下，有可能启动，也有可能不启动。
### 关于Object类中的hashCode方法：
1. 在Object中的hashCode方法是怎么样的？
   - public native int hashCode();
   - 这个方法不是抽象方法，带有native关键字，底层调用C++程序。
2. hashCode()方法返回的是哈希码：
   - 实际上就是一个java对象的内存地址，经过哈希算法，得出的一个值。
   - 所以hashCode()方法的执行结果可以等同看作一个java对象的内存地址。
## 匿名内部类
1. 什么是内部类？
   - 内部类：在类的内部有定义了一个新的类。被称为内部类。
2. 内部类的分类：
   - 静态内部类：类似于静态变量
   - 实例内部类：类似于实例变量
   - 局部内部类：类似于局部变量
3. 使用内部类编写的代码，可读性很差，能不用尽量不用。
4. 匿名内部类是局部内部类的一种。因为这个类没有名字而得名，叫做匿名内部类。
5. 学习匿名内部类主要是在阅读别人代码的时候，能够理解。平时不建议用，有两个缺点：
   - 缺点1：太复杂，太乱，可读性差。
   - 缺点2：类没有名字，以后想重复使用，不能用。
<pre>
class Test01{
    // 静态变量
    static String country；
    // 该类在类的内部，所以称为内部类
    // 由于前面有static，所以称为“静态内部类”
    static class Inner1{
    }

    // 实例变量
    int age；
    // 该类在类的内部，所以称为内部类
    // 没有static叫做“实例内部类”
    class Inner2{
    }

    // 方法
    public void doSome(){
        // 局部变量
        int i = 100;
        // 该类在类的内部，所以称为内部类
        // 局部内部类
        class Inner3{
        }
    }

    public void doOther(){
        // doSome()方法中的局部内部类Inner3，在doOther()中不能用。
    }

    // 负责计算的接口
    interface compute(){

        // 抽象方法
        int sum(int x ,int y)
    }

    public static void main(){
        // 调用MaMyth中的mySum方法。
        Mymath mm = new MyMath();
        mm.mySum(new Compute(){
            public int sum(int a, int b){
                return a + b;
            }
        }, 200, 300)
    }

}

// 数学类
class MyMath{
    // 数学求和方法
    public void mySum(Compute c ,int x, int y){
        int retValue = c.sum(x ,y );
        System.out.println(x + "+" + y + "+" + "=" + reValue);  
    }
}
</pre>