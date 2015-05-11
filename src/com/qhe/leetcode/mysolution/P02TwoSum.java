package com.qhe.leetcode.mysolution;

/**
 * Created by Sunshine on 2015/5/10.
 * 题目链接：https://leetcode.com/problems/add-two-numbers/
 * 题目描述：You are given two linked lists representing two non-negative numbers.
 *          The digits are stored in reverse order and each of their nodes contain a single digit.
 *          Add the two numbers and return it as a linked list.
 *           Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *           Output: 7 -> 0 -> 8
 * 在做题的时候看错了题目，题目的要求是在就算完毕之后直接就返回结果，而我第一次提交的时候没有看清楚题目的要求
 * 以为需要把链表逆转进行正序输出，所以第一次没有通过（不过也正好联系了单链表的逆转操作）；删除单链表逆转部分
 * 后结果正确
 *
 */
public class P02TwoSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode tmp1 = new ListNode(4);
        ListNode tmp2 = new ListNode(3);
        l1.next = tmp1;
        tmp1.next = tmp2;
        tmp2.next = null;

        ListNode l2 = new ListNode(5);
        tmp1 = new ListNode(6);
        tmp2 = new ListNode(4);
        l2.next = tmp1;
        tmp1.next = tmp2;
        tmp2.next = null;

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode result = new ListNode(0);
        result.next = null;
        ListNode cur = result;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode node = null;
        int tmpRes = 0;  // 临时结果
        int numTen = 0;  // 十位数
        int numLow = 0;  // 个位数

        // 处理链表相加
        while(cur1 != null && cur2 != null) {
            tmpRes = cur1.val + cur2.val + numTen; // 计算某一位的结果，加上上一次的进位
            numTen = tmpRes / 10;
            numLow = tmpRes % 10;
            if(!flag) {  // 如果是第一次，那么直接赋值
                cur.val = numLow;
                flag = true;
            } else { // 否则创建新的节点，然后连接链表
                node = new ListNode(numLow);
                node.next = null;
                cur.next = node;
                cur = node;
            }

            cur1 = cur1.next;
            cur2 = cur2.next;

            if(cur1==null && cur2==null && numTen!=0) {
                // 如果同时为null且这次相加有进位产生，创建一个新节点
                node = new ListNode(numTen);
                node.next = null;
                cur.next = node;
                cur = node;
            }
        }

        // 如果l1还有节点
        while(cur1 != null) {
            tmpRes = cur1.val + numTen;
            numTen = tmpRes / 10;
            numLow = tmpRes % 10;

            node = new ListNode(numLow);
            node.next = null;
            cur.next = node;
            cur = node;

            cur1 = cur1.next;

            if(cur1 == null && numTen!=0) {
                node = new ListNode(numTen);
                node.next = null;
                cur.next = node;
                cur = node;
            }

        }

        // 如果l2还有节点
        while(cur2 != null) {
            tmpRes = cur2.val + numTen;
            numTen = tmpRes / 10;
            numLow = tmpRes % 10;

            node = new ListNode(numLow);
            node.next = null;
            cur.next = node;
            cur = node;

            cur2 = cur2.next;

            if(cur2 == null && numTen!=0) {
                node = new ListNode(numTen);
                node.next = null;
                cur.next = node;
                cur = node;
            }

        }

        // 单向链表反转
        /**
        cur1 = cur2 = result;
        cur = result.next;
        while(cur != null) {
            cur1 = cur;
            cur = cur.next;
            cur1.next = cur2;

            if(cur2 == result) {
                cur2.next = null;
            }
            cur2 = cur1;
        }

        result = cur1;
         */

        return result;
    }
}
