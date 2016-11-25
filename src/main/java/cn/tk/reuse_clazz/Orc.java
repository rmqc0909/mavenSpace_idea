package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/19.
 * protected:就类用户而言，这是private的，但对于
 * 1.任何继承于此类的导出类
 * 2.其他任何位于一个包内的类来说
 * 它是可以访问的。
 */
class Villain {
    private String name;
    protected void set(String name) {this.name = name;}
    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Villain{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class Orc extends Villain{
    private int orcNumber;
    public Orc(String name, int orcNumber) {
        super (name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber) {
        set (name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc{" +
                "orcNumber=" + orcNumber + ": " + super.toString () +
                '}';
    }
    public static void main(String args[]) {
        Orc orc = new Orc ("Lingou", 250);
        System.out.println (orc);
        orc.change ("Goulin", 251);
        System.out.println (orc);
    }
}
