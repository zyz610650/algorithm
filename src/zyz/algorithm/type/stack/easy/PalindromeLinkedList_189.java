package zyz.algorithm.type.stack.easy;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 回文链表
 * @seq: 234
 * @address: https://leetcode-cn.com/problems/palindrome-linked-list/
 * @idea:
 * 需要知道有三种方法
 */
public class PalindromeLinkedList_189 {

	static ListNode frontNode;
	public boolean isPalindrome(ListNode head) {
		frontNode=head;

		return dfs(head);
	}
	public static boolean dfs(ListNode head)
	{
		if(head==null) return true;
		if(!dfs(head.next))
		{
			return false;
		}
		if(head.val!=frontNode.val) return false;
		frontNode=frontNode.next;
		return true;
	}
}
