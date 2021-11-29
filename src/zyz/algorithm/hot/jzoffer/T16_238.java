package zyz.algorithm.hot.jzoffer;

/**
 * @author: @zyz
 */
public class T16_238 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int res=0;
		while(n>0)
		{
			if((n&1)==1) res++;
			n=n>>1;
		}
		return res;
	}
}
