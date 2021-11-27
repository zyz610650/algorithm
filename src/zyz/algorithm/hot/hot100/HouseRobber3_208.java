package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 打家劫舍 III
 * @seq: 337
 * @address: https://leetcode-cn.com/problems/house-robber-iii/
 * @idea:
 */
public class HouseRobber3_208 {

	class Node{
		int f;
		int g;
		public Node(int f,int g)
		{
			this.f=f;
			this.g=g;
		}
	}
	public int rob(TreeNode root) {
		Node node=dfs(root);
		return Math.max(node.f,node.g);
	}

	public Node dfs(TreeNode root){

		if(root==null) return new Node(0,0);
		Node left=dfs(root.left);
		Node right=dfs(root.right);
		int f=left.g+right.g+root.val;
		// 需要注意这点 如果不选当前root节点，则以root为根的子树最大值是 选其子树或不选其子树能取得的最大值
		// Math.max(left.f,left.g)+Math.max(right.f,right.g);
		int g=Math.max(left.f,left.g)+Math.max(right.f,right.g);
		return new Node(f,g);
	}
}
