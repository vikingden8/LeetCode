package com.viking.leetcode;

import com.viking.leetcode.base.BaseSolution;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 1/26/18 10:38 AM
 */
public class S002_Add_Two_Numbers extends BaseSolution {

    static class ListNode{

        int number ;

        ListNode next ;

        ListNode(int number){
            this.number = number;
            this.next = null ;
        }
    }

    @Override
    protected void solution() {
        //init two list items
        ListNode nodeFirst = new ListNode(3) ;
        nodeFirst.next = new ListNode(4) ;
        nodeFirst.next.next = new ListNode(2) ;

        ListNode nodeSecond = new ListNode(4) ;
        nodeSecond.next = new ListNode(6) ;
        nodeSecond.next.next = new ListNode(5) ;

        ListNode dummyHead = new ListNode(0) ;
        ListNode p = nodeFirst, q = nodeSecond , curr = dummyHead ;
        int carry = 0 ;
        while(p != null || q != null){
            int x = (p != null) ? p.number : 0 ;
            int y = (q != null) ? q.number : 0 ;
            int sum = x + y + carry ;
            carry = sum / 10 ;
            curr.next = new ListNode(sum % 10) ;
            curr = curr.next ;
            if (p != null) p = p.next ;
            if (q != null) q = q.next ;
        }

        if (carry > 0){
            curr.next = new ListNode(carry) ;
        }

        ListNode result = dummyHead.next ;

        while (result != null){
            System.out.print("->" + result.number);
            result = result.next ;
        }
    }

    public static void main(String[] args) {
        S002_Add_Two_Numbers question = new S002_Add_Two_Numbers();
        question.solution();
    }
}
