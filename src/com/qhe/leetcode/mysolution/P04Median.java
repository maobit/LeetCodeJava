package com.qhe.leetcode.mysolution;

/**
 * Created by sunshine on 15-5-11.
 */
public class P04Median {

    public static void main(String[] args) {
        int[] a = {1, 23, 45, 90, 100};
        int[] b ={2, 4, 6, 33, 56};

        System.out.println("Median: " + findMedianSortedArrays(a, b));
    }

    /**
     * 思路：先把两个数组合并再找中位数
     * 这种算法需要使用一个数组来保存合并后的数组
     * 在空间以及时间上的开销会增大
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums2.length + nums1.length];
        int i = 0, j = 0, k = 0;

        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]) {
                tmp[k++] = nums1[i++];
            } else {
                tmp[k++] = nums2[j++];
            }
        }

        while(i < nums1.length) {
            tmp[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            tmp[k++] = nums2[j++];
        }

        if((nums1.length + nums2.length) % 2 == 1) {
            return (double) tmp[(nums1.length+nums2.length)/2];
        } else {
            return (tmp[(nums1.length+nums2.length)/2-1] + tmp[(nums1.length+nums2.length)/2]) * 1.0 / 2;
        }
    }
}

