package recursion;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKLists {

   //采用分治的思想去完善
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists,0,lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if(start == end){
            return lists[start];
        }
        //取中间值进行分治
        int middle = (end - start) / 2;
        ListNode left = divide(lists,start,middle); // 以最左边的链表开始分治
        ListNode right = divide(lists,middle+1,end); //以最右边的链表开始分治
        return integrate(left,right); //链表排序合并方法
    }

    public static void main(String[] args) {
        int k = 0;
        int[] temp = new int[2];
        temp[k++] = 1;
        System.out.println(temp[0]+", k ="+k);
    }
    private ListNode integrate(ListNode left, ListNode right) {
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.val < right.val){
            left.next = integrate(left.next,right);
            return left;
        }else{
            right.next = integrate(right.next,left);
            return right;
        }
    }
}