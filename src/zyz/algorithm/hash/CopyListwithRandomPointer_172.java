package zyz.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: @zyz
 */
public class CopyListwithRandomPointer_172 {
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
	Map <Node ,Node> map=new HashMap <> ();
	public Node copyRandomList(Node head) {
		if(head==null) return null;
		if(!map.containsKey(head))
		{
			Node copyNode=new Node(head.val);
			map.put(head,copyNode);
			copyNode.next=copyRandomList(head.next);
			copyNode.random=copyRandomList(head.random);
		}

		return map.get(head);

	}

}
