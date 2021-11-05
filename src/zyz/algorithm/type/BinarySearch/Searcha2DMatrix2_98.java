package zyz.algorithm.type.BinarySearch;

/**
 * @author zyz
 * @title: 搜索二维矩阵 II
 * @seq: 240
 * @address: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @idea:
 *
 *   二分也能做  用二分做做试试
 */
public class Searcha2DMatrix2_98 {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;

        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int j=n-1,i=0;
        while(i<m&&i>=0&&j>=0&&j<n)
        {
            System.out.println(matrix[i][j]);
            if(matrix[i][j]<target) i++;
            else if(matrix[i][j]>target) j--;
            else return true;
        }
        return false;
    }
}
