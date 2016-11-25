package cn.tk.polymiorphism.constructor;

/**
 * Created by xiedan11 on 2016/9/27.
 * 加载顺序：
 * 1.调用基类构造器。这个步骤会不断地反复递归下去，首先是构造这种层次结构的根，然后是下一层导出类，等等，直到最低层的导出类。
 * 2.按声明顺序调用成员的初始化方法。
 * 3.调用导出类构造器的主体。
 */
class Meal {
    public Meal() {
        System.out.println ("Meal()");
    }
}
class Bread {
    public Bread() {
        System.out.println ("Bread()");
    }
}
class Cheese {
    public Cheese() {
        System.out.println ("Cheese()");
    }
}
class Lettuce {
    public Lettuce() {
        System.out.println ("Lettuce()");
    }
}
class Lunch extends Meal {
    public Lunch() {
        System.out.println ("Lunch()");
    }
}
class PortableLunch extends Lunch {
    public PortableLunch() {
        System.out.println ("PortableLunch()");
    }
}
public class Sandwich extends PortableLunch {
    private Bread bread = new Bread ();
    private Cheese cheese = new Cheese ();
    private Lettuce lettuce = new Lettuce ();

    public Sandwich() {
        System.out.println ("Sandwich()");
    }
    public static void main(String[] args) {
        new Sandwich ();
    }
}
