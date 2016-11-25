package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/20.
 *
 * 1.使用final方法：将方法锁定，以防任何继承类修改它的含义
 * 2.override；覆盖的意思，jdk自带的一个注解，表示该方法是继承或者实现的方法，若加了该注解，它的父类没有该方法，则ide会报错，不加也可以，但是加上增强了可读性，是一种强制性的覆盖。
 * 这种机制其实是将运行期错误放到编译器进行处理。
 * 3.final修饰的类不允许被继承，final类中所有的方法的指定为final，因为无法覆盖它们。
 */
class WithFinals {
    public final void f() { System.out.println ("WithFinals.f()");}
    public void g() { System.out.println ("WithFinals.g()");}
    public void k() { System.out.println ("WithFinals.k()");}
}
class OverridingPrivate extends WithFinals {
    //public final void f() { System.out.println ("OverridingPrivate.f()");}    final修饰的方法不能被覆盖或修改
    public void g() { System.out.println ("OverridingPrivate.g()");}

    @Override
    public void k() {
        super.k ();
        System.out.println ("OverridingPrivate.k()");
    }
}
class OverridingPrivate2 extends OverridingPrivate {
    //public final void f() { System.out.println ("OverridingPrivate2.f()");}
    public void g() { System.out.println ("OverridingPrivate2.g()");}

    @Override
    public void k() {
        super.k ();
        System.out.println ("OverridingPrivate2.k()");
    }
}


final class Dinosaur {
    int i = 0;
    void f() {}
}

//class Futher extends Dinosaur {}      final 类不允许被继承

public class FinalOverridingIllusion {
    public static void main(String args[]) {
        OverridingPrivate2 overridingPrivate2 = new OverridingPrivate2 ();
        overridingPrivate2.f ();
        overridingPrivate2.g ();
        overridingPrivate2.k ();
        OverridingPrivate overridingPrivate = overridingPrivate2;
        WithFinals withFinals = overridingPrivate;

    }
}
