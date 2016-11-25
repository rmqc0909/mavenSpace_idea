package cn.tk.inner_class.innerclass_control_framework;

/**
 * Created by xiedan11 on 2016/10/21.
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControllers gc = new GreenhouseControllers ();
        gc.addEvent (gc.new Bell (900));
        Event[] eventList = {
                gc.new ThermostatNight (0),
                gc.new LightOn (200),
                gc.new LightOff (200),
                gc.new WaterOn (600),
                gc.new WaterOff (800),
                gc.new ThermostatDay (1400)
        };
        gc.addEvent (gc.new Restart (2000, eventList));
        if (args.length == 1)
            gc.addEvent (new GreenhouseControllers.Terminate (new Integer (args[0])));
        gc.run ();
    }
}
