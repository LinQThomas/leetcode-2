package code.linqi;

public class 链表xiangjiao {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        int a = 1, b = 1;
        while (node1.next != null) {
            node1 = node1.next;
            a++;
        }
        while (node2.next != null) {
            node2 = node2.next;
            b++;
        }
        if (node1.val == node2.val) {
            //相交
            int n = a - b;

            if (n > 0) {
                while (n > 0) {
                    headA = headA.next;
                    n--;
                }
            } else if (n < 0) {
                int m = Math.abs(n);
                while (m > 0) {
                    headB = headB.next;
                    m--;
                }
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
        return null;
    }
}
