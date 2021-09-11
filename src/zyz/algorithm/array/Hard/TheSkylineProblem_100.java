package zyz.algorithm.array.Hard;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * @author zyz
 * @title: 天际线问题
 * @seq: 218
 * @address: https://leetcode-cn.com/problems/the-skyline-problem/
 * @idea:
 */
public class TheSkylineProblem_100 {
    public static void main(String[] args) {

        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};


        System.out.println(getSkyline1(buildings));
    }
   t a

    public static List<List<Integer>> getSkyline1(int[][] buildings) {

        List<List<Integer>> lists=new ArrayList<>();
        int m=buildings.length;
        List<int[]> ps=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            ps.add(new int[]{buildings[i][0],-buildings[i][2]});
            ps.add(new int[]{buildings[i][1],buildings[i][2]});
        }
        Collections.sort(ps,(a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        Queue<Integer> queue=new PriorityQueue<>((a,b)->  b-a);
        int prev=0,cnt;
        queue.add(0);
        for(int[] p:ps)
        {
            int x=p[0],y=p[1];
            if(y<0) queue.add(-y);
            else queue.remove(y);
            cnt=queue.peek();
            if(cnt!=prev)
            {
                List<Integer> list=new ArrayList<>();
                list.add(x);
                list.add(cnt);
                lists.add(list);
                prev=cnt;
            }

        }
        return lists;

    }

}
