package zyz.algorithm.hot.jzoffer;


/**
 * @author zyz
 * @title: 剑指 Offer 11. 旋转数组的最小数字
 * @seq: 11
 * @address: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @idea:
 */
public class T11_233 {
	/**
	 * O(n)不太行
	 * @param numbers
	 * @return
	 */
	public int minArray(int[] numbers) {
		for(int i=1;i<numbers.length;i++)
		{
			if(numbers[i]<numbers[i-1]) return numbers[i];
		}
		return numbers[0];
	}
}
