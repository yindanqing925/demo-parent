package org.nh.gome.demo.algo;

import com.alibaba.fastjson.JSON;

/**
 * 力扣21
 * @program: MergeTwoLinkedList.java
 * @description:
 * @author: yindanqing
 * @create: 2019/10/25 18:18
 */
public class MergeTwoLinkedList {

    public static void main(String[] args) {
        MergeTwoLinkedList twoLinkedList = new MergeTwoLinkedList();
        ListNode listNode = twoLinkedList.mergeTwoLists2(twoLinkedList.buildParams1(), twoLinkedList.buildParams2());
        System.out.println(JSON.toJSONString(listNode));
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
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        listNode.next = listNode1;
        return listNode2;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode index = null;
        while(l1 != null && l2 != null){
            ListNode next = null;
            if(l1.val >= l2.val){
                next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                next = new ListNode(l1.val);
                l1 = l1.next;
            }
            if(root == null){
                root = next;
                index = root;
            } else {
                index.next = next;
                index = next;
            }
        }
        if(l1 != null){
            while (l1 != null){
                ListNode next = new ListNode(l1.val);
                l1 = l1.next;
                if(root == null){
                    root = next;
                    index = root;
                } else {
                    index.next = next;
                    index = next;
                }
            }
        }
        if(l2 != null){
            while (l2 != null){
                ListNode next = new ListNode(l2.val);
                l2 = l2.next;
                if(root == null){
                    root = next;
                    index = root;
                } else {
                    index.next = next;
                    index = next;
                }
            }
        }
        return root;
    }

    /**
     * 流痞 真的流痞
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    /**
     * 这个也牛逼
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}