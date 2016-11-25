package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/10/13.
 */
class Base1 {
    static {
        System.out.println ("Base1 static block");
    }
    {
        System.out.println ("Base block");
    }

    public Base1() {
        System.out.println ("Base constructor");
    }
}
public class Derived extends Base1 {
    static {
        System.out.println ("Derived static block");
    }
    {
        System.out.println ("Derived block");
    }

    public Derived() {
        System.out.println ("Derived construction");
    }
    public static void main(String[] args) {
        new Derived ();
    }
}
