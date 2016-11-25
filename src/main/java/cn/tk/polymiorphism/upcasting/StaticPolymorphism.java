package cn.tk.polymiorphism.upcasting;

/**
 * Created by xiedan11 on 2016/9/27.
 * 1.静态方法不具有多态性，因为静态方法也是在编译期进行解析，而多态性表现在运行期。
 * 2.多态，动态绑定，向上转型
 */
class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }
    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}
class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }
    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub ();     //upcast
        System.out.println (sup.dynamicGet ());
        System.out.println (sup.staticGet ());
    }
}
