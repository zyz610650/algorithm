package zyz.algorithm.hot.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 剑指 Offer 35. 复杂链表的复制
 * @seq: 35
 * @address: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @idea:
 */
public class T35_259 {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	public Node copyRandomList1(Node head) {
		Node nHead=new Node(1);
		Node nNode=nHead;
		Node oNode=head;
		Node tmp;
		while(oNode!=null)
		{
			tmp=new Node(oNode.val);
			nNode.next=tmp;
			nNode=tmp;
			oNode=oNode.next;
		}
		oNode=head;
		nNode=nHead.next;
		while(oNode!=null)
		{
			int n=0;
			Node t1=head;
			while(t1!=oNode.random)
			{
				n++;
				t1=t1.next;
			}
			t1=nHead.next;
			while(n>0)
			{
				t1=t1.next;
				n--;
			}
			nNode.random=t1;
			oNode=oNode.next;
			nNode=nNode.next;
		}
		return nHead.next;

	}

	Map <Node,Node> map=new HashMap <> ();
	public Node copyRandomList(Node head) {
		if(head==null) return null;
		if(!map.containsKey(head))
		{
			Node node=new Node(head.val);
			map.put(head,node);
			node.next=copyRandomList(head.next);
			node.random=copyRandomList(head.random);

		}
		return map.get(head);

	}

	public Node copyRandomList2(Node head) {
		if(head==null) return null;
		Node node=head;
		for(node=head;node!=null;node=node.next.next)
		{
			Node newNode=new Node(node.val);
			newNode.next=node.next;
			node.next=newNode;
			node=newNode.next;
		}

		for(node=head;node!=null;node=node.next.next)
		{
			Node newNode=node.next;
			newNode.random=node.random!=null?node.random.next:null;
		}
		Node nHead=new Node(1);
		node=nHead;
		while(head!=null)
		{
			node.next=head.next;
			head=head.next.next;
			node=node.next;
		}
		return nHead.next;
	}

	public Node copyRandomList3(Node head) {
		if(head==null) return null;
		Node node=head;
		for(node=head;node!=null;node=node.next.next)
		{
			Node newNode=new Node(node.val);
			newNode.next=node.next;
			node.next=newNode;

		}

		for(node=head;node!=null;node=node.next.next)
		{
			Node newNode=node.next;
			newNode.random=(node.random!=null)?node.random.next:null;
		}

		Node headNew = head.next;
		for ( node = head; node != null; node = node.next) {
			Node nodeNew = node.next;
			node.next = node.next.next;
			nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
		}
		return headNew;

	}
}
