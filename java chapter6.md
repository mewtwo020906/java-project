# 数组
## 概述
1. java语言中的数组是一种引用数据类型。不属于基本数据类型。数组的父类是Object。
2. 数组实际上是一个容器，可以同时容纳多个元素。(数据是一个数据的集合。)
3. 数据当中可以存储“基本数据类型”的数据，也可以存储“引用数据类型”的数据。
4. 数组因为是引用类型，所以数据对象是堆内存当中。(数组是存储在堆当中的)
5. 数组当中如果存储的是“java对象”的话，实际上存储的是对象的“引用(内存地址)”
6. 数组一旦创建，在java中规定，长度不可变。(数组长度不可变)
7. 数组的分类：一维数组、二维数组、三维数组、多维数组...(一维数组较多，二维数组偶尔使用！)
8. 所有的数组对象都有length属性(java自带的)，用于获取数组中元素的个数。
9. java中的数组要求数组中元素的类型统一，比如int类型数组只能存储int类型，Person类型数组只能存储Person类型。
10. 数组在内存方面存储的时候，数组中的元素内存地址(存储的每一个元素都是由规则的挨着排列的)是连续的。内存地址连续这是数组存储元素的特点(特色)。数组实际上是一种简单的数据结构。
11. 所有的数组都是拿“第一个小方框的内存地址”作为整个数组对象的内存地址。(数组中首元素的内存地址作为整个数组对象的内存地址)
12. 数组中每一个元素都是有下标的，下标从0开始，以1递增。最后一个元素的下标是：Length - 1。下标非常重要，因为我们对数组中元素进行“存取”的时候，都需要通过下标来进行
13. 数组这种数据结构的优点和缺点是什么？
    - 优点：查询/查找/检索某个下标上的元素时效率极高。可以说是查询效率最高的一个数据结构。
      - 为什么检索效率高？
        - 第一：每一个元素的内存地址在空间存储上是连续的。
        - 第二：每一个元素类型相同，所以占用空间大小一样。
        - 第三：知道第一个元素内存地址，知道每一个元素占用空间的大小，又知道下标，所以通过一个数学表达式就可以计算出某个下标上元素的内存地址。直接通过内存地址定位元素，所以数组的检索效率是最高的。
        - 数组中存储100个元素，或者存储1000个元素，在元素查询/检索方面，效率是相同的，因为数组中元素查找的时候不会一个一个找，是通过数学表达式计算出来的。(算出一个内存地址，直接定位的。)
    - 缺点：
      - 第一：由于为了保证数组中每个元素的内存地址连续，所以在数组上随机删除或者增加元素的时候，效率较低，因为随机增删元素会涉及到后面元素统一向前或者向后位移的操作。
      - 第二：数组不能存储大数据量，为什么？
        - 因为很难在内存空间上找到一块特别大的连续的内存空间。
    **注意：对于数组中最后一个元素的增删，是没有效率影响的**
## 一维数组
### 定义/初始化一维数组
1. 怎么声明/定义一个一维数组？
   - 语法格式：
     - int[] array1;
     - double[] array2;
     - Object[] array3;
2. 怎么初始化一个一维数组？
   - 包括两种方式：静态初始化一维数组，动态初始化一维数组
   - 静态初始化语法格式：
     - int[] array = {100， 2100， 300，55}；
   - 动态初始化语法格式：
     - int[] array = new int[5]; 
       - 这里的5表示数组的元素个数。
       - 初始化一个5个长度的int类型数组，每个元素默认值0
     - String[] names = new String[6]；
       - 初始化6个长度的String类型数组，每个元素默认值null。

**ArrayIndexOutOfBoundsException(数组越界异常)**

3. 什么时候采用静态初始化方式，什么时候使用动态初始化方式呢？
   - 当你创建数组的时候，确定数组中存储哪些具体的元素时，采用静态初始化方式。
   - 当你创建数组的时候，不确定将来数组中存储哪些数据，你可以采用动态初始化的方式，预先分配内存空间。
4. 如果形参要传递数组，而且以静态的方式，必须这样写
   - printArray(new int[]{1,2,3});
### 分析main方法的形参
1. main方法上面的“String[] args”有什么用？
   - JVM调用main方法的时候，会自动传一个String数组过来。
   - 这个数组对象的长度默认为0
   - 这个数组是留给用户的，用户可以在控制台上输入参数，这个参数自动会被转换为“String[] args”
   - 所以main方法上面的String[] args数组主要是用来接收用户输入参数的。
### 数组结合多态
<pre>
public class ArrayTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Cat();
        animals[1] = new Dog();

        for (int i = 0; i < animals.length; i++) {
            animals[i].move();
        }

        for (int i = 0; i < animals.length; i++) {
            if(animals[i] instanceof Cat){
                Cat cat = (Cat) animals[i];
                cat.catchMouse();
            }else if(animals[i] instanceof Dog){
                Dog dog = (Dog) animals[i];
                dog.eatBones();
            }
        }
    }

}

class Animal{
    public void move(){
        System.out.println("Animal is moving");
    }
}

class Cat extends Animal{
    public void move(){
        System.out.println("Cat is moving");
    }
    public void catchMouse(){
        System.out.println("Cat is catching");
    }
}

class Dog extends Animal{
    public void move() {
        System.out.println("Dog is moving");
    }
    public void eatBones() {
        System.out.println("Dog is eating");
    }
}
</pre>
### 关于一维数组的扩容
- 先新建一个大容量的数组，然后将小容量数组中的数据一个一个拷贝到大数组当中。
- 数组扩容效率较低。因为涉及到拷贝的问题，所以在以后的开发中注意：尽可能少的进行数组的拷贝。可以在创建数组对象的时候预估一下多长合适，最好预估准备，这样可以减少数组的扩容次数。提高效率。
- 关于数组的拷贝：调用System.arraycopy(5个参数)

## 二维数组
### 定义/初始化二维数组
1. 二维数组其实是一个特殊的一维数组，特殊在这个一维数组当中的每一个元素都是一个一维数组。
2. 三维数组是一个特殊的二维数组，特殊在这个二维数组当中的每一个元素都是一个二维数组。实际的开发中使用最多的就是一维数组。二维数组也很少使用。三维数组几乎不用。
3. 二维数组静态初始化
   - int[][] array = {{1,1,1},{2,2,2},{3,3,3}}
4. 二维数组动态初始化
   - int[][] array = new int[3][4]
5. 如果形参要传递数组，而且以静态的方式，必须这样写
   - printArray(new int[][]{{1,2,3},{2,3,4,},{4,5,6}});

## 两道练习题
### 数组模拟栈数据结构
<pre>
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

</pre>