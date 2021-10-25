package zyz.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyz
 * @title: LRU 缓存机制
 * @seq: 146
 * @address: https://leetcode-cn.com/problems/lru-cache/
 * @idea:
 */
public class LRUCache_175 {

	public static void main (String[] args) {
		LRUCache lruCache=new LRUCache (3);
		lruCache.put (1,1);
		lruCache.put (2,2);
		lruCache.put (3,3);
		lruCache.put (4,4);
		lruCache.get (4);
		lruCache.get (3);
		lruCache.get (2);
		lruCache.get (1);
		lruCache.put (5,5);
		lruCache.get (1);
		lruCache.get (2);
		lruCache.get (3);
		lruCache.get (4);
		lruCache.get (5);
	}

	static class LRUCache {
		// 不能这样写 原因是indexMap里的key对应的索引还得重新更新 O（n）
		//采用双端链表实现更新
		Map <Integer,Integer> map=new HashMap <> ();
		Map<Integer,Integer> indexMap=new HashMap <> ();
		int capacity;
		List<Integer> order;
		public LRUCache(int capacity) {
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
}
