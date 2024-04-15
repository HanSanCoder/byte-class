import java.io.FileInputStream;

/**
 * @author ：何汉叁
 * @date : 2024/4/15 21:24
 * @description：TODO
 */
public class TryWithResource_Demo {
    /**
     *      47: invokevirtual #34                 // Method java/io/FileInputStream.close:()V
     *       50: goto          69
     *       53: astore_2
     *       54: aload_1
     *       55: invokevirtual #34                 // Method java/io/FileInputStream.close:()V
     *       JDK17中通过直接javap可以看出我们在try中的代码块执行完毕后会自动调用close方法关闭资源
     *       但好像JDK8中也有这个特性
     */
    public void tryWithResource() {
        try (FileInputStream fileInputStream = new FileInputStream("D:/testJDK.txt")) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
