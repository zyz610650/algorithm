package zyz.algorithm.array.medium;

import zyz.algorithm.utils.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zyz
 * @title: 矩阵置零
 * @seq: 73
 * @address: https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @idea:
 */
public class SetMatrixZeroes_54 {

    public static void main(String[] args) {
         String str="[[0,1,2,0],[3,4,5,2],[1,3,1,5]]";
         str= Utils.translant(str);
         System.out.println(str);
         int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
         Utils.print2Arr(matrix);
        System.out.println();
         setZeroes1(matrix);
        Utils.print2Arr(matrix);
    }
    //空间复杂度O(1)
    public static void setZeroes1(int[][] matrix) {
        boolean col_flag=false,row_flag=false;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++) if(matrix[i][0]==0) col_flag=true;
        for(int i=0;i<n;i++) if(matrix[0][i]==0) row_flag=true;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++)
        {
            if(matrix[i][0]==0)
                for(int j=1;j<n;j++)  matrix[i][j]=0;
        }

        for(int i=1;i<n;i++)
        {
            if(matrix[0][i]==0)
                for(int j=1;j<m;j++) matrix[j][i]=0;

        }

        if(col_flag)
        {
            for(int i=0;i<m;i++) matrix[i][0]=0;
        }

        if(row_flag)
        {
            for(int i=0;i<n;i++) matrix[0][i]=0;
        }

    }
    // 空间复杂度 O(M+N)
    public static void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<Integer>();
        Set<Integer> col=new HashSet<Integer>();
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for(Integer i:col)
        {
            for(int j=0;j<m;j++)
            {
                matrix[j][i]=0;
            }
        }

        for(Integer i:row)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=0;
            }
        }

        Utils.print2Arr(matrix);
    }
}
