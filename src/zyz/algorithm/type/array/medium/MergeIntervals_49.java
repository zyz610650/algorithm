package zyz.algorithm.type.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zyz
 * @title: 合并区间
 * @seq: 56
 * @address: https://leetcode-cn.com/problems/merge-intervals/
 * @idea:
 */
public class MergeIntervals_49 {

    public static void main(String[] args) {

        List<int[]> merged = new ArrayList<int[]>();
        merged.toArray(new int[merged.size()][]);

    }

    public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        if(m==1) return intervals;
        int[][] tmp=new int[m][2];

        int t=0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        }); //其中o1[1]-o2[1]表示对于第二个元素进行升序排序如果为o2[1]-o1[1]则表示为降序。

        tmp[0][0]=intervals[0][0];
        tmp[0][1]=intervals[0][1];
        for(int i=1;i<m;i++)
        {
            if(judge(intervals,tmp,t,i))
            {
                tmp[t][0]=Math.min(intervals[i][0],tmp[t][0]);
                tmp[t][1]=Math.max(intervals[i][1],tmp[t][1]);
            }else{
                t++;
                tmp[t][0]=intervals[i][0];
                tmp[t][1]=intervals[i][1];
            }
        }

//        int[][] newArray=new int[t+1][];
//        for(int i=0;i<t+1;i++)
//        {
//            newArray[i]=tmp[i];
//        }

        return Arrays.copyOf(tmp, t + 1);
    }
    public static boolean judge(int[][] intervals,int[][] tmp,int t,int index)
    {
        if(intervals[index][0]>tmp[t][1]||intervals[index][1]<tmp[t][0])
        {
            return false;
        }
        return true;
    }

}
