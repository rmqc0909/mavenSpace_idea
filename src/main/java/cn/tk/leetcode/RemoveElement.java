package cn.tk.leetcode;

/**
 * Created by xiedan on 16/8/20.
 */
public class RemoveElement {
    public static void main(String args[]) {
        int[] nums = {0,1,3,5,4,2,4,5,2};
        int val = 2;
        int removeElement = removeElement(nums, val);
        System.out.println("removeElement: " + removeElement);
    }

    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     Do not allocate extra space for another array, you must do this in place with constant memory.
     The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     Example:
     Given input array nums = [3,2,2,3], val = 3

     Your function should return length = 2, with the first two elements of nums being 2.
     * @param nums
     * @param val
     * @return
     */
    private static int removeElement(int[] nums, int val) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[m++] = nums[i];
            }
        }
        for (int x:
             nums) {
            System.out.println("删除后数组中的元素值: " + x);

        }
        return m;
    }


}
