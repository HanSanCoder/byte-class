import java.util.ArrayList;

/**
 * @author ：何汉叁
 * @date : 2024/4/15 20:58
 * @description：TODO
 */
public class ForEachDemo {
    /**
     * 通过字节码可以看出forEach自动调用了迭代器通过while循环实现对元素的遍历
     */
    private void forEachDemo() {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        for(String s : list) {
            System.out.println(s);
        }
    }

//    public static void main(String[] args) {
//        ForEachDemo forEachDemo = new ForEachDemo();
//        forEachDemo.forEachDemo();
//    }
}
