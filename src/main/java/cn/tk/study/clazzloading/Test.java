package cn.tk.study.clazzloading;

/**
 * Created by xiedan on 2016/11/14.
 */
public class Test {
    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println("Test classloader: " + classLoader);
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println("Test parent classloader: " + classLoader1);
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println("Test grandparent classloader: " + classLoader2);
        ClassLoader classLoader3 = Integer.class.getClassLoader();
        System.out.println("Integer classloader: " + classLoader3);
    }
}
