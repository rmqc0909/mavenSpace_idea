package cn.tk.reuse_clazz;

/**
 * 构造类是从基类“向外”扩散的，基类在导出类构造器访问它之前，就已经完成了初始化。
 * 即便不显示的为Cartoon创建构造器，编译器也会合成一个默认的构造器，该构造器将会调用基类构造器。
 * Created by xiedan11 on 2016/9/19.
 */
class Art {
    public Art() {
        System.out.println ("Art Construction!");
    }
}
class Draw extends Art {
    public Draw() {
        System.out.println ("Draw Construction!");
    }
}
public class Cartoon extends Draw {
    public Cartoon() {
        System.out.println ("Cartoon Construction!");
    }
    public static void main(String args[]) {
        Cartoon cartoon = new Cartoon ();
    }
}
