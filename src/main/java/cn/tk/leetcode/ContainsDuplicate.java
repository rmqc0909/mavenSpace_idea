package cn.tk.leetcode;

import java.util.*;

/**
 s*
 * Created by xiedan on 16/8/19.
 */
public class ContainsDuplicate {
    public static void main(String args[]) {
        int [] nums = {-1,-1};
        int k = 1;
        int t = 0;
        int max = Integer.MAX_VALUE + 3;
        System.out.println(":::" + max);
        boolean containsDuplicateI = containsDuplicate(nums);       //answer1
        boolean containsDuplicateI1 = containsDuplicate1(nums);     //answer2
        boolean containsDuplicateII = containsDuplicateI(nums, k);
        boolean containsDuplicateIII = containsDuplicateII(nums, k, t);     //use bucket
        System.out.println("containsDuplicateI: " + containsDuplicateI);
        System.out.println("containsDuplicateI1: " + containsDuplicateI1);
        System.out.println("containsDuplicateII: " + containsDuplicateII);
        System.out.println("containsDuplicateIII: " + containsDuplicateIII);
    }

    /**
     * Given an array of integers,
     * find out whether there are two distinct indices i and j in the array
     * such that the difference between nums[i] and nums[j] is at most t
     * and the difference between i and j is at most k.
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    private static boolean containsDuplicateII(int[] nums, int k, int t) {
        if(nums == null || k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            long remappedNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum/((long)t + 1);
            if(map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && (remappedNum - map.get(bucket - 1) <= t))
                    || (map.containsKey(bucket + 1) && (map.get(bucket + 1) - remappedNum <= t)))
                return true;
            if(map.entrySet().size() >= k) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE)/((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    private static boolean containsDuplicate1(int[] nums) {
        if(nums == null) return false;
        Set hashSet = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) return true;
            hashSet.add(nums[i]);
        }
        return false;
    }

    /**
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the difference between i and j is at most k.
     *
     * @param nums
     * @return
     */
    private static boolean containsDuplicateI(int[] nums, int k) {
        if(nums == null || k < 1) return false;
        Set hashSet = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) return true;
            hashSet.add(nums[i]);
            if(i >= k) {
                hashSet.remove(nums[i - k]);    //保证集合中最多有k个元素
            }
        }
        return false;
    }

    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     *
     * Time complexity:O(n*log2n)
     * @param nums
     * @return
     */
    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
