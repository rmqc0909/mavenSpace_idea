/**
 * 
 */
package cn.tk.study.lottery;

import java.util.ArrayList;
import java.util.Random;

/**

 * @ClassName: RandomTest

 * @Description: TODO

 * @author xiedan11

 * @date 2016年7月21日 下午2:58:48

 *对于种子相同的Random对象，生成的随机数序列是一样的


 */
public class RandomTest {
	public static void main(String[] args) {
		Random ran1 = new Random(System.currentTimeMillis());
        System.out.println("使用种子为10的Random对象生成[0,100)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran1.nextInt(100) + " ");
        }
        System.out.println();
        Random ran2 = new Random(10);
        System.out.println("使用另一个种子为10的Random对象生成[0,100)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran2.nextInt(100) + " ");
        }
        Random ran3 = new Random(System.currentTimeMillis());
        System.out.println("使用缺省值的Random对象生成[0,100)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran3.nextInt(100) + " ");
        }
        ArrayList list=new RandomTest().getDiffNO(100, 13);
        System.out.println();
        System.out.println("产生的n个不同的随机数："+list);
	}
	//产生m个区间为[0-n)个不重复的随机数
	public ArrayList getDiffNO(int n, int m){
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }

}
