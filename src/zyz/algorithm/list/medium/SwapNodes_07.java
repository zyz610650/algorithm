package zyz.algorithm.list.medium;

/**
 * @author zyz
 * @title: 表中的节点
 * @seq: 07
 * @address: https://leetcode-cn.com/problems/swap-nodes-in-pairs/$
 * @idea:
 */
//class ListNodes()
//{
//    int val;
//    ListNode next;
//    ListNode(){}
//    ListNode(int val) {this.val=val;}
//    ListNode(int val,ListNode next){ this.val=val;this.next=next;}
//}
public class SwapNodes_07 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre=new ListNode();


        pre.next=head;
        head=pre;

        ListNode last,start;

        start=pre.next;

        while (start!=null&&start.next!=null)
        {
            last=start.next;
            start.next=last.next;
            last.next=start;
            pre.next=last;

            start=start.next;
            pre=pre.next.next;
        }
        return head.next;
    }

   //递归
    public ListNode swapPairs1(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode nexts=head.next;
        head.next=swapPairs1(nexts.next);
        nexts.next=head;
        return nexts;
    }
}
