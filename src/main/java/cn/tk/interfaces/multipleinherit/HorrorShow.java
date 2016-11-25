package cn.tk.interfaces.multipleinherit;

/**
 * Created by xiedan11 on 2016/10/12.
 * 通过继承来扩展接口：
 * 1.在Vmpire中使用的语法仅适用于接口继承。一般情况下，只可以将extends用于单一类，但是可以引用多个基类接口。只需用逗号将接口名一一分隔开即可。
 * 2.接口可以一次继承多个接口，这是因为接口都没有方法实现，不会存在多继承问题。
 *
 */
interface Monster {
    void menace();
}
interface DangerousMonster extends Monster {
    void destroy();
}
class DragonZilla implements DangerousMonster {
    @Override
    public void destroy() {
        System.out.println ("DragonZilla destroy()");
    }

    @Override
    public void menace() {
        System.out.println ("DragonZilla menace()");
    }
}
interface Lethal {
    void kill();
}
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}
class VeryBadVampire implements Vampire {
    @Override
    public void drinkBlood() {
        System.out.println ("VeryBadVampire drinkBlood()");
    }

    @Override
    public void destroy() {
        System.out.println ("VeryBadVampire destroy()");
    }

    @Override
    public void kill() {
        System.out.println ("VeryBadVampire kill()");
    }

    @Override
    public void menace() {
        System.out.println ("VeryBadVampre menace()");
    }
}
public class HorrorShow {
    static void u(Monster monster) {
        monster.menace ();
    }
    static void v(DangerousMonster dangerousMonster) {
        dangerousMonster.menace ();
        dangerousMonster.destroy ();
    }
    static void w(Lethal lethal) {
        lethal.kill ();
    }
    static void x(Vampire vampire) {
        vampire.destroy ();
        vampire.kill ();
        vampire.menace ();
        vampire.drinkBlood ();
    }
    public static void main(String[] args) {
        DangerousMonster dangerousMonster = new DragonZilla ();
        u (dangerousMonster);
        v (dangerousMonster);
        Vampire vampire = new VeryBadVampire ();
        w (vampire);
        x (vampire);
    }
}
