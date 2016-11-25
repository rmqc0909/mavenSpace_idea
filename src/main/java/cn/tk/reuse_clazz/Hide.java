package cn.tk.reuse_clazz;

/**Think in Java Chapter vii - 13th   Page 136
 * Created by xiedan11 on 2016/9/19.
 */
class Home {
    char doh(char c) {
        System.out.println ("doh(char)");
        return 'd';
    }
    float doh(float f) {
        System.out.println ("doh(float)");
        return 1.0f;
    }
    void doh(Milhouse milhouse) {
        System.out.println ("doh(Milhouse)");
    };
}
class Milhouse {}


class Bart extends Home {
    void doh(int i) {
        System.out.println ("doh(int)");
    };
}
public class Hide {
    public static void main(String args[]) {
        Bart bart = new Bart ();
        bart.doh (1);
        bart.doh (1.0f);
        bart.doh ('c');
        bart.doh (new Milhouse ());
    }
}
