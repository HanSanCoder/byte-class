package utils;

/**
 * @author ：何汉叁
 * @date ：2024/4/12 22:15
 * @description：TODO
 */
public class UserService {
    private String name = "hehansan";
    private User user = new User();
    public UserService(){
    }
    public UserService(User user) {
        this.user = user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
