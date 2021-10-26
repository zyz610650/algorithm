package zyz.algorithm.hash;

import java.util.*;

/**
 * @author zyz
 * @title: LRU 缓存机制
 * @seq: 146
 * @address: https://leetcode-cn.com/problems/lru-cache/
 * @idea:
 * //  自己实现一定要注意 每个变化的节点都要考虑是否要改变其左指针和右指针
 * 还要考虑 是否其为最后一个元素 而其右指针为null
 */
public class LRUCache_175 {

	static LRUCache lruCache=new LRUCache (3);
	public static void main (String[] args) {

		put (1,1);

		put (2,2);

		put (3,3);
		put (4,4);
		get (4); //2 3 4
		get (3);// 2 4 3
		get (2);// 4 3 2
		get (1);
		put (5,5);
		get (1);
		get (2);
		get (3);
		get (4);
		get (5);
	}
	public static void  put(int key,int value)
	{
		lruCache.put (key,value);
		System.out.print ("null ");
	}
	public static void get(int key)
	{
		System.out.print (lruCache.get (key)+" ");
	}


	static class LRUCache1 {
		// 不能这样写 原因是indexMap里的key对应的索引还得重新更新 O（n）
		//采用双端链表实现更新
		Map <Integer,Integer> map=new HashMap <> ();
		Map<Integer,Integer> indexMap=new HashMap <> ();
		int capacity;
		List<Integer> order;
		public LRUCache1(int capacity) {
			this.capacity=capacity;
			order=new ArrayList <> (capacity);
		}

		public int get(int key) {
//			System.out.println ("重复： 覆盖 : "+key);
			System.out.print ("获取数据："+key);
			if(map.containsKey(key))
			{

				int index = indexMap.get (key);
				order.remove (index);

				System.out.println (" 存在 索引为"+ index+"更新 "+order.size ());
				putIndex( key, map.get (key));
				return map.get(key);
			}
			else return -1;
		}

		public void put(int key, int value) {
			if(map.containsKey(key))
			{
//				System.out.println ("重复： 覆盖 : "+key);
				int index = indexMap.get (key);
				order.remove (index);
				putIndex( key, value);
				return;
			}

			if(map.size()<capacity)
			{
				System.out.println ("不重复： 缓存大小为：  "+map.size ()+"  直接插入"+key);
				putIndex(key,value);
			}else{
				System.out.println ("不重复： 超过缓存,缓存大小为：  "+map.size ()+"  删除"+order.get (0)+"插入 "+key);
				indexMap.remove (order.get (0));
				map.remove (order.get (0));
				order.remove (0);

				putIndex(key,value);
			}
		}

		public void putIndex(int key,int value)
		{
			map.put (key,value);
			indexMap.put (key,order.size ());
			order.add (key);

		}

	}
	static class DNode{
		DNode left;
		DNode right;
		int val;
		int key;
		public DNode (int key,int val) {
			this.val=val;
			this.key=key;
		}
		public DNode ( ) {
		}
	}
	static class LRUCache2 {
		// tail插入
		//head 删除
		int capacity;
		DNode head,tail;
		int size=0;
		Map<Integer,DNode> map;
		public LRUCache2(int capacity) {
			this.capacity=capacity;
			head=new DNode ();
			head.right=null;
			tail=head;
			map=new HashMap <> ();
		}

		public int get(int key) {
			if (map.containsKey (key))
			{
				moveNodeToLast (map.get (key));
				return map.get (key).val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (map.containsKey (key))
			{
				map.get (key).val=value;
				moveNodeToLast (map.get (key));
				return;
			}
			if (size>=capacity)
			{
				map.remove (head.right.key);
				size--;
				head.right=head.right.right;
				if(head.right!=null)
					head.right.left=head;
				else tail=head;
			}
			DNode node=new DNode (key,value);
			map.put (key,node);
			addNodeToLast (node);
			//printList();
		}

		public void addNodeToLast(DNode dNode)
		{
			tail.right=dNode;
			dNode.left=tail;
			dNode.right=null;
			tail=dNode;
			size++;
		}

		public void moveNodeToLast(DNode dNode)
		{
			if (dNode==tail) return;
			DNode tmp=dNode.left;
			tmp.right=dNode.right;
			dNode.right.left=tmp;
			tail.right=dNode;
			dNode.left=tail;
			dNode.right=null;
			tail=dNode;
		}
		public void printList()
		{
			DNode node=head.right;
			while (node!=null)
			{
				System.out.print(node.key+" ");
				node=node.right;
			}
			System.out.println ();
		}
	}

	static class LRUCache extends LinkedHashMap <Integer, Integer> {
		private int capacity;

		public LRUCache(int capacity) {
			super(capacity, 0.75F, true);
			this.capacity = capacity;
		}

		public int get(int key) {
			return super.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			super.put(key, value);
		}


		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
			return size() > capacity;
		}
	}


}

