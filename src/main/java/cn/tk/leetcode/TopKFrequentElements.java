package cn.tk.leetcode;

import java.util.*;

/**
 * Created by xiedan on 16/9/15.
 *
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3,3,4] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElements {
    public static void main(String args[]) {
        int nums[] = {1,1,1,2,2,3,3,4};
        List<Integer> retList = topKFrequent(nums, 2);
        for (Integer x : retList
             ) {
            System.out.println("the returned element value: " + x);
        }
    }

    /**
     * 思想:桶排
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];         //防止数组越界
        Map<Integer, Integer> frequencyMap = getFrequencyHashMapI(nums);
        //frequencyMap = getFrequencyHashMapII(nums);
        for (int key : frequencyMap.keySet()
                ) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> retList = new ArrayList<Integer>();
        for (List<Integer> list : bucket
             ) {
            System.out.println("bucket: " + list);
        }
        //这里i必须大于等于0(数组下标是从0开始),因此在定义bucket的长度时,需要nums.length + 1。
        for (int i = bucket.length - 1; i >= 0 && k > retList.size(); i--) {
            if (bucket[i] != null) {
                retList.addAll(bucket[i]);
            }
        }
        return retList.subList(0, k);
    }

    /**
     * 方法II:
     * 将数组中元素出现频率记到HashMap中
     * key:数组元素值   value:元素出现次数
     * @param nums
     */
    private static Map<Integer, Integer> getFrequencyHashMapI(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            frequencyMap.put (n, frequencyMap.getOrDefault (n, 0) + 1);
        }
        return frequencyMap;
    }

    /**
     * 将数组中元素出现频率记到HashMap中
     * key:数组元素值   value:元素出现次数
     * @param nums
     * @return
     */
    private static Map<Integer, Integer> getFrequencyHashMapII(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> frenquencyMap = new HashMap<Integer, Integer>();
        int tmpCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if(frenquencyMap.containsKey(nums[i])) {
                tmpCount++;
                frenquencyMap.put(nums[i], tmpCount);
            }
            else {
                tmpCount = 1;
                frenquencyMap.put(nums[i], tmpCount);
            }
        }
        return frenquencyMap;
    }
}
