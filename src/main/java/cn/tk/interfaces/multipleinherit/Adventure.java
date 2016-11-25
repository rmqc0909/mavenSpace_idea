package cn.tk.interfaces.multipleinherit;

/**
 * Created by xiedan11 on 2016/10/11.
 * ∂‡÷ÿºÃ≥–
 */
interface CanFight {
    void fight();
}
interface CanSwim {
    void swim();
}
interface CanFly {
    void fly();
}
interface CanClimb {
    void climb();
}
class ActionCharacter {
    public void fight() {
        System.out.println ("ActionCharacter fight()!");
    }
}
class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim, CanClimb {
    @Override
    public void fly() {
        System.out.println ("Hero fly()!");
    }

    @Override
    public void swim() {
        System.out.println ("Hero swim()!");
    }

    @Override
    public void climb() {
        System.out.println ("Hero climb()!");
    }
}
public class Adventure {
    public static void s(CanClimb x) {
        x.climb ();
    }
    public static void t(CanFight x) {
        x.fight ();
    }
    public static void u(CanSwim x) {
        x.swim ();
    }
    public static void v(CanFly x) {
        x.fly ();
    }
    public static void w(ActionCharacter x) {
        x.fight ();
    }
    public static void main(String[] args) {
        Hero hero = new Hero ();
        s (hero);
        t (hero);
        u (hero);
        v (hero);
        w (hero);
    }
}
