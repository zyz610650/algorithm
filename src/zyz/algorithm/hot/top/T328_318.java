package zyz.algorithm.hot.top;

import zyz.algorithm.utils.ListNode;


/**
 * @author zyz
 * @title: 328. 奇偶链表
 * @seq: 328
 * @address: https://leetcode-cn.com/problems/odd-even-linked-list/
 * @idea:
 */
public class T328_318 {

    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode Onode=new ListNode();
        ListNode Jnode=new ListNode();
        ListNode head1=Onode;
        ListNode head2=Jnode;
        boolean  f=true;
        ListNode end=null;
        while(head!=null)
        {
            if(f)
            {
                head1.next=head;
                head1=head1.next;

                if(head.next==null||head.next.next==null) end=head1;
            }else
            {
                // System.out.println(head.val);
                head2.next=head;
                head2=head2.next;

            }
            f=(!f);
            head=head.next;
            head1.next=null;
            head2.next=null;
        }
        //  System.out.println();
        //  System.out.println(head2.val);
        Onode=Onode.next;
        Jnode=Jnode.next;
        // System.out.println(end.val);
        end.next=Jnode;
        return Onode;
    }
}
