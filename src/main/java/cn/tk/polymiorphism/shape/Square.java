package cn.tk.polymiorphism.shape;

/**
 * Created by xiedan11 on 2016/9/26.
 */
public class Square extends Shape {
    @Override
    public void draw() {
        super.draw ();
        System.out.println ("Square.draw()");
    }

    @Override
    public void line() {
        System.out.println ("Square.line()");
    }

    @Override
    public void erase() {
        super.erase ();
        System.out.println ("Square.erase()");
    }
}
