public class User {
    public User(){
        System.out.println("User类的无参构造方法被调用");
    }
    public User(String name){
        System.out.println("User类的有参构造方法被调用，name参数值为：" + name);
    }
    public User(int age){
        System.out.println("User类的有参构造方法被调用，age参数值为：" + age);
    }
    public User(String name, int age){
        System.out.println("User类的有参构造方法被调用，name参数值为：" + name + "，age参数值为：" + age);
    }
    private int no;
    private String name;
    private int age;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
