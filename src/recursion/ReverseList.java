package recursion;

public class ReverseList {
    public ListNode reverseList(ListNode head) {


        return reverseList(null,head);

//        ListNode n_next = next.next;
//        next.next = head;

    }

    public ListNode reverseList(ListNode previous,ListNode current){
        ListNode next = current.next;
        if(current.next == null){
            current.next = previous;
            return current;
        }
        current.next = previous;
        return reverseList(current,next);
    }

    public static void main(String[] args) {
        new ReverseList().main1(null);
    }

    public void main1(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode = new ListNode(1,listNode2);
        System.out.println(reverseList(listNode).val);
    }


}
