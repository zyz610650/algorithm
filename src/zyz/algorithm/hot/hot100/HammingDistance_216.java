package zyz.algorithm.hot.hot100;

/**
 * @author: @zyz
 */
public class HammingDistance_216 {

	public static void main (String[] args) {
		System.out.println (hammingDistance (1,4));
	}

	public static int hammingDistance(int x, int y) {
		int s = x ^ y, ret = 0;
		while (s != 0) {
			ret += s & 1;
			s >>= 1;
		}
		return ret;
	}



	public int hammingDistance1(int x, int y) {
		int n=0;
		int max=Math.max(x,y);
		while(max>0)
		{

			int c1=x&1;
			int c2=y&1;
			if(c1!=c2) n++;
			x=x>>1;
			y=y>>1;
			max=max>>1;
		}
		return n;
	}
}
