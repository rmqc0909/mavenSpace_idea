package cn.tk.inner_class.innerclass_control_framework;

/**
 * Created by xiedan11 on 2016/10/21.
 */
public class GreenhouseControllers extends Controller {
    private boolean light = false;
    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "LightOn{}";
        }
    }
    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "LightOff{}";
        }
    }
    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "WaterOn{}";
        }
    }
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "WaterOff{}";
        }
    }
    private String thermostat = "Day";
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "ThermostatNight{}";
        }
    }
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "ThermostatDay{}";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            addEvent (new Bell (delayTime));
        }

        @Override
        public String toString() {
            return "Bell{ Bing! }";
        }
    }
    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super (delayTime);
            this.eventList = eventList;
            for (Event e:eventList
                 ) {
                addEvent (e);
            }
        }

        @Override
        public void action() {
            for (Event e:eventList
                 ) {
                e.start ();
                addEvent (e);
            }
            start ();
            addEvent (this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super (delayTime);
        }

        @Override
        public void action() {
            System.exit (0);
        }

        @Override
        public String toString() {
            return "Terminate{}";
        }
    }

}
