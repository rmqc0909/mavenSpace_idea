package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/10/13.
 * 1.当父类没有提供无参数的构造函数时，子类的构造函数必须显式地调用父类的构造函数。
 * 2.当父类提供了无参数的构造函数时，此时子类的构造函数就可以不显式调用父类的构造函数，在这种情况下编译器会默认调用父类提供的无参数的构造函数。
 * 如带有参数的构造函数在不显式的调用父类构造函数时默认调用的是无参数的构造函数。
 *
 */
class Base2 {
    private int i;
    private int j;

    public Base2(int i, int j) {
        System.out.println ("Base2 i, j constructor");
        this.i = i;
        this.j = j;
    }

    public Base2() {
        System.out.println ("Base2 constructor");
    }

    public Base2(int i) {
        System.out.println ("Base2 i constructor");
        this.i = i;
    }
}
public class Constructors extends Base2{
    public Constructors() {
    }

    public Constructors(int i, int j) {
        //super (i, j);
    }

    public Constructors(int i) {
        super (i);
    }
    public static void main(String[] args) {
        new Constructors ();
        new Constructors (2);
        new Constructors (2, 3);
    }
}
