package cn.tk.polymiorphism.downcasting;

/**
 * Created by xiedan11 on 2016/10/10.
 */
class Useful {
    public void f() {}
    public void g() {}
}
class MoreUseful extends Useful {
    @Override
    public void f() {
    }
    @Override
    public void g() {
    }

    public void u() {

    }
    public void v() {

    }
}

/**
 * 1. 数组中两个对象都属于Userful类，故而可以调用f()和g()这两个方法，若试图调用u()方法（它只存在于MoreUseful），就会在编译时出错。
 * 2. 若要访问MoreUseful对象的扩展接口，就可以尝试向下转型，如果所转类型是正确的类型，则转型成功；否则，返回ClassCastException异常。
 */
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful (),
                new MoreUseful ()
        };
        x[0].f ();
        x[1].g ();
        // !x[1].u();
        ((MoreUseful)x[1]).u ();     //Downcast/RTTI
        ((MoreUseful)x[0]).u ();     //Exception thrown
    }
}
