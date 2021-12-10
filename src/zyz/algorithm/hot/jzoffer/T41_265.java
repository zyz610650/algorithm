package zyz.algorithm.hot.jzoffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zyz
 * @title: 剑指 Offer 41. 数据流中的中位数
 * @seq: 41
 * @address: https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @idea:
 *
 */
public class T41_265 {

	Queue<Integer> A=new PriorityQueue <> (); //小顶堆
	Queue<Integer> B=new PriorityQueue<>((x,y)->(y-x)); //大顶堆

	public void addNum(int num) {
		if(A.size()==B.size())
		{
			A.add(num);
			B.add(A.poll());
		}else{
			B.add(num);
			A.add(B.poll());
		}

	}
	public double findMedian() {
		return A.size()==B.size()? (A.peek()+B.peek())/2.0:B.peek();
	}
}
