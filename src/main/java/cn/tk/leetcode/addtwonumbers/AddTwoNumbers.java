package cn.tk.leetcode.addtwonumbers;

/**
 * Created by xiedan on 16/8/22.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
    /**
     *
     *
     recursion
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        return addLists(l1,l2,0);
    }

    private static ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) return null;
        int digit = carry;
        digit += (l1 != null) ? l1.val : 0;
        digit += (l2 != null) ? l2.val : 0;
        carry = digit / 10;     //进位
        digit = digit % 10;     //本位
        ListNode head = new ListNode(digit);
        head.next = addLists((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, carry);
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(8);
        ListNode sumListI = addTwoNumbersI(l1, l2);
        ListNode sumListII = addTwoNumbersII(l1, l2);
        while(sumListI != null) {
            System.out.println("sumListI value : " + sumListI.val);
            sumListI = sumListI.next;
        }
        while(sumListII != null) {
            System.out.println("sumListII value : " + sumListII.val);
            sumListII = sumListII.next;
        }
    }

    /**
     *
     iterator
     * @param l1
     * @param l2
     * @return

     */
    private static ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        //处理最高位进位
        if(carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
