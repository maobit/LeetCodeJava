package com.qhe.leetcode.mysolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sunshine on 2015/4/13.
 * Problem ID: 1
 * Problem Source: https://leetcode.com/problems/two-sum/
 * Problem Title: Two Sum
 * Problem Description:
 *     Given an array of integers, find two numbers such that they add up to a specific target number.
 *     The function twoSum should return indices of the two numbers such that they add up to the target,
 *     where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 *     are not zero-based.
 *     You may assume that each input would have exactly one solution.
 *     Input: numbers={2, 7, 11, 15}, target=9
 *     Output: index1=1, index2=2
 */
public class P01TwoSum {
    private static final int[] NUMBERS = {2, 7, 11, 15};
    private static final int TARGET = 9;


    public static void main(String[] args) {
        int[] res = new int[2];
        res = twoSum(NUMBERS, TARGET);

        for(int result : res)
            System.out.print(result + " ");
        System.out.println();
    }

    /**
     * 基本思路：
     *     建立一个数组的值为键，下标为值的HashMap；遍历整个数组，使用数组的值从HashMap中取下标，
     *     如果不为空，说明已经找到；在循环最后将一个数值——下标对放入HashMap中。
     * @param numbers : 输入的需要计算的数组
     * @param target ： 目标值
     * @return 返回两个坐标，
     */
    protected static int[] twoSum(int[] numbers, int target) {
        int[] result = {0, 0};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++) {
            int rest = target - numbers[i];
            if(map.get(rest) != null) {
                result[1] = i + 1;
                result[0] = map.get(rest) + 1;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}


