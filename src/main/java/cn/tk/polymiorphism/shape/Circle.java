package cn.tk.polymiorphism.shape;

/**
 * Created by xiedan11 on 2016/9/26.
 */
public class Circle extends Shape {
    @Override
    public void erase() {
        super.erase ();
        System.out.println ("Circle.erase()");
    }

    @Override
    public void line() {
        System.out.println ("Circle.line()");
    }

    @Override
    public void draw() {
        super.draw ();
        System.out.println ("Circle.draw()");
    }
}
