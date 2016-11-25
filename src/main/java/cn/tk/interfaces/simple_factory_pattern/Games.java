package cn.tk.interfaces.simple_factory_pattern;

/**
 * Created by xiedan11 on 2016/10/12.
 * 简单工厂模式
 */
interface Game {
    boolean move();
}
interface GameFactory {
    Game getGame();
}
class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;
    @Override
    public boolean move() {
        System.out.println ("Checkers move " + moves);
        return ++moves != MOVES;
    }
}
class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers ();
    }
}
class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 3;
    @Override
    public boolean move() {
        System.out.println ("Chess move " + moves);
        return ++moves != MOVES;
    }
}
class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess ();
    }
}
public class Games {
    public static void playGame(GameFactory gameFactory) {
        Game game = gameFactory.getGame ();
        while (game.move ());
    }
    public static void main(String[] args) {
        playGame (new CheckersFactory ());
        playGame (new ChessFactory ());
    }
}
