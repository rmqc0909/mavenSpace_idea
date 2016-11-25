package cn.tk.leetcode;

import java.util.HashMap;

/**
 * Created by xiedan on 16/9/11.
 * 该系列题目主要思想是将出现过的数字采用HashMap<Integer, Integer>存储;
 * 其中,key:数字中元素,vakue:出现过的次数,其中出现过2次以上的value均为2;
 * 只出现过1次的value为1;
 * 最后统计value值为1的key值即为数组中只出现一次的元素;
 *
 */
public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     *
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        HashMap<Integer, Integer> hashMap = getIntegerIntegerHashMap(nums);
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.get(nums[i]) == 1)
                return nums[i];
        }
        return -1;
    }

    private HashMap<Integer, Integer> getIntegerIntegerHashMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int cnt = 1;
            if(hashMap.containsKey(nums[i])) {
                cnt++;
            }
            hashMap.put(nums[i], cnt);
        }
        return hashMap;
    }

    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.
     *
     * 另一种方法,利用位运算
     *
     * 出现1次，ones =  数本身    twos = 0
     * 出现2次，ones = 0         twos = 数本身
     * 出现3次，ones = 0         twos = 0(相当于做了一次清除工作)
     *
     *
     * @param nums
     * @return
     */
    public int singleNumberII(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    /**
     * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
     * Find the two elements that appear only once.

     For example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

     * @param nums
     * @return
     */
    public int[] singleNumberIIIOne(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> hashMap = getIntegerIntegerHashMap(nums);
        int[] ret = new int[2];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.get(nums[i]) == 1) {
                ret[j] = nums[i];
                j++;
            }
        }
        return ret;
    }

    /**
     * Idea:
     * 1.get the rightmost 1 bit(two different numbers)
     *
     * 2.divide all numbers into two groups.one with the aforementioned bit set, another with the aforementinoed bit unset.
     * Two different numbers we need to find must fall into thte two distrinct groups.
     * XOR numbers in each group, we can find a number in either group.
     * @param nums
     * @return
     */
    public int[] singleNumberIIITwo(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int diff = 0;
        for(int x : nums) {
            diff ^= x;
        }
        diff &= -diff;          //step 1
        int[] ret = {0, 0};     //step 2
        for(int x : nums) {
            if((x & diff) == 0) {
                ret[0] ^= x;
            }
            else {
                ret[1] ^= x;
            }
        }
        return ret;
    }
}
