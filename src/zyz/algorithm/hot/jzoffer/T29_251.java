package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 剑指 Offer 29. 顺时针打印矩阵
 * @seq: 29
 * @address: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @idea:
 */
public class T29_251 {

	public static void main (String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println (Arrays.toString (spiralOrder (matrix)));
	}
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix==null) return new int[0];
		if(matrix.length==0) return new int[0];
		int m=matrix.length,n=matrix[0].length;

		int t=0,num=m*n,index=0;
		int i=0,j=0;
		int[] nums=new int[num];
		while(index!=num)
		{
			for( j=t;j<n-t;j++) nums[index++]=matrix[i][j];
			j--;
			if(index==num) break;
			for( i=i+1;i<m-t;i++) nums[index++]=matrix[i][j];
			i--;
			if(index==num) break;
			for( j=n-t-2;j>=t;j--) nums[index++]=matrix[i][j];
			j++;
			if(index==num) break;
			for( i=m-t-2;i>t;i--) nums[index++]=matrix[i][j];
			if(index==num) break;
			i++;
			t++;
		}
		return nums;


	}
}
