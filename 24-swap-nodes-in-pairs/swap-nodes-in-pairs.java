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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null && curr.next!=null){
            ListNode swap=curr.next;
            curr.next=swap.next;
            swap.next=curr;
            if(prev==null){
                head=swap;
            }else{
                prev.next=swap;
            }
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}