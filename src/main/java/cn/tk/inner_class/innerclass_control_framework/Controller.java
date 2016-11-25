package cn.tk.inner_class.innerclass_control_framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiedan11 on 2016/10/21.
 */
public class Controller {
    private List<Event> eventList = new ArrayList<Event> ();
    public void addEvent(Event event) { eventList.add (event);}
    public void run() {
        new ArrayList<> (eventList).stream ().filter (x -> x.ready ()).forEachOrdered (x -> {
            System.out.println (x);
            x.action ();
            eventList.remove (x);
        });
    }
}
