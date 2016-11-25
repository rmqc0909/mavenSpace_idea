package cn.tk.inner_class.local_inner_class;

import cn.tk.inner_class.member_inner_class.Destination;

/**
 * Created by xiedan11 on 2016/10/14.
 * 1.局部内部类：定义在方法里面的类。
 * 2.PDestination类是destination()方法的一部分，而不是Parcel5的一部分。在destination()之外不能访问PDestination。
 * 3.局部类不能用public或private访问说明符进行声明。它的作用域被限定在声明这个局部类的块中。
 * 4.局部类的方法只可以引用定义为final的局部变量。
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination {
            private String label;
            private PDestination(String label) {
                this.label = label;
                System.out.println ("Destination method's inner class: " + label);
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        Destination destination1 = new PDestination("dd test!!!");      //在destination方法中可以直接new这个对象（PDestination）
        return new PDestination (s);
    }
    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5 ();
        Destination destination = parcel5.destination ("Tasmania");
        //!Destination destination1 = parcel5.new PDestination("dd");
    }
}
