package cn.tk.polymiorphism.upcasting;

/**
 * Created by xiedan11 on 2016/9/27.
 * 1.对于有继承关系的类，若调用了一个方法。该方法在导出类中有，则调用该方法。若没有，则去父类寻找该方法并调用之。
 */

class Instrument {
    void play(Note n) {
        System.out.println ("Instrument.play() " + n);
    }

    @Override
    public String toString() {
        return "Instrument{}";
    }
    void adjust() {
        System.out.println ("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        System.out.println ("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind{}";
    }

    @Override
    void adjust() {
        System.out.println ("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println ("Percussion.play()" + n);
    }

    @Override
    public String toString() {
        return "Percussion{}";
    }

    @Override
    void adjust() {
        System.out.println ("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println ("Stringed.play()" + n);
    }

    @Override
    void adjust() {
        System.out.println ("Adjusting Stringed");
    }

    @Override
    public String toString() {
        return "Stringed{}";
    }
}

class Violin extends Instrument {
    @Override
    void play(Note n) {
        System.out.println ("Violin.play()" + n);
    }

    @Override
    public String toString() {
        return "Violin{}";
    }

    @Override
    void adjust() {
        System.out.println ("Adjusting Violin");
    }
}

class Brass extends Wind {
    @Override
    void play(Note n) {
        System.out.println ("Brass.play()" + n);
    }

    @Override
    void adjust() {
        System.out.println ("Adjusting Brass");
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) {
        System.out.println ("Woodwind.play()" + n);
    }

    @Override
    public String toString() {
        return "Woodwind{}";
    }
}

public class Music {
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
                new Woodwind (),
                new Violin ()
        };
        System.out.println ((new Wind ()).toString ());
        /**
         * 每一个元素都是其对应的实际的类型
         */
        for (Instrument x:
             orchestra) {
            System.out.println ("x:" + x);
        }
        tuneAll (orchestra);
    }
}
