package cn.tk.study.localcache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiedan11 on 2016/11/9.
 * java8和java7的本地缓存实现   重复操作需要加本地缓存以提高性能。
 */
@SuppressWarnings("all")    //抑制所有的警告信息
public class Calculate {
    static Map<Integer, Integer> cache1 = new ConcurrentHashMap<>();
    static Map<Integer, Integer> cache2 = new ConcurrentHashMap<>();
    static Map<Integer, Integer> cache3 = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();
        System.out.println("normal method:");
        for (int i = 0; i < 45; i++) {
            //System.out.println("f(" + i + ") = " + fibonacci(i));
            fibonacci(i);
        }
        System.out.println("running time: " + (System.currentTimeMillis() - startTime1) + "ms");
        long startTime2 = System.currentTimeMillis();
        System.out.println("java7 synchronization method:");
        for (int i = 0; i < 45; i++) {
            //System.out.println("f(" + i + ") = " + fibonacciJava7(i));
            fibonacciJava7(i);
        }
        System.out.println("running time: " + (System.currentTimeMillis() - startTime2) + "ms");
        long startTime3 = System.currentTimeMillis();
        System.out.println("java8 computeIfAbsent method:");
        for (int i = 0; i < 45; i++) {
            //System.out.println("f(" + i + ") = " + fibonacciJava8(i));
            fibonacciJava8(i);
        }
        System.out.println("running time: " + (System.currentTimeMillis() - startTime3) + "ms");
        long startTime4 = System.currentTimeMillis();
        System.out.println("java7 method");
        for (int i = 0; i < 45; i++) {
            //System.out.println("f(" + i + ") = " + fibonacciJava7I(i));
            fibonacciJava7I(i);
        }
        System.out.println("running time: " + (System.currentTimeMillis() - startTime4) + "ms");

    }


    /**
     * 普通的实现方式
     * @param i
     * @return  计算最终结果
     */
    private static int fibonacci(int i) {
        if (i == 0 || i == 1)
            return i;
        //System.out.println("calculating Fibonacci(" + i + ")");
        return fibonacci(i - 2) + fibonacci(i - 1);
    }

    /**
     *java8的computeIfAbsent方法可以在key所对应的value值不存在的情况下，计算一个新的value值。
     * @param i
     * @return    计算最终结果
     */
    private static int fibonacciJava8(int i) {
        if (i == 0 || i == 1)
            return i;
        return cache2.computeIfAbsent(i, (key) -> fibonacciJava8(i - 2) + fibonacciJava8(i - 1));
    }

    /**
     * java7 通过synchronized进行线程同步，检查缓存是否存在key对应的值，如果不存在才进行相应的计算。
     * @param i
     * @return   计算最终结果
     */
    private static int fibonacciJava7(int i) {
        if (i == 0 || i == 1)
            return i;
        Integer result = cache1.get(i);
        if (result == null) {
            synchronized (cache1) {
                result = cache1.get(i);
                if (result == null) {
                    result = fibonacciJava7(i - 2) + fibonacciJava7(i - 1);
                    cache1.put(i, result);
                }
            }
        }
        return result;
    }

    /**
     * java7 检查缓存是否存在key对应的值，如果不存在才进行相应的计算 （不进行同步控制）
     * @param i
     * @return   计算最终结果
     */
    private static int fibonacciJava7I(int i) {
        if (i == 0 || i == 1)
            return i;
        Integer result = cache3.get(i);
        if (result == null) {
            result = fibonacciJava7(i - 2) + fibonacciJava7(i - 1);
            cache3.put(i, result);
        }
        return result;
    }
}
