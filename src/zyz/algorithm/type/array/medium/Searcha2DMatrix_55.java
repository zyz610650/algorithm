package zyz.algorithm.type.array.medium;

/**
 * @author zyz
 * @title: 搜索二维矩阵
 * @seq: 74
 * @address: https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @idea:
 */
public class Searcha2DMatrix_55 {

    public static void main(String[] args) {

        System.out.println();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row=binarySearch_Col(matrix,target);
        if(matrix[row][matrix[0].length-1]==target) return true;
        int col=binarySearch_Row(matrix,target,row);
        if(matrix[row][col]==target) return true;

        return false;
    }

    public static int binarySearch_Col(int[][] matrix,int target)
    {
        int low=0,high=matrix.length;
        int m=matrix[0].length;
        int mid;
        while(low<=high)
        {
            mid=(high-low)/2+low;
            if(matrix[mid][m-1]==target)
            {
                return mid;
            }else if(matrix[mid][m-1]>target)
            {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static int binarySearch_Row(int[][] matrix,int target,int row)
    {
        int low=0,high=matrix[0].length;
        int mid;
        while(low<=high)
        {

            mid=(high-low)/2+low;
            if(matrix[row][mid]==target)
            {
                return mid;
            }else if(matrix[row][mid]>target)
            {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
