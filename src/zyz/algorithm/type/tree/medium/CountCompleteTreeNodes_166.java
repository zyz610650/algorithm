package zyz.algorithm.type.tree.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 完全二叉树的节点个数
 * @seq: 222
 * @address: https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @idea:
 *
 *   注意这里的位运算思想
 *   这里的二分搜索算法使用的是 查找左边界的那个模板
 */
public class CountCompleteTreeNodes_166 {
	public static void main (String[] args) {
		System.out.println (2&6);

	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int level = 0;
		TreeNode node = root;
		while (node.left != null) {
			level++;
			node = node.left;
		}
		//low 最后一行最左边
		//假设最后一行是满的 则high为最后一行最右边的节点
		int low = 1 << level, high = (1 << (level + 1)) - 1;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			System.out.println ("下一次循环: "+level);
			if (exists(root, level, mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public boolean exists(TreeNode root, int level, int k) {
		int bits = 1 << (level - 1);
		//即 bits = 2^(level - 1)
		// bits的二进制始终只会有一个 1存在
		// 因为Bits是2的n次方
		// 1所在的位置即为当前需要判断的层数
		System.out.println (bits);
		//level为高度
		//0开始表示当前高度
		//1开始表示当前节点
		// bits为高度
		// k为中间节点
		TreeNode node = root;
		while (node != null && bits > 0) {
			if ((bits & k) == 0) {
				node = node.left;
			} else {
				node = node.right;
			}
			bits >>= 1;
		}
		return node != null;
	}



}
