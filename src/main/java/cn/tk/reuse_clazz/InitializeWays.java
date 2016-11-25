package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/14.
 * 初始化引用
 * 1.在定义对象的地方。意味着总是能在调用构造器被调用之前被初始化。
 * 2.在类的构造器中初始化。
 * 3.就在正要使用这些对象之前，该方式称为惰性初始化。在生成对象不值得及不必每次都生成对象的情况下，这种方式可以减少额外的负担。
 * 4.使用实例初始化。
 */
class Soap {
    private String s;

    public Soap() {
        System.out.println("Soap()");
        s = "Contructed";
    }

    @Override
    public String toString() {
        return "Soap{" +
                "s='" + s + '\'' +
                '}';
    }
}
public class InitializeWays {
    private String
            s1 = "Happy",   //Initializing at point of definition
            s2 = "Happy",
            s3, s4;
    private Soap soap;
    private int i;
    private float toy;

    public InitializeWays() {
        System.out.println("Inside InitializeWays()");
        s3 = "Joy";
        toy = 3.14f;
        soap = new Soap();
    }
    //Instance initialization
    {
        i = 47;
    }

    @Override
    public String toString() {
        //Delayed initialization
        if (s4 == null)
            s4 = "Joy";
        return "InitializeWays{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", soap=" + soap +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }
    public static void main(String args[]) {
        InitializeWays b = new InitializeWays ();
        System.out.println(b);
    }
}

