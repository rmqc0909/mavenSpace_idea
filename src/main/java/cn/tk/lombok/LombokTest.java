package cn.tk.lombok;

import org.junit.Test;

/**
 * Created by xiedan11 on 2016/11/28.
 */
public class LombokTest {

    @Test
    public void test() {
        GetterSetterExample getterSetterExample = new GetterSetterExample();
        int age = getterSetterExample.getAge();
        System.out.println("age:" + age);
        String name = getterSetterExample.getName();
        System.out.println("name:" + name);
    }
}
