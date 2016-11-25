package cn.tk.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiedan11 on 2016/11/16.
 * 1.泛型在逻辑上可以看成多个类型，实际上都是相同的基本类型。
 * 2.通过使用泛型，可以在编译期防止将错误类型的对象放置到容器中。
 */
class Apple{}

class Orange{}

public class Test {
    public static void main(String[] args) {
        List<Apple> list1 = new ArrayList<Apple>();
        list1.add(new Apple());
        //list1.add(new Orange());  prevent from adding an Orange to apples
        List<Orange> list2 = new ArrayList<Orange>();
        System.out.println(list1.getClass() == list2.getClass());
    }
}
