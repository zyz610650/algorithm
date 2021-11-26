package zyz.algorithm.hot.hot100;

/**
 * @author zyz
 * @title: 合并两个有序链表
 * @seq: 21
 * @address: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @idea:
 * 也可以看看中心扩散法
 */
public class PalindromicSubstrings_224 {
	public static void main (String[] args) {
	String str="aaa";
		System.out.println (countSubstrings (str));
	}

	/**
	 * dp
	 * @param s
	 * @return
	 */
	public static int countSubstrings(String s) {
		int n=s.length();
		char[] arr=s.toCharArray();
		boolean[][] dp=new boolean[n][n];
		int cnt=n;

		for(int i=0;i<n-1;i++)
		{
			dp[i][i]=true;
			if(arr[i]==arr[i+1])
			{
				dp[i][i+1]=true;
				cnt++;
			}
		}
		dp[n-1][n-1]=true;
		for(int i=3;i<=n;i++)//长度
		{
			for(int j=0;j+i-1<n;j++)
			{
				if(arr[j]==arr[j+i-1]&&dp[j+1][j+i-2])
				{
					dp[j][j+i-1]=true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
