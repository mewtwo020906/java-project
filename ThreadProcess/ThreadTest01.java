package ThreadProcess;
/*
该程序除了垃圾回收线程之外。有1个线程。(因为程序只有1个栈)
main begin
m1 begin
m2 begin
m3 execute
m2 over
m1 over
main over
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }

    private static void m1() {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    private static void m3() {
        System.out.println("m3 execute");
    }

}
