package zyz.algorithm.type.hash;

/**
 * @author zyz
 * @title: 相交链表
 * @seq: 160
 * @address: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @idea:
 */
public class IntersectionofTwoLinkedLists_177 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA=0;
		int lenB=0;
		ListNode nodeA=headA;
		ListNode nodeB=headB;
		while(nodeA!=null)
		{
			lenA++;
			nodeA=nodeA.next;
		}
		while(nodeB!=null)
		{
			lenB++;
			nodeB=nodeB.next;
		}
		if(lenA<lenB)
		{
			nodeA=headB;
			headB=headA;
			headA=nodeA;
			int tmp=lenA;
			lenA=lenB;
			lenB=tmp;
		}

		while(lenA>lenB)
		{
			headA=headA.next;
			lenA--;
		}

		while(headA!=null&&headA!=headB)
		{
			headA=headA.next;
			headB=headB.next;
		}
		return headB;
	}
}
