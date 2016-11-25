package cn.tk.reuse_clazz;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xiedan11 on 2016/9/19.
 * final数据
 * 1.一个永不改变的编译时常量，这类常量必须是基本数据类型，在对常量进行定义的时候，必须对其赋值。
 * 2.一个在运行时被初始化的值，而你不希望它被改变
 * 3.一个既是static又是final的域只占一段不能改变的存储空间
 * 4.使引用成为final没有使基本类型成为final的用处大
 *
 */
class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Value{" +
                "i=" + i +
                '}';
    }
}
public class FinalData {
    private static Random rand = new Random (47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt (20);
    static final int INT_5 = rand.nextInt (20);
    private Value v1 = new Value (11);
    private final Value v2 = new Value (22);              //new了多少个对象，就会有多少份，在每个对象里面都是引用不可变的
    private static final Value VAL_3 = new Value (33);  //只有一份，不能改变引用，但是可以改变该引用指向的对象
    private final int[] a = { 1, 2, 3, 4, 5, 6 };

    @Override
    public String toString() {
        return "FinalData{" +
                "id='" + id + '\'' +
                ", VALUE_TWO=" + VALUE_TWO +
                ", VALUE_THREE=" + VALUE_THREE +
                ", INT_5=" + INT_5 +
                ", v1=" + v1 +
                ", v2=" + v2 +
                ", VAL_3=" + VAL_3 +
                ", i4=" + i4 +
                ", a=" + Arrays.toString (a) +
                '}';
    }

    public static void main(String [] args) {
        FinalData finalData1 = new FinalData ("finalData1");
        finalData1.v2.i++;
        VAL_3.i++;
        finalData1.v1 = new Value (9);
        //finalData1.v2 = new Value (10);   不能给v2在new一个新对象并赋值，因为final使引用恒定不变
        //finalData1.a = new int[3];        数组也是一个对象，也不能给它new一个新对象
        for (int i = 0; i < finalData1.a.length; i++)
            finalData1.a[i]++;
            System.out.println (finalData1);
            System.out.println ("Creating two new FinalDatas");
            FinalData finalData2 = new FinalData ("finalData2");
            finalData2.v2.i = 999;
            FinalData finalData3 = new FinalData ("finalData3");
            System.out.println ("finalData11111.v2.hashCode ()" + finalData1.v2.hashCode ());
            System.out.println ("finalData22222.v2.hashCode ()" + finalData2.v2.hashCode ());
            System.out.println ("finalData33333.v2.hashCode ()" + finalData3.v2.hashCode ());
            System.out.println ("finalData33333.VAL_3.hashCode ()" + finalData3.VAL_3.hashCode ());
            System.out.println ("finalData22222.VAL_3.hashCode ()" + finalData2.VAL_3.hashCode ());
            System.out.println ("finalData11111.VAL_3.hashCode ()" + finalData1.VAL_3.hashCode ());
            System.out.println (finalData1);
            System.out.println (finalData2);
            System.out.println (finalData3);
    }
}
