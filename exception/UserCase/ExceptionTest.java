package exception.UserCase;


public class ExceptionTest {
    public static void main(String[] args) {
        // 创建UserService对象
        UserService userService = new UserService();
        // 用户名和密码就不再从控制台接受了
        try{
            userService.register("mewtwo","ciallo");
        }catch (IrrationalNameException e){
            // System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
