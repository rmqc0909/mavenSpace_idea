package cn.tk.polymiorphism.upcasting;

/**
 * Created by xiedan11 on 2016/9/27.
 * 1.只有普通的方法调用可以是多态的，如果直接访问某个域，这个访问就将在编译期进行解析。
 *
 */
class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }
    public int getSuperField() {
        return super.field;
    }
}
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();  //upcast
        System.out.println ("sup.field = " + sup.field + ", sup.getField() = " + sup.getField ());
        Sub sub = new Sub();
        System.out.println ("sub.field = " + sub.field + ", sub.getField() = " + sub.getField () + ", sub.getSuperField() = " + sub.getSuperField () );
    }
}
