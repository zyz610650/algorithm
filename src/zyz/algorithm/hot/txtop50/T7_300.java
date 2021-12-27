package zyz.algorithm.hot.txtop50;

/**
 * @author zyz
 * @title: 7. 整数反转
 * @seq: 7
 * @address: https://leetcode-cn.com/problems/reverse-integer/
 * @idea:
 */
public class T7_300 {
	public int reverse(int x) {
		long res=0;
		int t=x<0?-1:1;
		x=Math.abs(x);
		while(x>0)
		{
			res=res*10+(x%10);
			x=x/10;
			if(res>Integer.MAX_VALUE) break;
		}

		if(res>Integer.MAX_VALUE)
		{
			if(t==-1&&res==(Integer.MAX_VALUE+1)) return Integer.MIN_VALUE;
			return 0;
		}
		return (int)(t*res);
	}
}
