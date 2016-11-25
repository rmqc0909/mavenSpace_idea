package cn.tk.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiedan11 on 2016/10/10.
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion{}";
    }
    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion> ();
        for (int i = 0; i < 10; i++) {
            v.add (new InfiniteRecursion ());
        }
        System.out.println (v);
    }
}
