package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 04. 二维数组中的查找
 * @seq: 4
 * @address: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @idea:
 */
public class T4_227 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {

		int m=matrix.length;
		if(m==0) return false;
		int n=matrix[0].length;
		int i=m-1,j=0;
		while(i>=0&&j<n)
		{
			if(matrix[i][j]==target) return true;
			if(matrix[i][j]<target)  j++;
			else i--;

		}
		return false;
	}
}
