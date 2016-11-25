package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/19.
 * 在执行类的所有特定的清理动作时，其顺序和生成顺序相反！
 */
class Shape {
    public Shape(int i) {
        System.out.println ("Shape Construction!");
    }
    public void dispose() {
        System.out.println ("Shape dispose!");
    }
}
class Circle extends Shape {
    public Circle(int i) {
        super (i);
        System.out.println ("Drawing Circle!");
    }

    @Override
    public void dispose() {
        System.out.println ("Erasing Circle!");
        super.dispose ();
    }
}
class Triangle extends Shape {
    public Triangle(int i) {
        super (i);
        System.out.println ("Drawing Triangle!");
    }

    @Override
    public void dispose() {
        System.out.println ("Erasing Triangle!");
        super.dispose ();
    }
}
class Line extends Shape {
    private int start,end;
    public Line(int start, int end) {
        super (start);
        this.start = start;
        this.end = end;
        System.out.println ("Drawing Line:" + start + ", " + end);
    }

    @Override
    public void dispose() {
        System.out.println ("Erasing Line:" + start + ", " + end);
        super.dispose ();
    }
}
public class CADSystem extends Shape{
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super (i);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line (j, j*j);
            c = new Circle (i);
            t = new Triangle (i);
            System.out.println ("Combined constructor");
        }
    }

    @Override
    public void dispose() {
        System.out.println ("CADSystem.dispose()");
        t.dispose ();
        c.dispose ();
        for (int i = lines.length - 1; i >= 0 ; i--) {
            lines[i].dispose ();
        }
        super.dispose ();
    }
    public static void main(String args[]) {
        CADSystem cadSystem = new CADSystem (11);
        try {
            System.out.println ("exception");
        } finally {
            cadSystem.dispose ();
        }
    }
}
