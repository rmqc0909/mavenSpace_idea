package cn.tk.java8;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Created by xiedan11 on 2016/11/18.
 */
public class Lambda {
    public static void main(String[] args) {
        //beforeLambda();
        List<Integer> list1;
        list1 = new ArrayList<Integer>();
        for(int i = 0;i<500;i++)
        System.out.println(list1.parallelStream()
//                .filter(x -> x > 2)
//                .distinct()
//                .mapToInt(x -> x * x)
//                .limit(2)
                .reduce("start", (x,y) -> x+y, (x,y) -> x + "\r\n" + y)
        );

        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        System.out.println(list.stream()
                .filter(x -> x > 3)
                .mapToInt(x -> x * x));
    }

    /**
     * Lambda����ʽ֮ǰ��Ҫ�½�һ���̣߳���Ҫ����д
     */
    private static void beforeLambda() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running!");
            }
        }).start();
    }

    /**
     * ����lambda����ʽ֮���д��
     */
    private static void afterLambda() {
        new Thread(() -> System.out.println("Thread is running!")).start();
    }

    /**
     * lambda����ʽ�ļ���д��
     */

    private static void waysOfLambda() {
        Runnable runnable = () -> System.out.println("Hello World!");   //д��1
        Runnable mutilline = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };  //д��2
        ActionListener listener = event -> System.out.println("button clicked");    //д��3
        BinaryOperator<Long> add = (Long x, Long y) -> x + y;   //д��4
        BinaryOperator<Long> addImplicit = (x, y) -> x + y;     //д��5
    }
}