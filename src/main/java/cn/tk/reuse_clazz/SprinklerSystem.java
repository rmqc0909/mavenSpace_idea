package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/13.
 * 1.非静态实例初始化：实例初始化子句是在构造器之前执行的
 * 2.若类中不重写toString()方法，则打印一个对象如下：
 * cn.tk.reuse_clazz.SprinklerSystem@74a14482
 * 若类中重写toString()方法，则打印toString()方法中信息
 * 3.每一个非基本类型的对象都有一个toString()方法，当编译器需要一个String而你却只是一个对象的时候，toString()方法便会被调用。
 *
 *
 */
class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Contructed";
    }

    @Override
    public String toString() {
        return "WaterSource{" +
                "s='" + s + '\'' +
                '}';
    }
}
public class SprinklerSystem {
    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }
    public static void main(String args[]) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}

