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
        int[] res;
        res = twoSum(NUMBERS, TARGET);

        for(int result : res)
            System.out.print(result + " ");
        System.out.println();
    }

    /**
     * ��˼·��
     *     ����һ�������ֵΪ���±�Ϊֵ��HashMap������������飬ʹ�������ֵ��HashMap��ȡ�±꣬
     *     ���Ϊ�գ�˵���Ѿ��ҵ�����ѭ�����һ����ֵ�����±�Է���HashMap�С�
     * @param numbers : �������Ҫ���������
     * @param target �� Ŀ��ֵ
     * @return ����������꣬
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


