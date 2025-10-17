public class F{
    public static void main(String[] args){
        Student s = new Student();
        System.out.println("学号 = " + s.no);
        System.out.println("姓名 = " + s.name);
        System.out.println("年龄 = " + s.age);
        System.out.println("性别 = " + s.sex);
        System.out.println("住址 = " + s.address);

        s.no = 1;
        s.name = "张三";
        s.age = 20;
        s.sex = true;
        s.address = "北京市海淀区";
        System.out.println("学号 = " + s.no);
        System.out.println("姓名 = " + s.name);
        System.out.println("年龄 = " + s.age);
        System.out.println("性别 = " + s.sex);
        System.out.println("住址 = " + s.address);
    }

}