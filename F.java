public class F{
    public static void main(String[] args){
        Student stu = new Student();
        Computer com = new Computer();
        stu.com = com;
        stu.no = 100;
        stu.name = "小智";
        com.brand = "联想";
        com.number = "拯救者";
        com.color = "黑色";
        System.out.println("该学生的学号是:" + stu.no);
        System.out.println("该学生使用的笔记本是:" + stu.com.brand + "," + stu.com.number + "," + stu.com.color);
    } 
}
class Computer{
    //品牌
    String brand;
    //型号
    String number;
    //颜色
    String color;
}
class Student{
    //学号
    int no;
    //姓名
    String name;
    //学生有一台笔记本电脑
    Computer com;
    
}