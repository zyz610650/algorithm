package zyz.algorithm.type.hash;

/**
 * @author zyz
 * @title: 环形链表 II
 * @seq: 142
 * @address: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @idea:
 * 解释一下快慢指针解析的最后一句话：
 * 这个公式说明a一定是n - 1圈加c的长度，这个时候，让ptr和慢指针同时+1着走，
 * 那么慢指针走c之后，ptr到环入口的距离只剩整n - 1圈的距离了，而且此时慢指针也刚好走到入口处了，
 * （因为我们无法确定c是多少，这个时候还得不出结论，那么：） 他俩一起走完n - 1圈的距离之后就会相遇，
 * 而且此时正好是入口
 */
public class LinkedListCycle2_174 {

	class ListNode {
		int val;
		ListNode next;

		ListNode (int x) {
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null) return null;
		ListNode slow=head;
		ListNode quick=head;

		while(quick!=null)
		{
			slow=slow.next;
			if(quick.next!=null)
				quick=quick.next.next;
			else break;
			if(quick==slow)
			{
				ListNode pre=head;
				while(pre!=slow)
				{
					pre=pre.next;
					slow=slow.next;
				}
				return pre;
			}
		}
		return null;

	}
}
