package cn.tk.inner_class.member_inner_class;

/**
 * Created by xiedan11 on 2016/10/13.
 * 成员内部类:
 * 1.内部类可以看作是外部类的一个成员（与类的属性和方法类似）。
 * 即PDestination和PContents可以看作是Parcel4的一个成员。
 * 2.PContents是private，所以除了Parcel4，其他都不可以访问PContents
 * PDestination是protected，只有Parcel4及其子类，还有与Parcel4同一个包中的类能访问PDestination,其他类都不能访问PDestination.
 * 3. 外部类可以访问其内部类的private元素。
 * 4.只有内部类可以是私有类，而常规类只可以具有包可见性，或公有可见性。
 *
 */
class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }
    protected class PDestination implements Destination {
        private String label;
        private PDestination(String label) {
            this.label = label;
            System.out.println ("PDestination constructors " + label);
        }
        @Override
        public String readLabel() {
            return label;
        }
    }
    public Destination destination(String s) {
        return new PDestination (s);
    }
    public Contents contents() {
        return new PContents ();
    }
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4 ();
        PContents pContents = parcel4.new PContents ();
        System.out.println ("Outer class can access inner class's private element: " + (pContents.i == 11));

    }
}
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4 ();
        Contents contents = parcel4.contents ();
        Destination destination = parcel4.destination ("Tasmania");
        //!Parcel4.PDestination pDestination = parcel4.new PDestination ("test");   PDestination 构造函数是private，不能用new来创建对象。
        //!Parcel4.PContents pContents = parcel4.new PContents();   不能访问 private class.
    }
}
