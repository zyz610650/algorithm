package zyz.algorithm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的节点
 * @author: @zyz
 */
public class Node {
	public int val;
	public List <Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList <Node> ();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
