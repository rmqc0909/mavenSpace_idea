package cn.tk.interfaces;

/**
 * Created by xiedan11 on 2016/10/10.
 * 1. 接口中的域隐式地是static和final的。
 */
interface Instrument{
    int VALUE = 5;
    void play(Note n);
    void adjust();
}
class Wind implements Instrument {

    @Override
    public void play(Note n) {
        System.out.println (this + ".play() " + n);
    }

    @Override
    public String toString() {
        return "Wind{}";
    }

    @Override
    public void adjust() {
        System.out.println (this + ".adjust() ");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println (this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println (this + ".adjust() ");
    }

    @Override
    public String toString() {
        return "Percussion{}";
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println (this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println (this + ".adjust() ");
    }

    @Override
    public String toString() {
        return "Stringed{}";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass{}";
    }
}
class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind{}";
    }
}

public class Music5 {
    public static void tune(Instrument i) {
        i.play (Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
        for (Instrument i:
             e) {
            tune (i);
        }
    }
    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind (),
                new Percussion (),
                new Stringed (),
                new Brass (),
                new Woodwind ()
        };
        tuneAll (orchestra);
    }
}
