package cn.tk.inner_class;


/**
 * Created by xiedan11 on 2016/10/13.
 * 1.在拥有外部类对象之前是不可能创建内部类对象。
 */
public class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
            System.out.println ("Destination label : " + label);
        }
        String readLabel() { return label; }
    }
    public static void main(String[] args) {
        Parcel3 p = new Parcel3 ();                 //先创建外部类
        Parcel3.Contents c = p.new Contents ();     //创建内部类
        Parcel3.Destination d = p.new Destination ("Tasmania");
    }
}
