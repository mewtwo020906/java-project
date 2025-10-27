
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
10. 注释：
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