package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/14.
 * 1.可以为每个类都创建一个main()方法
 * 2.为了继承，一般的规则是将所有的数据成员指定为private,将所有方法指定为public
 */
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a;}
    public void dilute() { append(" dilute() ");}
    public void apply() { append(" apply() ");}
    public void scrub() { append(" scrub() ");}

    @Override
    public String toString() {
        return s;
    }
    public static void main(String args[]) {
        Cleanser cleanser = new Cleanser();
        cleanser.apply();
        cleanser.dilute();
        cleanser.scrub();
        System.out.println(cleanser);
    }
}
public class Detergent extends Cleanser{
    //change a method
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }
    //add a method
    public void foam() { append(" foam() ");}
    public static void main(String args[]) {
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("Testing base class: ");
        Cleanser.main(args);
    }
}
