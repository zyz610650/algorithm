package zyz.algorithm.DynamicProgramming.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 三角形最小路径和
 * @seq: 28
 * @address: https://leetcode-cn.com/problems/triangle/
 * @idea:
 *  思路1:dfs
 *  思路2:dp
 *   1.dp[i][j] 第i行第j列位置上的最小路径和
 *   2.dp[i][j]=min{dp[i-1][j],dp[i-1][j+1]}
 *
 *   //该题看怎么优化空间即可
 */
public class Triangle_28 {

    public static void main(String[] args) {


    }

    //优化空间  主要看这个 主要思考下 优化空间的方法
    public int minimumTotal1(List<List<Integer>> triangle){

        int n=triangle.size();
        int[][] dp=new int[2][n];
        dp[0][0]=triangle.get(0).get(0);
        int cnt,pre;
        for (int i=1;i<n;++i)
        {
            cnt=i%2;
            pre=1-cnt;
            dp[cnt][0]=dp[pre][0]+triangle.get(i).get(0);
            for(int j=1;j<i;++j)
            {
                dp[cnt][j]=Math.min(dp[pre][j],dp[pre][j-1])+triangle.get(i).get(j);
            }
            dp[cnt][i]=dp[pre][i-1]+triangle.get(i).get(i);
        }
        int minTotal = dp[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[(n - 1) % 2][i]);
        }
        return minTotal;


    }


/*
官方处理特殊列的方法和我的不同:
           f[i][0] = f[i - 1][0] + triangle.get(i).get(0);  用来处理j=0
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i); 用来处理j=i
 */

    //这里triangle中没一个list的元素一定小于等于triangle.size(),就无需用List存储,直接用二维数组,这里用List写的有点麻烦
    // 这里List来回获取元素,和用了多个lIst浪费了空间，主要是之前没看出来 这里triangle中没一个list的元素一定小于等于triangle.size()
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1) return triangle.get(0).get(0);
        int min=10000000;
        List<List<Integer>> dp=new ArrayList<>();
        dp.add(triangle.get(0));

        List<Integer> prelist;
        List<Integer> curlist;
        List<Integer> list;
        int tmp=0;
        for(int i=1;i<triangle.size();i++)
        {
            prelist=dp.get(i-1);
            curlist=triangle.get(i);

            list=new ArrayList<>();
            for(int j=0;j<curlist.size();j++)
            {
                tmp=10000000;
                //跟自己同一列比
                if(j<prelist.size()) tmp=Math.min(tmp,prelist.get(j));
                if(j-1>=0)           tmp=Math.min(tmp,prelist.get(j-1));
                list.add(tmp+curlist.get(j));
                if(i==triangle.size()-1)
                {
                    min=Math.min(min,tmp+curlist.get(j));
                    System.out.println(min);
                }
            }

            dp.add(list);
        }
        System.out.println(dp.toString());
        return min;
    }
}
