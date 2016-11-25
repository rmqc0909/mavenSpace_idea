package cn.tk.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiedan11 on 2016/9/12.
 */
public class SubSet {
    /**
     *起始subset集为：[]
     添加S0后为：[], [S0]
     添加S1后为：[], [S0], [S1], [S0, S1]
     添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
     显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        retList.add(tmp);   //add empty set
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < retList.size(); j++) {
                tmp = new ArrayList<Integer>(retList.get(j));   //must create a new tmp object, and add element to it.
                tmp.add(nums[i]);
                retList.add(tmp);
            }
        }
        return retList;
    }
}
