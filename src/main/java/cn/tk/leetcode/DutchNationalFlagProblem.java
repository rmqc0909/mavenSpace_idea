package cn.tk.leetcode;

/**
 * Created by xiedan on 16/9/24.
 * Problem Description:
 * The flag of the Netherlands consists of three colors: red, white and blue.
 * Given balls of these three color arranged randomly in a line (the actual number of balls does not matter),
 * the task is to arrange them such that all balls of the same color are together
 * and their collective color groups are in the correct order.
 *
 * Illustrate:
 *
 * n holds the boundary of numbers greater than mid.
 * j is the position of number under consideration.
 * And i is the boundary for the numbers lesser than the mid.
 */
public class DutchNationalFlagProblem {
    public static int[] solution(int[] array, int location) {
        int i = 0, j = 0;
        int n = array.length - 1;
        while (j <= n) {
            if (array[j] < location) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j++;
            }
            else if (array[j] > location) {
                int tmp = array[j];
                array[j] = array[n];
                array[n] = tmp;
                n--;
            }
            else
                j++;
        }
        return array;
    }

    public static void main(String args[]) {
        int array[] = {1, 1, 2, 2, 3, 3, 1, 2, 4};
        array = solution(array, 3);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

    }


}
