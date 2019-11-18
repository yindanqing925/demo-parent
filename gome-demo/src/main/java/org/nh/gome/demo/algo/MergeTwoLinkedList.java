package org.nh.gome.demo.algo;

/**
 * @program: MergeTwoLinkedList.java
 * @description:
 * @author: yindanqing
 * @create: 2019/10/25 18:18
 */
public class MergeTwoLinkedList {

    public static void main(String[] args) {
        MergeTwoLinkedList twoLinkedList = new MergeTwoLinkedList();
        twoLinkedList.mergeTwoLists(twoLinkedList.buildParams1(), twoLinkedList.buildParams2());
    }

    private ListNode buildParams1(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode2;
        listNode.next = listNode1;
        return listNode;
    }

    private ListNode buildParams2(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        listNode1.next = listNode2;
        listNode.next = listNode1;
        return listNode2;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        /*while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                result.val =
            }
        }*/

        return result;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}