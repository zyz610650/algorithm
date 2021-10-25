package zyz.algorithm.hash;

/**
 * @author zyz
 * @title: 环形链表
 * @seq: 141
 * @address: https://leetcode-cn.com/problems/linked-list-cycle/
 * @idea:
 *  需要会的是 「Floyd 判圈算法」（又称龟兔赛跑算法）
 *  https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 */
public class LinkedListCycle_173 {

class ListNode {
	int val;
	ListNode next;

	ListNode (int x) {
		val = x;
		next = null;
	}
}
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode slowNode=head;
		ListNode quickNode=head;
		do{
			slowNode=slowNode.next;
			if(quickNode.next!=null)
				quickNode=quickNode.next.next;
			else quickNode=null;
		}while(quickNode!=null&&slowNode!=quickNode);
		if(quickNode==slowNode&&quickNode!=null&&slowNode!=null)
		{
			return true;
		}else {
			return false;
		}
	}

}
