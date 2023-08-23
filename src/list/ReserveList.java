package list;

public class ReserveList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode head = reserveList(listNode);

        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    private static ListNode reserveList(ListNode listNode) {
        ListNode pre = null;
        ListNode current = listNode;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
