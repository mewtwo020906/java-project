package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest01 {
    public static void main(String[] args) {
        /*
        // 不使用泛型机制，分析程序存在缺点
        List mylist = new ArrayList();

        // 准备对象
        Cat c = new Cat();
        Bird b = new Bird();

        // 将对象添加到集合当中
        mylist.add(c);
        mylist.add(b);

        // 遍历集合，取出Cat让它抓老鼠，取出Bird让它飞！
        Iterator it = mylist.iterator();
        while(it.hasNext()){
            // 没有这个语法，通过迭代器取出的就是Object
            // Animal a = it.next();

            Object obj = it.next();
            // obj中没有move方法，无法调用，需要向下转型！
            if(obj instanceof Cat){
                Animal a = (Animal) obj;
                a.move();
            }
        }

         */

        // 使用JDK5之后的泛型机制
        // 使用泛型List<Animal>之后，表示List集合中只允许存储Animal类型的数据。
        // 用泛型来指定集合中存储的数据类型。
        List<Animal> myList = new ArrayList<Animal>();

        // 指定List集合中只能存储Animal，那么存储String就编译报错了。
        // 这样用了泛型之后，集合中元素的数据类型更加统一了。
        // myList.add("abc");

        Cat c =  new Cat();
        Bird b = new Bird();

        myList.add(c);
        myList.add(b);

        // 获取迭代器
        // 这个表示迭代器迭代的是Animal类型。
        Iterator<Animal> it = myList.iterator();
        while(it.hasNext()){
            // 使用泛型之后，每一次迭代返回的数据都是Animal类型。
            // Animal a = it.next();
            // 这里不需要进行强制类型转换了。直接调用。
            // a.move();

            // 调用子类特有的方法还是需要向下转换的！
            Animal a = it.next();
            if(a instanceof Cat){
                Cat cat = (Cat)a;
                cat.catchMouse();
            }
            if(a instanceof Bird){
                Bird bird = (Bird)a;
                bird.fly();
            }
        }

    }
}

class Animal{
    // 父类自带方法
    public void move(){
        System.out.println("动物在移动！");
    }
}

class Cat extends Animal{
    // 特有方法
    public void catchMouse(){
        System.out.println("猫抓老鼠！");
    }

}

class Bird extends Animal{
    // 特有方法
    public void fly(){
        System.out.println("鸟儿在飞翔！");
    }

}
