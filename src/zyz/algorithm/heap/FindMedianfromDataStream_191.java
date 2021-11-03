package zyz.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author zyz
 * @title: 合并K个升序链表
 * @seq: 23
 * @address: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @idea:
 * 进阶
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 这种情况，我们可以考虑建一个 0 到 100 的数组，记录传入的 num 出现的次数，并记录一个总次数，
 * 遍历数组即可很快找到中位数，因为数组大小只有 100，这个过程非常快。
 *
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 这种情况，跟上面类似，建一个 0 到 102 的数组，0 号位置表示 -1，1号位置表示 0，...，102号位置表示 101，小于 0 的数出现的次数记录到 0 号位，大于 100 的数出现的次数记录到 102 号位置，查找中位数的逻辑跟上面一样，遍历一下数组即可。
 *
 * 会这个双堆的方法即可
 */
public class FindMedianfromDataStream_191 {

	public static void main (String[] args) {
		PriorityQueue <Integer> queue=new PriorityQueue<>();
		queue.add (3);
		queue.add (2);
		queue.add (1);
		PriorityQueue<Integer> queue1=new PriorityQueue<>(queue);
		queue.poll ();
		queue.poll ();
		System.out.println (queue.size ());
		System.out.println (queue1.size ());
		System.out.println (queue);
	}

	/**
	 * 超时
	 */
	class MedianFinder1 {
		PriorityQueue <Integer> queue=new PriorityQueue<>();

		public MedianFinder1() {

		}

		public void addNum(int num) {
			queue.add(num);
		}

		public double findMedian() {


			PriorityQueue<Integer> queue1=new PriorityQueue<>(queue);
			int n=0;
			int size=queue.size();
			for(int i=0;i<queue.size()/2;i++)
				n=queue.poll();
			if(size%2!=0)
			{
				n=0;
			}
			n+=queue.poll();
			queue=queue1;
			return (n*1.0)/2.0;
		}
	}

	/**
	 * 优先队列
	 */
	class MedianFinder {
		PriorityQueue<Integer> minQueue;
		PriorityQueue<Integer> maxQueue;
		public MedianFinder() {
			minQueue=new PriorityQueue<>((a,b)-> (b-a));
			maxQueue=new PriorityQueue<>((a,b)->(a-b));
		}

		public void addNum(int num) {
			if(minQueue.isEmpty()||num<=minQueue.peek())
			{
				minQueue.offer(num);
				if(minQueue.size()>maxQueue.size()+1)
				{
					maxQueue.offer(minQueue.poll());
				}
			}else{
				maxQueue.offer(num);
				if(maxQueue.size()>minQueue.size())
				{
					minQueue.offer(maxQueue.poll());
				}
			}
		}

		public double findMedian() {
			if(maxQueue.size()==minQueue.size())
			{
				return (maxQueue.peek()+minQueue.peek())/2.0;
			}
			return minQueue.peek();
		}
	}

}

