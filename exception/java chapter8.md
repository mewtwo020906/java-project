- [异常](#异常)
  - [什么是异常，java提供异常处理机制有什么用？](#什么是异常java提供异常处理机制有什么用)
  - [java语言中异常是以什么形式存在的呢？](#java语言中异常是以什么形式存在的呢)
    - [关于Throwable、Error与Exception类](#关于throwableerror与exception类)
      - [运行时异常案例](#运行时异常案例)
      - [编译时异常案例](#编译时异常案例)
    - [java语言中对异常的处理包括两种方式：](#java语言中对异常的处理包括两种方式)
      - [第一种处理方式：上抛](#第一种处理方式上抛)
      - [第二种处理方式：try...catch进行捕捉](#第二种处理方式trycatch进行捕捉)
      - [异常捕捉和上报的联合使用](#异常捕捉和上报的联合使用)
      - [深入try...catch](#深入trycatch)
      - [上报和捕捉怎么选择](#上报和捕捉怎么选择)
    - [异常对象的常用方法](#异常对象的常用方法)
    - [final关键字](#final关键字)
    - [final finally finalize有什么区别](#final-finally-finalize有什么区别)
  - [java中如何自定义异常](#java中如何自定义异常)
  - [异常在实际开发中的作用](#异常在实际开发中的作用)
  - [异常与方法覆盖](#异常与方法覆盖)
  - [总结异常中的关键字](#总结异常中的关键字)
  - [UML以及starUML](#uml以及staruml)
  - [异常作业案例](#异常作业案例)

# 异常
## 什么是异常，java提供异常处理机制有什么用？
1. 程序在执行过程中发生了不正常的情况，而这种不正常的情况叫做：异常
2. java语言是很完善的语言，提供了异常的处理方式，以下程序执行过程中出现了不正常情况，java把该异常信息打印输出到控制台，供程序员参考。程序员看到异常信息之后，可以对程序进行修改，让程序更加的健壮。
- 什么是异常:程序执行过程中的不正常过程。
- 异常的作用：增强程序的健壮性。
3. 程序执行出现了:
<pre>
 Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Test.main(Test.java:5)
// 这个信息被我们称为:异常信息。这个信息是JVM打印的。
</pre>
## java语言中异常是以什么形式存在的呢？
1. 异常在java中以类的形式存在，每一个异常类都可以创建异常对象。
<pre>
        // 通过"异常类"实例化"异常对象"
        NumberFormatException nfe = new NumberFormatException("数字格式化异常！");

        // java.lang.NumberFormatException:数字格式化异常！
        System.out.println(nfe);

        //通过"异常类"创建"异常对象"
        NullPointerException npe = new NullPointerException("空指针异常发生了！");

        // java.lang.NullPointerException:空指针异常发生了！
        System.out.println(npe);

</pre>
2. 异常对应的现实生活中是怎么样的？
- 火灾(异常类):
  - 2008年8月8日，小明家着火了(异常对象)
  - 2008年8月9日，小刚家着火了(异常对象)
  - 2008年9月8日，小红家着火了(异常对象)
3. 类是模板，对象是实际存在的个体

### 关于Throwable、Error与Exception类
1. Object下有Throwable(可抛出的)
2. Throwable下有两个分支:Error(不可处理，直接退出JVM)和Exception(可处理的)
3. Exception下有两个分支：一个是Exception的直接子类，一个是RuntimeException
4. 所有的错误只要发生，java程序只有一个结果那就是终止程序的执行。退出JVM，错误是不能处理的
5. 不管是错误，还是异常，都是可抛出的
6. ExceptionSubClass是Exception的直接子类。所有Exception的直接子类，都叫做编译时异常。编译时异常是在编译阶段发生的吗？不是。编译时异常是表示必须在编写程序的时候预先对这种异常进行处理，如果不处理编译器报错。
7. 所有的RuntimeException及子类都属于运行时异常。运行时异常在编写程序阶段，你可以选择处理，也可以不处理。
8. 编译时异常和运行时异常，都是发生在运行阶段。编译阶段异常是不会发生的。编译时异常因为什么而得名
   - 因为编译时异常必须在编译阶段预先处理，如果不处理编译器报错，因此得名。
   - 所有异常都是在运行阶段发生的。因为只有程序运行阶段才可以new对象。
   - 因为异常的发生就是new异常对象。
9. 编译时异常和运行时异常的区别?
   - 编译时异常一般发生的概率比较高。
   - 运行时异常一般发生的概率比较高。

**编译时异常又被称为受检异常，还有叫做受控异常(CheckException)。运行时异常又被称为未受检异常，或者叫非受控异常(UnCheckException)**

#### 运行时异常案例
<pre>
        /*
        程序执行到此处发生了ArithmeticException异常，
        底层new了一个ArithmeticException异常对象，
        然后抛出了，由于是main方法调用了100 / 0.
        所以这个异常ArithmeticException抛给了main方法，
        main方法没有处理，将这个异常自动抛给了JVM。
        JVM最终终止程序的执行。

        ArithmeticException继承RuntimeException，属于运行时异常。
        在编写程序阶段不需要对这种异常进行预先的处理。
         */
        System.out.println(100 / 0);

        // 这里的HelloWorld没有输出，没有执行
        System.out.println("Hello World!");
</pre>

#### 编译时异常案例
<pre>
    /*
    以下代码报错的原因是什么？
        因为doSome()方法声明位置上使用了:throws ClassNotFoundException
        而ClassNotFoundException是编译时异常。必须编写代码时处理，没有处理编译器报错。
     */
    public static void main(String[] args) {
        // main方法中调用doSome()方法
        // 因为doSome()方法声明位置上有：throws ClassNotFoundException
        // 我们在调用doSome()方法的时候必须对这种异常进行预先的处理。
        // 如果不处理，编译器就报错。
        // 编译器报错信息：Unhandled exception：java.lang.ClassNotFoundException
        doSome();

    }
    /**
     *  doSome方法在方法声明的位置上使用了：throws ClassNotFoundException
     *  这个代码表示doSome()方法在执行过程中，有可能会出现ClassNotFoundException异常。
     *  叫做类没找到异常。这个异常直接父类是：Exception，所以ClassNotFoundException属于编译时异常。
     * @throws ClassNotFoundException
     */
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
</pre>

### java语言中对异常的处理包括两种方式：
1. 第一种方式：在方法声明的位置上，使用throws关键字，抛给上一级。
- 谁调用我，我就抛给谁。抛给上一级
2. 第二种方式：使用try...catch语句进行异常的捕捉。
- 这件事发生了，谁也不知道。因为我给抓住了。
3. 异常发生后，如果我选择上抛，抛给了我的调用者，调用者需要对这个异常继续处理，那么调用者处理这个异常同样有两种处理方式。
4. java中异常发生之后如果一直上抛，最终抛给了main方法，main方法继续向上抛，抛给了调用者JVM，JVM知道这个异常发生，只有一个结果。终止java程序的执行。

#### 第一种处理方式：上抛
<pre>
    // 第一种处理方式：在方法声明的位置上继续使用：throws，来完成异常的上抛。抛给调用者。
    // 上抛类似于推卸责任。(继续把异常传递给调用者)
    public static void main(String[] args) throws ClassNotFoundException {
        doSome();
    }

    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
</pre>

#### 第二种处理方式：try...catch进行捕捉
<pre>
    // 第二种处理方式：在方法声明的位置上继续使用：throws，来完成异常的上抛。抛给调用者。
    // 捕捉等于把异常拦下来了，异常真正的解决了。(调用者是不知道的。)
    public static void main(String[] args) {
        try{
            doSome();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
</pre>

#### 异常捕捉和上报的联合使用
<pre>
/*
处理异常的第一种方式：
    在方法声明的位置上使用throws关键字抛出。谁调用我这个方法，我就抛给谁。抛给调用者来处理。
    在种处理异常的态度：上报。
处理异常的第二种方式：
    使用try...catch语句对异常进行捕捉。
    这个异常不会上报，自己把这个事儿处理了。
    异常抛到此处为止，不在上抛了。
 */
    public static void main(String[] args) {
        // 一般不建议在main方法上使用throws，因为这个异常如果真正的发生了，一定会抛给JVM。JVM只有终止
        // 异常处理机制的作用就是增强程序的健壮性。怎么能做到，异常发生了也不影响程序的执行。所以
        // 一般main方法中的异常建议使用try...catch进行捕捉。main就不要继续上抛了。
        System.out.println("main begin");
        try{
            // try尝试
            m1();
            // 以上代码出现异常，直接进入catch语句块中执行。
            System.out.println("hello world!");
        }catch (FileNotFoundException e){
            // 这个分支中可以使用e引用，e引用保存的内存地址是那个new出来异常对象的内存地址。
            // catch是捕捉异常之后走的分支。
            e.printStackTrace();
            System.out.println(e);
        }

        // try...catch把异常抓住之后，这里的代码会继续执行。
        System.out.println("main over");
    }

    public static void m1() throws FileNotFoundException {
        System.out.println("m1 begin");
            m2();
        System.out.println("m1 over");
    }

    // 抛别的不行，抛ClassCastException说明还是没有对FileNotFoundException进行处理
    // public static void m2() throws ClassCastException

    // 抛FileNotFoundException的父对象IOException，这样是可以的。因为IOException包括FileNotFoundException
    // public static void m2() throws IOException

    // 这样也可以，因为Exception包括所有的异常。
    // public static void m2() throws Exception

    // throws后面也可以写多个异常，可以使用逗号隔开。
    // public static void m2() throws ClassCastException，FileNotFoundException

    public static void m2() throws FileNotFoundException {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    public static void m3() throws FileNotFoundException {
        // 调用SUN jdk中某个类的构造方法
        // 创建一个输入流对象，该流指向一个文件
        /*
        编译报错的原因是什么？
            第一：这里调用了一个构造方法：FileInputStream(String name)
            第二：这个构造方法的声明位置上有：throws FileNotFoundException
            第三：通过类的继承结构看到：FileNotFoundException父类是IOException，
            IOException的父类是Exception，最终得知，FileNotFoundException是编译时异常。
         */

         // 第一种处理方式：在方法声明的位置上使用throws继续上抛。
         // 一个方法体当中的代码出现异常之后，如果上报的话，此方法结束。
        new FileInputStream("D:\\pokemon\\HoennRegion\\星空倒影(120公路).png");

    }
</pre>
**只要异常没捕捉，采用上报的方式，此方法的后续代码不会执行**
**另外需要注意，try语句块中的某一行出现异常，该行后面的代码不会执行**
**try...catch捕捉异常之后，后续代码可以执行。**

#### 深入try...catch
1. 编译报错
<pre>
        try{
            FileInputStream fis = new FileInputStream("D:\\pokemon\\Hoenn Region\\星空倒影(120公路).png");
        }catch(NullPointerException e){

        }
</pre>

2. 正常通过
<pre>
        try{
            FileInputStream fis = new FileInputStream("D:\\pokemon\\Hoenn Region\\星空倒影(120公路).png");
            System.out.println("以上出现异常，这里无法执行！");
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        System.out.println("hello world!");
</pre>

3. 多态:catch后面的小括号中的类型可以是具体的异常类型，也可以是该异常类型的父类型
<pre>
   IOException e = new FileNotFoundException();
        try{
            FileInputStream fis = new FileInputStream("D:\\pokemon\\Hoenn Region\\星空倒影(120公路).png");
            System.out.println("以上出现异常，这里无法执行！");
        }catch(IOException e){
            System.out.println("File not found");
        }
</pre>

4. catch可以写多个。建议catch的时候，精确的一个一个处理。这样有利于程序的调式。
<pre>
        try{
            // 创建输入流
            FileInputStream fis = new FileInputStream("D:\\pokemon\\Hoenn Region\\星空倒影(120公路).png");
            // 读文件
            fis.read();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Error reading file");
        }
</pre>

5. catch写多个的时候，从上到下，必须遵守从小到大
<pre>
        // 编译报错
        try{
            // 创建输入流
            FileInputStream fis = new FileInputStream("D:\\pokemon\\Hoenn Region\\星空倒影(120公路).png");
            // 读文件
            fis.read();
        }catch(IOException e){
            System.out.println("Error reading file");
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
</pre>

6. catch里面支持"多个异常"
<pre>
        try{
            // 创建输入流
            FileInputStream fis = new FileInputStream("D:\\pokemon\\Hoenn Region\\星空倒影(120公路).png");
            // 进行数学运算
            // 该异常是运行时异常，编写程序时可以处理，也可以不处理
            System.out.println(100 / 0);
        }catch(FileNotFoundException | ArithmeticException | NullPointerException e){
            System.out.println("文件不存在？数学异常？空指针异常？都有可能");
        }
</pre>

#### 上报和捕捉怎么选择
- 在以后的开发中，处理编译时异常，应该上报还是捕捉呢，怎么选？
  - 如果希望调用者来处理，选择throws上报。
  - 其他情况使用捕捉的方式

### 异常对象的常用方法
1. 获取异常简单的描述信息：
   - String msg = exception.getMessage();
2. 打印异常追踪的堆栈信息：
   - exception.printStackTrace();
<pre>
        // 这里只是new了异常对象，但是没有将异常对象抛出。JVM会认为这是一个普通的java对象。
        NullPointerException e = new NullPointerException("空指针异常");

        // 获取异常简单描述信息
        String msg = e.getMessage();
        System.out.println(msg);

        // 打印异常堆栈信息
        // java后代打印异常堆栈追踪信息的时候，采用了异步线程的方式打印的
        e.printStackTrace();

        System.out.println("Hello World");
</pre>
3. 我们以后查看异常的追踪信息，我们应该怎么看，可以快速地调式程序呢？
   - 异常信息追踪信息，从上往下一行一行看。
   - 但是需要注意的是：SUN写的代码就不用看了。(看包名区分)
   - 主要的问题是出现在自己编写的代码上。
<pre>
    public static void main(String[] args) {
        try{
            m1();
        }catch(FileNotFoundException e){
            // 打印异常堆栈追踪信息！！！
            // 在实际的开发中，建议使用这个。养成好习惯！
            e.printStackTrace();
            /*
            java.io.FileNotFoundException: D:\pokemon\HoennRegion\星空倒影(120公路).png (系统找不到指定的路径。)
                at java.base/java.io.FileInputStream.open0(Native Method)
                at java.base/java.io.FileInputStream.open(FileInputStream.java:185)
                at java.base/java.io.FileInputStream.<init>(FileInputStream.java:139)
                at java.base/java.io.FileInputStream.<init>(FileInputStream.java:109)
                at Test.m3(Test.java:39)
                at Test.m2(Test.java:35)
                at Test.m1(Test.java:31)
                at Test.main(Test.java:8)
             */
        }

        // 这里程序不耽误执行，很健壮。(服务器不会因为遇到异常而宕机)
        System.out.println("Hello World");
    }

    public static void m1() throws FileNotFoundException {
        m2();
    }

    public static void m2() throws FileNotFoundException {
        m3();
    }

    public static void m3() throws FileNotFoundException {
        new FileInputStream("D:\\pokemon\\HoennRegion\\星空倒影(120公路).png");
    }
</pre>

### final关键字
1. 在finall子句中的代码是最后执行的，并且是一定会执行的，即使try语句块中的代码出现了异常。
   - finally子句必须和try一起出现，不能单独编写。
2. finally语句通常使用在哪些情况下呢？
   - 通常在finally语句块中完成资源的释放/关闭。
   - 因为finally中的代码比较有保障。
   - 即使try语句块中的代码出现异常，finally中代码也会正常执行。
<pre>
    public static void main(String[] args) {
        FileInputStream fis = null;
        try{
            // 创建输入流对象
            fis = new FileInputStream("D:\\pokemon\\HoennRegion\\星空倒影(120公路).png");
            // 开始读文件...

            String s = null;
            // 这里一定会出现空指针异常！
            s.toString();
            System.out.println("hello world!");

            // 流使用完需要关闭，因为流是占用资源的。
            // 即使以上程序出现异常，流也必须要关闭！
            // 放在这里有可能流关不了。
            // fis.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(NullPointerException e){
            e.printStackTrace();
        }finally{
            System.out.println("hello");
            // 流的关闭放在这里比较保险。
            // finally中的代码是一定会执行的。
            // 即使try中出现了异常！
            if(fis != null){ // 避免空指针异常！
                try {
                    // close()方法有异常，采用捕捉的方式。
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println("hello world!");
    }
 
</pre>

3. 放在finally语句块中的代码是一定会执行的
<pre>
        /*
        try和finally，没有catch可以吗？可以。
            try不能单独使用。
            try finally可以联合使用。
        以下代码的执行顺序：
            先执行try...
            再执行finally...
            最后执行 return(return语句只要执行方法必然结束。)
         */
        try{
            System.out.println("try...");
            return;
        } finally {
            // finally中的语句会执行。能执行到。
            System.out.println("finally...");
        }
</pre>

4. 有个特殊情况
<pre>
        try{
            System.out.println("try...");
            // 退出JVM
            System.exit(0);// 退出JVM之后，finally语句中的代码就不执行了！
        } finally {
            System.out.println("finally...");
        }
</pre>

5. 有关于final的面试题
<pre>
    public static void main(String[] args) {
        int result = m();
        System.out.println(result);
    }

    /*
    java语法规则(有一些规则是不能破坏的，一旦这么说了，就必须这么做！)：
        java中这样的规则：
            方法体中的代码必须遵循自上而下顺序依次逐行执行
            returun语句一旦执行，整个方法必须结束
     */
    public static int m() {
        int i = 100;
        try{
            // 这行代码出现在int i = 100；下面，所以最终结果必须是返回100
            // return语句还必须保证是最后执行的。一旦执行，整个方法结束。
            return i;
        }finally{
            i++;
        }
    }

    /*
    反编译之后的效果
    public static int m(){
        int i = 100;
        int j = i;
        i++;
        return j;
    }
     */
</pre>

### final finally finalize有什么区别
1. final关键字
   - final修饰的类无法继承
   - final修饰的方法无法覆盖
   - final修饰的变量不能重新赋值
2. finally关键字
   - 和try一起联合使用。
   - finally语句块中的代码是必须执行的。
3. finalize标识符
   - 是一个Object类中的方法名,这个方法是由垃圾回收器GC负责调用的。
<pre>
public static void main(String[] args) {

        // final是一个关键字。表示最终的，不变的。
        final int i = 100;
        // i = 200;

        // finally也是一个关键字，和try联合使用，使用在异常处理机制中
        // 在finally语句块中的代码是一定会执行的。
        try {

        } finally {
            System.out.println("finally......");
        }

        // finalize()是Object类中的一个方法。作为方法名出现，
        // 所以finalize是标识符。
        Object obj;
    }
}

// final修饰的类无法继承
final class A{
    // 常量
    public static final double MATH_PI = 3.1415926;
}

class B{
    // final修饰的方法无法覆盖
    public final void doSome(){

    }
</pre>

## java中如何自定义异常
1. SUN提供的JDK内置的异常肯定是不够用的。在实际的开发中，有很多业务，这些业务出现异常之后，JDK中都是没有的。和业务挂钩的。那么异常类我们程序员可以自己定义吗？
   - 可以。
2. java中怎么自定义异常呢？
   - 第一步：编写一个类继承Exception或者RuntimeException。
   - 第二步：提供两个构造方法，一个无参数的，一个带有String参数的。
<pre>
public class Test {
    public static void main(String[] args) {

        // 创建异常对象(只new了异常对象，并没有手动抛出)
        MyException e = new MyException("用户名不能为空！");

        // 打印异常堆栈信息
        e.printStackTrace();

        // 获取异常简单描述信息
        String msg = e.getMessage();
        System.out.println(msg);
    }
}

/*
public class MyException extends Exception{ // 编译时异常
    public MyException() {

    }
    public MyException(String s) {
        super(s);
    }
}
 */


/*
public class MyException extends RuntimeException{ // 运行时异常

}
 */
</pre>

## 异常在实际开发中的作用
**详细看弹栈压栈与异常结合的案例。StackCase。**

## 异常与方法覆盖
- 重写之后的方法不能比重写之前的方法抛出更多(更宽泛)的异常，可以更少。
<pre>
class Animal{
    public void doSome(){

    }

    public void doOther() throws Exception{

    }
}

class Cat extends Animal{
    // 编译报错。
    /* public void doSome() throws Exception{

    } */

    // 编译正常
    /* public void doOther(){

    } */

    // 编译正常
    /* public void doOther() throws Exception{
        
    } */

    // 编译正常
    public void doOther() throws NullPointerException{

    }
}
</pre>

## 总结异常中的关键字
1. 异常捕捉：
   - try
   - catch
   - finally
   - throws 在方法声明位置上使用，表示上报异常信息给调用者。
   - throw 手动抛出异常！




## UML以及starUML
1. UML是一种统一建模语言，一种图标式语言
2. UML不是只有java中使用，只要是面向对象的编程语言，都有UML。
3. 一般画UML图的都是软件架构师或者说是系统分析师。这些级别的人员使用的。软件设计人员使用UML。
4. 在UML图中可以描述类和类之间的关系，程序执行的流程，对象的状态等
5. 在java软件开发当中，软件分析师/设计师负责设计类，java软件开发人员必须要能看懂。

## 异常作业案例
编写程序模拟用户注册：
1. 程序开始执行时，提示用户输入”用户名“和”密码“信息。
2. 输入信息之后，后台java程序模拟用户注册
3. 注册时用户名要求长度在[6 - 14]之间，小于或者大于都表示异常
**详细请见UserCase**


注意：
    完成注册的方法放到一个单独的类中。
    异常类自定义即可。

    class UserService{
        public void register(String username, String password)
            //这个方法中完成注册！
    }

    编写main方法，在main方法中接受用户输入的信息，在main方法中调用UserService的regiseter方法完成注册。

开放型题目，随意发挥：
    写一个类Army，代表一支军队，这个类有一个属性Weapon数组(用来存储该军队所拥有的所有)该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大并用这一大小来初始化数组w。

    该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组w中。在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击；以及moveAll()让w数组中的所有可移动的武器移动。

    写一个主方法去测试以上程序。

    提示：
        Weapon是一个父类。应该有很多子武器。这些子武器应该有一些是可移动的，有一些是可攻击的。