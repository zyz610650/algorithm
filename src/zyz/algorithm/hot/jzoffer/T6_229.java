package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zyz
 * @title: 剑指 Offer 06. 从尾到头打印链表
 * @seq: 6
 * @address: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @idea:
 *   该题得思考有哪写方法
 *   递归 辅助栈 List 重组链表
 *
 */
public class T6_229 {
	public int[] reversePrint(ListNode head) {
		List <Integer> list=new ArrayList ();
		while(head!=null)
		{
			list.add(head.val);
			head=head.next;
		}
		int[] nums=new int[list.size()];
		for(int i=list.size()-1;i>=0;i--)
		{
			nums[list.size()-1-i]=list.get(i);
		}
		return nums;
	}
}
