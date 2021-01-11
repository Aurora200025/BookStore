package com.zzh.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aurora
 * @Date 2021/1/10 15:02
 * @Version 1.0
 */
public class leetcode {

    @Test
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + i) {
                i++;
            }
            int high = i - 1;
            StringBuilder builder = new StringBuilder(Integer.toString(nums[i]));
            if (low < high) {
                builder.append("->");
                builder.append(Integer.toString(nums[high]));
            }
            list.add(builder.toString());
        }
        return list;
//        List<String> list = new ArrayList<>();
//        int temp = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            if ((temp + 1) == nums[i + 1]) {
//                count++;
//                continue;
//            }
//            if (count == 0) {
//                list.add(String.valueOf(nums[i]));
//            }
//            list.add(temp + "->" + nums[i + 1]);
//            temp = nums[i + 1];
//        }
//        return list;
    }
}
