package cn.tk.interfaces;

/**
 * Created by xiedan11 on 2016/10/10.
 * 1.包含抽象方法的类叫做抽象类。如果一个类包含一个或多个抽象方法，该类必须被限定为抽象的。
 * 2.如果从一个抽象类继承，并想创建该新类的对象，则必须为基类中的所有抽象方法提供方法定义。
 * 若不这样做（可以不这么做），则导出类也是抽象类，且编译器强制要求使用abstract关键字来限定这个类。
 */
abstract class Base {
    abstract void g();
    abstract void k();
}

class More extends Base {
    public void f() {
        System.out.println ("More f()");
    }

    @Override
    void g() {
        System.out.println ("More g()");
    }

    @Override
    void k() {

    }
}
public class AbstractTest {
    public static void main(String[] args) {
        Base x = new More ();
        x.g ();
        ((More)x).f ();
    }
}
