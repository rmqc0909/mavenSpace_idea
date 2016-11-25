package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/20.
 * 1.必须在域的定义处或者每个构造器中用表达式对final进行赋值，这正是final域在使用前总是被初始化的原因
 */
class Poppet {
    private int i;

    public Poppet(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Poppet{" +
                "i=" + i +
                '}';
    }
}
public class BlankFinal {
    private final int i = 0;    //Initiallized final
    private final int j;        //Blank final
    private final Poppet p;     //Blank final reference
    //Black finals MUST be initialized in the constructor
    public BlankFinal() {
        j = 1;
        p = new Poppet (1);
    }
    public BlankFinal(int j) {
        this.j = j;
        this.p = new Poppet (j);
    }
    public static void main(String args[]) {
        BlankFinal blankFinal = new BlankFinal (478);
        //blankFinal.i = 6;     一旦final修饰的对象被初始化，则不能被改变
        //blankFinal.j = 3;     同上
        new BlankFinal ();
        System.out.println (blankFinal);
    }

    @Override
    public String toString() {
        return "BlankFinal{" +
                "i=" + i +
                ", j=" + j +
                ", p=" + p +
                '}';
    }
}
