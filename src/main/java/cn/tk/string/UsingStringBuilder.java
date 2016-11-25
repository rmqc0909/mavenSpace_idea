package cn.tk.string;

import java.util.Random;

/**
 * Created by xiedan11 on 2016/10/10.
 * 1.当为一个类编写toString()方法时，如果字符串操作比较简单，则可以信赖编译器，它会合理构造最终的字符串结果。
 * 如果要在toString()方法中使用循环，那么最好自己创建一个StringBuilder对象，用以构造最终的结果，如下：
 * 2.StringBuffer是线程安全的，因此开销也会大些。
 */
public class UsingStringBuilder {
    private static Random random = new Random (47);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder ("[");
        for (int i = 0; i < 25; i++) {
            result.append (random.nextInt (100));
            result.append (", ");
        }
        result.delete (result.length () - 2, result.length ());
        result.append ("]");
        return result.toString ();
    }
    public static void main(String[] args){
        UsingStringBuilder usb = new UsingStringBuilder ();
        System.out.println (usb);
    }
}
