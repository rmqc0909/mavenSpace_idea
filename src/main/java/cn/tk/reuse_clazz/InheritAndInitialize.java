package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/26.
 * 加载顺序:
 * 1.根基类（Base类）中的static初始化先被执行，然后下一个导出类，以此类推。导出类的static初始化可能会依赖于基类成员是否被正确初始化。
 * 2.基类构造器和导出类的构造器一样，以相同的顺序来初始化。（先实例变量，然后构造器）
 * 3.基类构造器完成之后，导出类的实例变量按其次序被初始化，然后导出类的构造器。
 * 4.构造器也是static方法，尽管static关键字并没有显示地写出来。更准确的讲，类是在其任何static成员被访问时加载的。
 * 5.定义为static的东西只会被初始化一次。
 */
class Base {
    private int i = 9;
    protected int j;
    private int f = printInit ("Base.f initialized");

    public Base() {
        System.out.println ("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Base.x1 initialized");

    static int printInit(String s) {
        System.out.println (s);
        return 47;
    }
}
public class InheritAndInitialize extends Base{
    private int k = printInit ("InheritAndInitialize.k initialized");

    public InheritAndInitialize() {
        System.out.println ("k = " + k);
        System.out.println ("j = " + j);
    }
    private static int x2 = printInit ("static InheritAndInitialize.x2 initialized");
    public static void main(String args[]) {
        System.out.println ("InheritAndInitialize constructor");
        InheritAndInitialize inheritAndInitialize = new InheritAndInitialize ();
    }
}
