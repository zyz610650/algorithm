package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyz
 * @title: 剑指 Offer 37. 序列化二叉树
 * @seq: 37
 * @address: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/submissions/
 * @idea:
 *      这道题自己做错的原因没有考虑到
 * 		数字可能是负数或者>=10的情况,这时候就不能用char存储
 * 		应该用 ” , "隔开,用String存储
 *
 * 		并且char不能直接转int
 * 	之前自己用int 来扫描自己遍历到哪个元素,这里使用了队列来代替 简便
 */


public class T37_261 {

	public static void main (String[] args) {
		char ch='2';
		int n=ch;
		int n1=Integer.valueOf (ch);

		System.out.println (n);
		System.out.println (n1);
	}

	public class Codec {
		// 注意char和int转换
		// Encodes a tree to a single string.
		public String serialize (TreeNode root) {

			StringBuilder sb = new StringBuilder ();
			dfs (root , sb);
			System.out.println (sb.toString ());
			return sb.toString ();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize (String data) {
			Queue < String > queue = new LinkedList <> (Arrays.asList (data.split (",")));
			return createTree (queue);



		}

		public TreeNode createTree (Queue < String > queue) {
			if (queue.isEmpty ()) return null;
			String ch = queue.poll ();
			if (ch.equals ("#")) return null;


			TreeNode node = new TreeNode (Integer.valueOf (ch));

			node.left = createTree (queue);
			node.right = createTree (queue);
			return node;
		}

		public void dfs (TreeNode root , StringBuilder sb) {
			if (root == null) {
				sb.append ("#,");
				return;
			}
			sb.append (root.val + ",");
			dfs (root.left , sb);
			dfs (root.right , sb);
		}
	}
}
