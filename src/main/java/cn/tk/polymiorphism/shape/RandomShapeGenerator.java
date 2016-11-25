package cn.tk.polymiorphism.shape;

import java.util.Random;

/**
 * Created by xiedan11 on 2016/9/26.
 */
public class RandomShapeGenerator {
    private Random random = new Random (47);
    public Shape next() {
        switch (random.nextInt (3)) {
            default:
            case 0: return new Circle ();
            case 1: return new Triangle ();
            case 2: return new Square ();
        }
    }
}
