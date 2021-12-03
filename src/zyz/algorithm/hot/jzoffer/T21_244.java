package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @seq: 21
 * @address: https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @idea:
 */
public class T21_244 {

	public int[] exchange(int[] nums) {
		int x=0,n=nums.length;
		int y=n-1;
		while(x<y)
		{
			while(x<y&&nums[x]%2!=0) x++;
			while(y>x&&nums[y]%2==0) y--;
			if(x<n&&y>=0)
			{
				int tmp=nums[x];
				nums[x]=nums[y];
				nums[y]=tmp;
				x++;
				y--;
			}
		}
		return nums;

	}
}
