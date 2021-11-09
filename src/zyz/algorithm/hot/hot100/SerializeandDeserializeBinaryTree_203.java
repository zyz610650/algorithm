package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 二叉树的序列化与反序列化
 * @seq: 297
 * @address: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @idea:
 */
public class SerializeandDeserializeBinaryTree_203 {

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb=new StringBuilder();
			Deque<TreeNode> queue=new LinkedList<>();
			queue.add(root);
			TreeNode node;
			sb.append(root.val);
			while(!queue.isEmpty())
			{
				node=queue.poll();
				if(node.left==null)
				{
					sb.append(",N");
				}else  {
					sb.append(","+node.left.val);
					queue.add(node.left);
				}

				if(node.right==null)
				{
					sb.append(",N");

				}else {
					sb.append(","+node.right.val);
					queue.add(node.right);
				}
			}
			System.out.println (sb.toString());
			return sb.toString();
		}
		// 1,2,3,N,N,4,5,N,N,N,N
// 0 1 2 3 4 5 6 7 8 9
		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if(data.length()==0) return null;
			String[] ss=data.split(",");
			TreeNode root=new TreeNode(Integer.valueOf(ss[0]));
			TreeNode node=root;
			int i=0;
			String s1,s2;
			Deque <TreeNode> queue=new LinkedList <> ();
			while(!queue.isEmpty())
			{
				node=queue.poll();
				s1=ss[i*2+1];
				s2=ss[i*2+2];
				if(!s1.equals("N")) node.left=new TreeNode(Integer.valueOf(s1));
				else node.left=null;

				if(!node.equals("N")) node.left=new TreeNode(Integer.valueOf(s2));
				else node.left=null;
				while(ss[++i].equals("N")) i++;
			}
			return root;
		}
	}
}
