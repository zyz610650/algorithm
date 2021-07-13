package zyz.algorithm.utils;

/**
 * @author zyz
 * @title: 工具类
 * @seq:
 * @address:
 * @idea:
 */
public class Utils {


    /**
     * 输出二维数组
     * @param arr
     */
    public static <T>  void print2Arr(boolean[][] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            System.out.println();
            for (int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+"      ");
        }
    }
}
