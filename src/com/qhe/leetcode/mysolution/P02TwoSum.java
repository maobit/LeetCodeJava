package com.qhe.leetcode.mysolution;

/**
 * Created by Sunshine on 2015/5/10.
 * ��Ŀ���ӣ�https://leetcode.com/problems/add-two-numbers/
 * ��Ŀ������You are given two linked lists representing two non-negative numbers.
 *          The digits are stored in reverse order and each of their nodes contain a single digit.
 *          Add the two numbers and return it as a linked list.
 *           Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *           Output: 7 -> 0 -> 8
 * �������ʱ�򿴴�����Ŀ����Ŀ��Ҫ�����ھ������֮��ֱ�Ӿͷ��ؽ����ҵ�һ���ύ��ʱ��û�п������Ŀ��Ҫ��
 * ��Ϊ��Ҫ��������ת����������������Ե�һ��û��ͨ���Ҳ�����ϵ�˵��������ת��������ɾ��������ת����
 * ������ȷ
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
        ListNode node ;
        int tmpRes ;  // ��ʱ���
        int numTen = 0;  // ʮλ��
        int numLow ;  // ��λ��

        // �����������
        while(cur1 != null && cur2 != null) {
            tmpRes = cur1.val + cur2.val + numTen; // ����ĳһλ�Ľ�������һ�εĽ�λ
            numTen = tmpRes / 10;
            numLow = tmpRes % 10;
            if(!flag) {  // ����ǵ�һ�Σ���ôֱ�Ӹ�ֵ
                cur.val = numLow;
                flag = true;
            } else { // ���򴴽��µĽڵ㣬Ȼ����������
                node = new ListNode(numLow);
                node.next = null;
                cur.next = node;
                cur = node;
            }

            cur1 = cur1.next;
            cur2 = cur2.next;

            if(cur1==null && cur2==null && numTen!=0) {
                // ���ͬʱΪnull���������н�λ������һ���½ڵ�
                node = new ListNode(numTen);
                node.next = null;
                cur.next = node;
                cur = node;
            }
        }

        // ���l1���нڵ�
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

        // ���l2���нڵ�
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

        // �������?ת
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
