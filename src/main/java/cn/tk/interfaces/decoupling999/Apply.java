package cn.tk.interfaces.decoupling999;

import java.util.Arrays;

/**
 * Created by xiedan11 on 2016/10/10.
 * 利用接口完全解耦，这里不太明白。P174（Thinking in java）
 */
class Processor {
    public String name() {
        return getClass ().getSimpleName ();
    }
    Object process(Object input) { return input;}
}
class Upcase extends Processor {
    @Override
    String process(Object input) {
        return ((String) input).toUpperCase ();
    }
}
class Downcase extends Processor {
    @Override
    String process(Object input) {
        return ((String) input).toLowerCase ();
    }
}
class Splitter extends Processor {
    @Override
    String process(Object input) {
        return Arrays.toString (((String) input).split (" "));
    }
}
public class Apply {
    private static String s = "Disagreement with beliefs is by definition incorrect";
    public static void process(Processor p, Object s) {
        System.out.println ("Using Processor " + p.name ());
        System.out.println (p.process (s));
    }
    public static void main(String[] args) {
        process (new Upcase (), s);
        process (new Downcase (), s);
        process (new Splitter (), s);
    }
}
