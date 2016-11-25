package cn.tk.sun_pang_zi;

/**
 * Created by xiedan on 16/10/14.
 */

public class Mobile {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 7, 6, 3 ,8 ,9};
        int[] index = {2, 0, 1, 1, 7, 5, 6, 2, 2, 3, 4};
        String tel = "";
        for (int x: index
             ) {
            tel += arr[x];
        }
        System.out.println(tel);
    }
}
