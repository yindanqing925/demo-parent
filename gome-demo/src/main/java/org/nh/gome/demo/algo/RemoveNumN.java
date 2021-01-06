package org.nh.gome.demo.algo;

/**
 * @program: UnKnow.java
 * @description: 删除倒数第n个节点
 * @author: yindanqing
 * @create: 2021/1/6 16:30
 */
public class RemoveNumN {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy, right = dummy;
        while (n-- > -1) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode left = tmp, right = tmp;
        while(n-- > -1){
            right = right.next;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return tmp.next;
    }
}
