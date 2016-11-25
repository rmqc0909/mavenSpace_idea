package cn.tk.inner_class.static_inner_class;

/**
 * Created by xiedan11 on 2016/10/19.
 * 1.当内部类不需要访问外围类对象时，应该使用静态内部类。而普通的内部类对象隐式地保存了一个引用，指向创建它的外围类对象。
 * 2.只有内部类可以声明为static，静态内部类的对象除了没有生成它的外围类对象的引用特权外，与其他所有内部类完全一样。
 * 3.若内部类对象是在静态方法中构造的，则必须使用静态内部类。
 *
 * 4.嵌套类（静态类）意味着：
 * 1）要创建嵌套类的对象，并不需要其外围类的对象；
 * 2）不能从嵌套类的对象中访问非静态的外围类对象；
 *
 * 5.普通内部类的字段和方法，只能放在类的外部层次上，故而普通的内部类不能有static数据和static字段，也不能包含嵌套类。但是嵌套类可以包含这些东西。
 *
 */
class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }
    public static Pair minmax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double x : values
             ) {
            if (min > x) min = x;
            if (max < x) max = x;
        }
        return new Pair (min, max);
    }
}
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] doubles = new double[20];
        for (int i = 0; i < doubles.length; i++)
            doubles[i] = Math.random ();
        ArrayAlg.Pair pair = ArrayAlg.minmax (doubles);
        System.out.println ("min: " + pair.getFirst ());
        System.out.println ("max: " + pair.getSecond ());
    }
}
