package cn.tk.inner_class;

/**
 * Created by xiedan11 on 2016/10/12.
 */
public class Outer {
    private String string;

    public Outer(String string) {
        this.string = string;
    }

    class Inner {
        private int i = 11;
        public int value() { return i;}

        @Override
        public String toString() {
            return "Inner{" +
                    "string=" + string +
                    '}';
        }
    }
    public Inner inner() { return new Inner ();}

    public static void main(String[] args) {
        Outer outer = new Outer ("hello");
        Inner in = outer.inner ();
        System.out.println ("Inner's i = " + in.i);         //可以直接访问内部类的private变量。
        System.out.println ("Inner's i = " + in.value ());
        System.out.println ("string = " + in.toString ());
    }

}
