package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 两数相除
 * @seq: 2
 * @address: https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
 * @idea:
 */
public class AddTwoNumbers_194 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head=new ListNode();
		ListNode node=head;
		int n1,n2;
		int ext=0;
		while(l1!=null||l2!=null)
		{
			if(l1!=null)
			{
				n1=l1.val;
				l1=l1.next;
			}else n1=0;

			if(l2!=null)
			{
				n2=l2.val;
				l2=l2.next;
			}else n2=0;

			n1=n1+n2+ext;
			ext=n1/10;
			n1=n1%10;
			System.out.println (n1);
			ListNode tmp=new ListNode(n1);
			node.next=tmp;
			node=tmp;
		}
		if(ext!=0)
		{
			ListNode tmp=new ListNode(ext);
			node.next=tmp;
			node=tmp;
		}
		return head.next;
	}
}
