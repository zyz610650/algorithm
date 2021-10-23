package zyz.algorithm.hash;

import zyz.algorithm.utils.Node;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zyz
 * @title: 克隆图
 * @seq: 133
 * @address: https://leetcode-cn.com/problems/clone-graph/
 * @idea:
 */
public class CloneGraph_171 {

	public Node cloneGraph1(Node node) {
		if(node==null) return null;
		Map <Integer,Node> map=new HashMap <> ();
		Node root=new Node();
		addNode(map,node,root);
		return root;
	}

	static void addNode( Map<Integer,Node> map,Node node,Node copyNode)
	{

		copyNode.val=node.val;
		Node tmp;
		Node tmpNode;
		map.put(node.val,copyNode);
		for(int i=0;i<node.neighbors.size();i++)
		{
			tmp=node.neighbors.get(i);
			tmpNode=map.get(tmp.val);
			if(tmpNode==null)
			{
				tmpNode=new Node();
				addNode( map,tmp,tmpNode);
			}
			copyNode.neighbors.add(tmpNode);

		}
	}

	/**
	 * 图的邻接矩阵--DFS
	 *
	 */
	static Map<Integer,Node> visited=new HashMap <> ();
	public Node cloneGraph(Node node) {
		if(node==null)
		{
			return node;
		}
		if (visited.containsKey (node.val)) return visited.get(node.val);

		Node tmpNode=new Node (node.val);
		visited.put (node.val,tmpNode);
		for (Node tmp:node.neighbors)
		{
			tmpNode.neighbors.add (cloneGraph(tmp));
		}
		return tmpNode;
	}

	public Node cloneGraphBfs(Node node) {
		if(node==null)
		{
			return null;
		}
		Node root=node;
		Map<Integer,Node> vis=new HashMap <> ();
		Deque<Node> queue=new LinkedList <> ();
		queue.add (node);
		vis.put (node.val,new Node (node.val));

		while (!queue.isEmpty ())
		{
			node=queue.pollFirst ();
			for (Node tmp:node.neighbors)
			{
				if (!vis.containsKey (tmp.val))
				{
					vis.put (tmp.val,new Node (tmp.val));
					queue.add (tmp);
				}
				vis.get(node.val).neighbors.add (vis.get (tmp.val));
			}
		}
		return vis.get (root.val);
	}
}
