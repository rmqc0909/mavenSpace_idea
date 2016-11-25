package cn.tk.polymiorphism.shape;

/**
 * Created by xiedan11 on 2016/9/26.
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        super.draw ();
        System.out.println ("Triangle.draw()");
    }

    @Override
    public void line() {
        System.out.println ("Triangle.line()");
    }

    @Override
    public void erase() {
        super.erase ();
        System.out.println ("Triangle.erase()");
    }
}
