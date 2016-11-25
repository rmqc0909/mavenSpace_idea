package cn.tk.polymiorphism.override;

/**
 * Created by xiedan11 on 2016/10/11.
 * 1.覆盖要求参数列表相同，如g()方法中父类和子类的入参必须都得是Object,如果入参不一样，则不是覆盖，是导出类的新方法。
 * 2.派生类中的覆盖方法必须要和基类中的被覆盖的方法有相同的函数名和参数。
 * 3.派生类中的覆盖方法的返回值必须和基类中的返回值一样，但是基类返回值若是Object，则派生类返回值可以是其他类型（所有类都是继承自Object），如g()方法。
 * 4.派生类中的覆盖方法的所抛出的异常必须和基类所抛出的异常一样。
 *
 */
class Super {
    public int f() { return 2;}
    public Object g(Object string) {
        System.out.println ("Super g()!");
        return 3;
    }
}
public class SubClass extends Super {
    //!public float f() {return 2f;}   编译时会报错，因为父类有一个返回值为int的f()方法，而导出类是返回值为float的f()方法，即返回值不明确。
    @Override
    public Integer g(Object string) {   //Integer也是一个Object。
        System.out.println ("SubClass g()!");
        return 34;
    }
    public static void main(String[] args) {
        Super x = new SubClass ();
        Object y = x.g ("2");
        System.out.println ("the value of y :" + y);
    }
}
