package zyz.algorithm.type.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title:  二叉搜索树中第K小的元素
 * @seq: 226
 * @address: https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @idea:
 *  题解:
 *  掌握解法一，能讲解法二，知道AVL”，够用了
 *  方法二就是提前O(n)预处理构造 构造完成后 以后频繁查找就不需要O（n） ,O（log2^n）就够了
 *  方法3 每次插入删除都保证是平衡二叉树 则插入和删除后在方法二的基础上能够保证再查找都是在时间复杂度O（log2^n）
 *  https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yua-8o07/
 *
 */
public class KthSmallestElementinaBST_168 {

	Map< TreeNode,Integer> map=new HashMap <> ();

	public int kthSmallest(TreeNode root, int k) {
		countSubNode(root);
		TreeNode node=root;
		int size;
		while (k>0)
		{
			size=map.getOrDefault (node.left,0);
			if (size==k-1) return node.val;
			else if(size>k-1)
			{
				node=node.left;
			}else{
				node=node.right;
				k=k-size-1;
			}
		}
		return 0;
	}
	public  int countSubNode(TreeNode node)
	{
		if (node==null) return 0;
		map.put (node,countSubNode (node.left)+countSubNode (node.right)+1);
		return map.get(node);
	}

}

