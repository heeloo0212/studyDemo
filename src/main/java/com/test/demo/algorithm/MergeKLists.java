package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe: 23. 合并K个升序链表
 * @Author: yangqingfang
 * @Date: 2022/4/27 15:47
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 */
public class MergeKLists {

    public static void main(String[] args) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode node1 = new ListNode(1); //499
        ListNode node2 = new ListNode(4);  //500
        node1.next = node2;
        ListNode node3 = new ListNode(9); //501
        node2.next = node3;
        ListNode node4 = new ListNode(1); //502
        ListNode node5 = new ListNode(3); //503
        node4.next = node5;
        ListNode node6 = new ListNode(4); //504
        node5.next = node6;
        ListNode node7 = new ListNode(2); //505

        ListNode node8 = new ListNode(6); //506
        node7.next = node8;
        ListNode node9 = new ListNode(3); //507
        ListNode node10 = new ListNode(2);
        ListNode node11 = new ListNode(8);
        node10.next = node11;
//        ListNode node = node1.next;
//        while(node != null){
//            System.out.print(node.val+",");
//            node = node.next;
//        }
     //   ListNode[] nodes = new ListNode[]{node1,node4,node7};
        ListNode[] nodes = new ListNode[]{new ListNode(),node9,node10};
        ListNode listNode = mergeKListsMethod(nodes);
        while(listNode != null){
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }

    public static ListNode mergeKListsMethod(ListNode[] lists){
        if(lists == null || lists.length < 1){
            return null;
        }
        ListNode node = lists[0];
        for(int i=1;i<lists.length;i++){
            node = mergeTwoListsHandle(node, lists[i]);
        }
        return node;
    }

    public static ListNode mergeTwoListsHandle(ListNode root,ListNode node2){
        if(root == null && node2 == null){
            return null;
        }
        if(root == null && node2 != null){
            return node2;
        }
        if(root != null && node2 == null){
            return root;
        }
        if(root.val > node2.val) {
            ListNode tempNode = root;
            root = node2;
            node2 = tempNode;
        }
        if(root.next == null){
            if(root.val > node2.val){
                ListNode temp = node2.next;
                node2.next = root;
                node2.next.next = temp;
                return node2;
            }else{
                root.next = node2;
                return root;
            }
        }

        ListNode node1 = root.next;
        if(root.val <= node2.val && node1.val > node2.val){
            ListNode tempNode = node2.next;
            root.next = node2;
            root.next.next = node1;
            node2 = tempNode;

        }
        node1 = root.next;

        while(node1 != null && node1.next != null && node2 != null){
            int value = node1.val;
            int nextValue = node1.next.val;
            int value2 = node2.val;
            if(value <= value2 && value2 < nextValue){
                ListNode tempNode = node2.next;
                ListNode tempNode2 = node1.next;
                node1.next = node2;
                node1.next.next = tempNode2;
                node2 = tempNode;
            }
            node1 = node1.next;

        }
        //拼接最后的node2节点（node2节点后面的数都比node1大）
        node1.next = node2;


        return root;
    }

    public static ListNode mergeTwoListsHandle2(ListNode node1,ListNode node2){
        ListNode root;
        if(node1.val < node2.val){
            root = new ListNode(node1.val);
            node1 = node1.next;
        }else{
            root = new ListNode(node2.val);
            node2 = node2.next;
        }
        ListNode temp = root;
        while (node1 != null && node2 !=null){
            int value1 = node1.val;
            int value2 = node2.val;
            if(value1 < value2){
                temp.next = node1;
                node1 = node1.next;
            }else{
                temp.next = node2;
                node2 = node2.next;
            }
        }
        if(node1 == null && node2 != null){
            temp.next = node2;
        }
        if(node1 != null && node2 == null){
            temp.next = node1;
        }
        return root;
    }

}
