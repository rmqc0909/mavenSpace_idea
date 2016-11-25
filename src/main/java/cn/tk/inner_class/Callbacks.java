package cn.tk.inner_class;

/**
 * Created by xiedan11 on 2016/10/20.
 * 1.Callee1是简单的实现一个接口。
 * 2.Callee2继承MyIncrement，并且Callee2外围类重写了increment()方法，Callee2内部类Closure实现了Incrementable接口的increment()方法，并且Closure的increment()方法调用了外围类的increment()方法
 */
interface Incrementable {
    void increment();
}
class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println (i);
    }
}
class MyIncrement {
    public void increment() {
        System.out.println ("Other operation");
    }
    static void f(MyIncrement myIncrement) {
        myIncrement.increment ();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    @Override
    public void increment() {
        super.increment ();
        i++;
        System.out.println (i);
    }
    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment ();  //通过内部类去调用外围类的increment()方法
        }
    }
    Incrementable getCallbackReference() {
        return new Closure ();
    }
}

class Caller {
    private Incrementable callbackReference;

    public Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }
    void go() {
        callbackReference.increment ();
    }
}
public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1 ();
        Callee2 callee2 = new Callee2 ();
        MyIncrement.f (callee2);
        Caller caller1 = new Caller (callee1);
        Caller caller2 = new Caller (callee2.getCallbackReference ());
        caller1.go ();
        caller1.go ();
        caller2.go ();      //调用内部类（Closure）的increment()方法，而该内部类的increment()方法调用的是其外围类的increment()方法。
        caller2.go ();
    }
}
