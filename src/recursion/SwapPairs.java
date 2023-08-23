package recursion;


public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode sencond = head.next;
        swapPairs(head,sencond);
        return sencond;
    }

    public static void main(String[] args) {
        int i = 1/2;
        System.out.println(i);
    }
    void swapPairs(ListNode previous,ListNode current){
        ListNode next = current.next;
        current.next = previous;
        if(next == null){
            previous.next = null;
            return;
        }
        previous.next = next.next;
        swapPairs(next,next.next);
    }

}

