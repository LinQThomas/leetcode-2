package code.linqi;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 合并K个升序链表 {
    //优先队列
    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            if (listNode!=null){
                priorityQueue.add(listNode);

            }

        }
        ListNode head = new ListNode();
        ListNode tail = head;

        while (!priorityQueue.isEmpty()){
            ListNode listNode = priorityQueue.poll();
            tail.next = listNode;
            tail = tail.next;
            if (tail.next!=null){
                priorityQueue.add(tail.next);
            }
        }

        return head.next;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
