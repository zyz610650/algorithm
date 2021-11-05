package zyz.algorithm.type.stack.medium;

import zyz.algorithm.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 重排链表
 * @seq: 143
 * @address: https://leetcode-cn.com/problems/reorder-list/
 * @idea:
 */
public class ReorderList_182 {
	// 用List也行
	public void reorderList(ListNode head) {
		Deque<ListNode> queue=new LinkedList <> ();
		ListNode node=head.next;
		while(node!=null)
		{
			queue.addLast(node);
			node=node.next;
		}
		node=head;
		boolean flag=true;


		while(!queue.isEmpty())
		{
			node.next=flag?queue.pollLast():queue.pollFirst();
			node=node.next;
			node.next=null;
			flag=!flag;
		}


	}
}
