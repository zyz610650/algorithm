package zyz.algorithm.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zyz
 * @title: 全排列
 * @seq: 46
 * @address: https://leetcode-cn.com/problems/permutations/
 * @idea:
 */
public class Permutations_46 {


    static List<List<Integer>> lists=new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] vis=new boolean[nums.length];
        List<Integer> list=new ArrayList<>();
        dfs1(nums,vis,0,nums.length,list);
        return lists;
    }
    static void  dfs(int[] nums,boolean[] vis,int index,int n,List<Integer> list)
    {

        if(index==n)
        {
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i]) continue;
//         if(vis[i]||(i!=0&&!vis[i-1]&&nums[i]==nums[i-1])) continue;
          //  他只会选第一个数后面重复的就不会进入下一层循环 所以不需要重复考虑 所以下面这个判断是冗余的 用上面那个就行了
            int tmp=i-1;
            int flag=0;
            while(tmp>=0&&nums[i]==nums[tmp])
            {
                if (!vis[tmp])
                {
                    flag=1;
                    break;
                }
                tmp--;
            }
            if (flag==1) continue;
            vis[i]=true;
            list.add(nums[i]);
            dfs(nums,vis,index+1,n,list);
            list.remove(index);
            vis[i]=false;
        }
    }
    static void  dfs1(int[] nums,boolean[] vis,int index,int n,List<Integer> list)
    {

        if(index==n)
        {
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++)
        {

           if(vis[i]||(i!=0&&!vis[i-1]&&nums[i]==nums[i-1])) continue;
            vis[i]=true;
            list.add(nums[i]);
            dfs(nums,vis,index+1,n,list);
            list.remove(index);
            vis[i]=false;
        }
    }
}
//1,1,1,2,3,4
//
//1(1) 4 1
//[1, 2, 1, 1, 3, 4], [1, 2, 1, 1, 4, 3], [1, 2, 1, 3, 1, 4], [1, 2, 1, 3, 4, 1], [1, 2, 1, 4, 1, 3], [1, 2, 1, 4, 3, 1]