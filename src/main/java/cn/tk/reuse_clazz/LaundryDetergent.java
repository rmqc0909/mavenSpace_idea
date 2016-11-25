package cn.tk.reuse_clazz;

/**Think in Java Chapter vii - 2th   Page 129
 * Created by xiedan11 on 2016/9/14.
 */
public class LaundryDetergent extends Detergent {
    public void scrub() {
        append(" LaundryDetergent.scrub() ");
        super.scrub();  //调用超类
    }
    public void sterilize() { append(" sterilize() ");}
    public static void main(String args[]) {
        LaundryDetergent laundryDetergent = new LaundryDetergent();
        laundryDetergent.dilute();
        laundryDetergent.apply();
        laundryDetergent.foam();
        laundryDetergent.scrub();
        laundryDetergent.sterilize();
        System.out.println(laundryDetergent);
        System.out.println("Testing base class");
        Detergent.main(args);
    }
}
