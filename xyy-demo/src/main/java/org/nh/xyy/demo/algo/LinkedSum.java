package org.nh.xyy.demo.algo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * LinkedSum
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/6 9:35
 */
public class LinkedSum {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(8);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        node12.next = node13;
        node11.next = node12;

        ListNode node21 = new ListNode(2);
/*
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node22.next = node23;
        node21.next = node22;
*/

        ListNode node = new LinkedSum().addTwoNumbers2(node11, node21);
        while (node != null){
            System.out.println("val : " + node.val);
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int stage = 0;
        while (tmp1 != null && tmp2 != null) {
            int sum = tmp1.val + tmp2.val;
            if (stage > 0) {
                sum++;
                stage = 0;
            }
            if (sum >= 10) {
                sum %= 10;
                stage++;
            }
            listNodes.add(new ListNode(sum));
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        //解决长度不一致
        stage = solutionLength(listNodes, tmp1, stage);
        stage = solutionLength(listNodes, tmp2, stage);
        if(stage > 0){
            listNodes.add(new ListNode(1));
        }
        for ( int i = 0; i < listNodes.size() - 1; i++){
            ListNode node = listNodes.get(i);
            node.next = listNodes.get(i + 1);
        }
        return listNodes.get(0);
    }

    private int solutionLength(List<ListNode> listNodes, ListNode tmp, int stage) {
        while(tmp != null){
            if(stage > 0){
                tmp.val++;
            }
            if(tmp.val >= 10){
                tmp.val = tmp.val % 10;
                stage = 1;
            } else {
                stage = 0;
            }
            listNodes.add(tmp);
            tmp = tmp.next;
        }
        return stage;
    }

    /**
     * 这个比较强, 不服不行
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        int cache = 0;

        ListNode l3 = resultList;
        while (l1 != null || l2 != null || cache > 0){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int l3Val = l1Val + l2Val + cache;
            cache = 0;

            // 判断是否大于 9 大于9 进一位
            if (l3Val >  9){
                cache = 1;
                l3Val = l3Val - 10;
            }

            l3.next = new ListNode(l3Val);

            l3 = l3.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        return resultList.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}