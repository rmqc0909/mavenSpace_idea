package cn.tk.interfaces.scanner;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by xiedan11 on 2016/10/12.
 *   ≈‰Ω”ø⁄
 */
public class RandomWords implements Readable {
    private static Random random = new Random (47);
    private static final char[] capitals =
            "ABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray ();
    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray ();
    private static final char[] vowels =
            "aeiou".toCharArray ();
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) return -1;
        cb.append (capitals[random.nextInt (capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append (vowels[random.nextInt (vowels.length)]);
            cb.append (lowers[random.nextInt (lowers.length)]);
        }
        cb.append ("   ");
        return 10;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner (new RandomWords (1));
        while (s.hasNext ())
            System.out.println (s.next ());
    }
}
