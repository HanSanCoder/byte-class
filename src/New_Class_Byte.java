import utils.User;
import utils.UserService;

/**
 * @author ：何汉叁
 * @date ：2024/4/12 22:11
 * @description：TODO
 */
public class New_Class_Byte {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = userService.getUser();
        String name = userService.getName();
        System.out.println(user.getId());
        System.out.println(name);
    }
}
