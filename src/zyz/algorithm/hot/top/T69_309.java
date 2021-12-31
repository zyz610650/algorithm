package zyz.algorithm.hot.top;

/**
 * @author zyz
 * @title: 69. Sqrt(x)
 * @seq: 69
 * @address: https://leetcode-cn.com/problems/sqrtx/
 * @idea:
 * 因为题目是向下取整 比如8 最后得到得结果 因该是2.8  所以自动向上取整为3 了 这里要求向下取整 所以进行额外的判断 看是否-1
 */
public class T69_309 {
	public static void main (String[] args) {
		System.out.println (mySqrt (4));
		System.out.println (Math.sqrt (8));
	}
	public static int mySqrt(int x) {
		if(x==1) return x;
		if(x==0) return x;
		int low=1,high=x/2;
		while(low<high)
		{

			int mid=low+(high-low)/2;
			if(mid==x/mid) return mid;
			else if(mid<x/mid) low=mid+1;
			else high=mid-1;
		}
		return low;

	}
}
