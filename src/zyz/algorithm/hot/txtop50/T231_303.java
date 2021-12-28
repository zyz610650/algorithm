package zyz.algorithm.hot.txtop50;

/**
 * @author: @zyz
 */
public class T231_303 {
	public static void main (String[] args) {
		System.out.println (Integer.MAX_VALUE);
	}
	public boolean isPowerOfTwo(int n) {
		int low=0,high=31;
		int mid;
		while(low<=high)
		{
			mid=(low+high)>>1;
			long res=(long)Math.pow(2,mid);
			if(res==n) return true;
			else if(res>n) high--;
			else low++;
		}
		return false;
	}
}
