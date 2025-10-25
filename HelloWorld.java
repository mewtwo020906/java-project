//public表示公开的
//class表示定义一个类
//HelloWorld表示一个类名
public class HelloWorld{ //表示定义一个公开的类，起名HelloWorld
    //类体中不允许直接编写java语句[除声明变量之外]
    
    /*
        public表示公开的
        static表示静态的
        void表示空
        main表示方法名是main
        (String[] args)是一个main方法的形式参数列表

        需要记住的是：
            以下的方法是一个程序的"主方法"，是程序的执行入口
            是SUN公司规定的，固定编写方式。
     */
    public static void main(String[] args){ //表示定义一个公开的静态的主方法
        
        //方法体
        //方法体
        //方法体
        //方法体
        //方法体
        //方法体
        

        //java语句[java语句以";"终止，分号必须是半角分号]
        //先记住；以下这样代码的作用是向控制台输出一段消息
        //以下的双引号必须是半角的双引号[是java语法的一部分]
        //java中所有的"字符串"都使用双引号括起来。
        System.out.println("Hello World!");

        //再向控制台输出消息
        System.out.println("Hello jackson!");

        //输出中文
        System.out.println("你好，杰克！");
        System.out.println("我是一个“程序员”");
    }
}