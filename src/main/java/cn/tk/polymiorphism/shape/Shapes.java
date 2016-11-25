package cn.tk.polymiorphism.shape;

/**
 * Created by xiedan11 on 2016/9/26.
 */
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator ();
    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next ();
        }
        for (Shape x:
             s) {
            x.draw ();
            x.line ();
        }
    }
}
