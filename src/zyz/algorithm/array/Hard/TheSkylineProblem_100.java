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
    public static List<List<Integer>> getSkyline(int[][] bs) {
        List<List<Integer>> ans = new ArrayList<>();

        // 预处理所有的点，为了方便排序，对于左端点，令高度为负；对于右端点令高度为正
        List<int[]> ps = new ArrayList<>();
        for (int[] b : bs) {
            int l = b[0], r = b[1], h = b[2];
            ps.add(new int[]{l, -h});
            ps.add(new int[]{r, h});
        }

        // 先按照横坐标进行排序
        // 如果横坐标相同，则按照左端点排序
        // 如果相同的左/右端点，则按照高度进行排序
        Collections.sort(ps, (a, b)->{
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // 大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int prev = 0;
        q.add(prev);
        for (int[] p : ps) {
            int point = p[0], height = p[1];
            if (height < 0) {
                // 如果是左端点，说明存在一条往右延伸的可记录的边，将高度存入优先队列
                q.add(-height);
            } else {
                // 如果是右端点，说明这条边结束了，将当前高度从队列中移除
                q.remove(height);
            }

            // 取出最高高度，如果当前不与前一矩形“上边”延展而来的那些边重合，则可以被记录
            int cur = q.peek();
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(cur);
                ans.add(list);
                prev = cur;
            }
        }
        return ans;
    }

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
