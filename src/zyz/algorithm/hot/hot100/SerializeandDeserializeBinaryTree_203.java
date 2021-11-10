package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.TreeNode;

import java.util.*;

/**
 * @author zyz
 * @title: 二叉树的序列化与反序列化
 * @seq: 297
 * @address: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @idea:
 */
public class SerializeandDeserializeBinaryTree_203 {

	public static class Codec1 {

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
			queue.add (root);
			while(!queue.isEmpty())
			{
				node=queue.poll();
				s1=ss[i*2+1];
				s2=ss[i*2+2];
				if(!s1.equals("N")) {
					node.left=new TreeNode(Integer.valueOf(s1));
					queue.add (node.left);
				}
				else node.left=null;

				if(!s2.equals("N")) {
					node.right=new TreeNode(Integer.valueOf(s2));
					queue.add (node.right);
				}
				else node.right=null;
				while(ss[++i].equals("N"))
					i++;
			}
			return root;
		}
	}

	//之前之前遍历数组最后叶子节点会越界，这里改用两个队列解决这个问题
	public  class Codec_bfs {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if(root==null) return "";
			StringBuilder sb=new StringBuilder();
			Deque<TreeNode> queue=new LinkedList<>();
			queue.add(root);
			TreeNode node;
			while(!queue.isEmpty())
			{
				node=queue.poll();
				if (node==null) sb.append ("N,");
				else{
					sb.append (node.val+",");
					queue.add (node.left);
					queue.add (node.right);
				}
			}
			return sb.toString();
		}
		// 1,2,3,N,N,4,5,N,N,N,N,
// 0 1 2 3 4 5 6 7 8 9
		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if(data.length()==0||data=="") return null;
			String[] ss=data.split(",");


			Queue <String> nodes=new LinkedList<>(Arrays.asList(ss));
			TreeNode root=new TreeNode(Integer.parseInt(nodes.poll()));
			TreeNode node=root;
			Queue<TreeNode> queue=new LinkedList<>();
			queue.add(root);

			while(!queue.isEmpty())
			{
				node=queue.poll();
				String left=nodes.poll();
				String right=nodes.poll();
				if(!left.equals("N")){
					node.left=new TreeNode(Integer.parseInt(left));
					queue.add(node.left);
				}
				if(!right.equals("N"))
				{
					node.right=new TreeNode(Integer.parseInt(right));
					queue.add(node.right);
				}
			}
			return root;
		}
	}

	public  class Codec_dfs{

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root==null) return "N";
			String left  = serialize (root.left);
			String right = serialize (root.right);
			return root.val+","+left+","+right;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			Queue<String> queue=new LinkedList<>(Arrays.asList (data.split (",")));
			return dfs (queue);
		}

		public TreeNode dfs(Queue<String> queue)
		{
			String value = queue.poll ();
			if (value.equals ("N")) return null;
			TreeNode root=new TreeNode (Integer.parseInt (value));
			root.left=dfs (queue);
			root.right=dfs (queue);
			return root;
		}


	}





	public static void main (String[] args) {
//		 Codec ser = new Codec();
//         Codec deser = new Codec();
         String[] ss=("1,2,3,N,N,4,5,N,N,N,N,").split (",");
		System.out.println (Arrays.asList (ss));
		// TreeNode ans = deser.deserialize("1,2,3,N,N,4,5,N,N,N,N");
	}
}
