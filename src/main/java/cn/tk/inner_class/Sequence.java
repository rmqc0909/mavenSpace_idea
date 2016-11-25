package cn.tk.inner_class;

/**
 * Created by xiedan11 on 2016/10/13.
 * “迭代器”设计模式举例
 * 1.非static的内部类，在外部类加载的时候，并不会加载它，所以它里面不能有静态变量或者静态方法。
 * 2.内部类可以访问其外围类的方法和字段。内部类自动拥有对其外围类所有成员的访问权。
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    /**
     * 内部类
     */
    private class SequenceSelector implements Selector {
        int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }
    }
    public Selector selector() {
        return new SequenceSelector ();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence (10);
        for (int i = 0; i < 10; i++)
            sequence.add (Integer.toString (i));
        Selector selector = sequence.selector ();
        while (!selector.end()) {
            System.out.print (selector.current () + "  ");
            selector.next ();
        }
    }
}
