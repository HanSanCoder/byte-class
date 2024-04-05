/**
 * @author ：何汉叁
 * @date ：2024/4/5 12:44
 * @description：TODO
 */
public class ThreadLocalDemo {
    ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.showTowThread();
    }
    //这里Runnable是接口，如果想创建一个Thread建议使用这种方式，避免多继承造成的问题
    //回顾知识点下面的匿名类是如何使用的？
    public void showTowThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("Thread1");
                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("Thread2");
                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            }
        }).start();
    }
}
