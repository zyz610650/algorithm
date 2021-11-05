package zyz.algorithm.type.array.medium;

import zyz.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 螺旋矩阵
 * @seq: 54
 * @address: https://leetcode-cn.com/problems/spiral-matrix/
 * @idea:
 */
public class SpiralMatrix_50 {
    public static void main(String[] args) {
       int[][] matrix = {{7},{9},{6}};
       Utils.print2Arr(matrix);
       System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        int t = 0;
        while (t != (m / 2 + 1)) {
            for (; j < n - t; ++j) {
                list.add(matrix[i][j]);
            }
            i++;
            j--;
            if(list.size()==m*n) break;
            for (; i < m - t; i++) {
                list.add(matrix[i][j]);
            }
            i--;
            j--;
            if(list.size()==m*n) break;
            for (; j >= t; --j) {
                list.add(matrix[i][j]);
            }
            i--;
            j++;
            if(list.size()==m*n) break;
            for (; i > t; i--) {
                list.add(matrix[i][j]);
            }
            if(list.size()==m*n) break;
            t++;
            i = t;
            j++;
        }
        return list;
    }
}
