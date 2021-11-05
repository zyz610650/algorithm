package zyz.algorithm.type.array.medium;

/**
 * @author zyz
 * @title: 加油站
 * @seq: 134
 * @address: https://leetcode-cn.com/problems/gas-station/
 * @idea:
 */
public class GasStation_71 {

    public static void main(String[] args) {
        int[] gas= {5,1,2,3,4};
        int[] cost={4,4,1,5,1};
        System.out.println(canCompleteCircuit1(gas,cost));
    }
    //暴力
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        boolean flag=true;

        for(int i=0;i<n;i++)
        {
            flag=true;
            int start=i;
            int cnt=0;
            while(true)
            {
                cnt=gas[start]-cost[start]+cnt;
                if(cnt<0)
                {
                    flag=false;
                    i=(start+1)%n;
                    break;
                }
                start=(start+1)%n;
                if(start==i) break;
            }
            if(flag) return i;
        }
        return -1;
    }

    // 优化的地方在于 因为当前位置若不满足条件 则可直接更新i=不满足条件的位置+1 因为能到达这里
    // 前面一定满足gas[i-1]-cost[i-1]>=0
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n=gas.length;
        int i=0;
        int cnt=0;
        int ans=0;
        int start=0;
        while(i<n)
        {
            cnt=0;
            ans=0;
            while(cnt<n)
            {
                start=(i+cnt)%n;
                ans=gas[start]-cost[start]+ans;
                if(ans<0) break;
                cnt++;
                if(cnt==n) return i;
            }
            i=i+cnt+1; //优化的地方
        }
        return -1;
    }
}

