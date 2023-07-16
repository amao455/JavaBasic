package org.example.threadLocal;

/**
 * ClassName: InheritableThreadLocalDemo
 * Description:
 *
 * @author MQW
 * @date 2023/7/16 16:28
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        threadLocal.set("父类数据：threadLocal");
        inheritableThreadLocal.set("父类数据：inheritableThreadLocal");

        // 在主线程下开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程通过ThreadLocal无法获取父线程的副本数据
                System.out.println("子线程获取父类ThreadLocal数据：" + threadLocal.get());
                // 子线程通过inheritableThreadLocal可以获取父线程的数据
                System.out.println("子线程获取父类inheritableThreadLocal数据：" + inheritableThreadLocal.get());
            }
        }).start();

    }


}
