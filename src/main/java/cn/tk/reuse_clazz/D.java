package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/19.
 * Think in Java Chapter vii - 5th   Page 130
 *  不带参数构造器的初始化顺序：
 *  静态对象
 *  1.静态块里的对象（B）
 *  非静态对象
 *  2.基类初始化（A）
 *  3.类内部定义的对象，即成员对象（E）
 *  4.构造器方法（C）
 */
class A {
    public A() {
        System.out.println ("A Construction!");
    }
}
class B {
    public B() {
        System.out.println ("B Construction!");
    }
}
class E {
    public E() {
        System.out.println ("E construction!");
    }
}
class C extends A {
    public C() {
        System.out.println ("C construction!");
    }
    static {
        B b = new B ();
    }
    E e = new E ();
}
public class D {
    public static void main(String args[]) {
        C c = new C ();
    }
}
