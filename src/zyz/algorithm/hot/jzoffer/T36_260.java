package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 36. 二叉搜索树与双向链表
 * @seq: 36
 * @address: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @idea:
 */
public class T36_260 {
	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	Node pre,head;
	public Node treeToDoublyList(Node root) {
		if(root==null) return root;
		dfs(root);
		head.left=pre;
		pre.right=head;
		return head;
	}

	public void dfs(Node root)
	{
		if(root==null) return;
		dfs(root.left);
		if(pre==null) head=root;
		else pre.right=root;
		root.left=pre;
		pre=root;
		dfs(root.right);


	}
}
