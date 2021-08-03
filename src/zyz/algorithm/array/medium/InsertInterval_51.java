package zyz.algorithm.array.medium;

import zyz.algorithm.utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

/**
 * @author zyz
 * @title: 插入区间
 * @seq: 57
 * @address: https://leetcode-cn.com/problems/insert-interval/
 * @idea:
 */
public class InsertInterval_51 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] l=insert(intervals,newInterval);
        Utils.print2Arr(l);
        System.out.println();
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int m=intervals.length;
        int[][] newArray=new int[m+1][2];
        int[][] array=new int[m+1][];
        extendArray(newArray,intervals);
        newArray[m]=newInterval;
        Arrays.sort(newArray,(o1,o2)->{
            return o1[0]-o2[0];
        });
        array[0]=newArray[0];
        int tmp=0;
        for(int i=1;i<m+1;i++)
        {
            if(newArray[i][0]>array[tmp][1])
            {
                array[++tmp]=newArray[i];
            }else{
                array[tmp][0]=array[tmp][0];
                array[tmp][1]=Math.max(array[tmp][1],newArray[i][1]);
            }
        }
        return Arrays.copyOf(array,tmp+1);
    }

    public static void extendArray(int[][] newArray,int[][] oldArray)
    {
        for(int i=0;i<oldArray.length;i++)
        {
            System.arraycopy(oldArray[i],0,newArray[i],0,oldArray[i].length);
        }
    }
}
