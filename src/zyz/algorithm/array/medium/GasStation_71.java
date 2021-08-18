package zyz.algorithm.array.medium;

/**
 * @author zyz
 * @title: 加油站
 * @seq: 134
 * @address: https://leetcode-cn.com/problems/gas-station/
 * @idea:
 */
public class GasStation_71 {

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
}
