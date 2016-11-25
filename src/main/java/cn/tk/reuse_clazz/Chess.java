package cn.tk.reuse_clazz;

/**
 * Created by xiedan11 on 2016/9/19.
 * 带参数构造器的初始化顺序：
 */
class Game {
    public Game(int i) {
        System.out.println ("Game Construction!");
    }
}
class BoardGame extends Game {
    public BoardGame(int i) {
        super (i);
        System.out.println ("BoardGame Construction!");
    }
}
public class Chess extends BoardGame {
    public Chess() {
        super (11);
        System.out.println ("Chess Construction!");
    }
    public static void main(String args[]) {
        Chess chess = new Chess ();
    }
}
