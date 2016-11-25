package cn.tk.inner_class.innerclass_control_framework;

/**
 * Created by xiedan11 on 2016/10/21.
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start ();
    }
    public void start() {
        eventTime = System.nanoTime () + delayTime;
    }
    public boolean ready() {
        return System.nanoTime () >= eventTime;
    }
    public abstract void action();
}
