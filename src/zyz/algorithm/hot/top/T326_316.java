package zyz.algorithm.hot.top;


/**
 * @author zyz
 * @title: 326. 3 的幂
 * @seq: 326
 * @address: https://leetcode-cn.com/problems/power-of-three/
 * @idea:
 */
public class T326_316 {

    public boolean isPowerOfThree(int n) {
        int i=0,h=n/3;
        while(i<=h)
        {
            int mid=i+((h-i)>>1);
            long res=(long)Math.pow(3,mid);
            if(res==n)
            {
                return true;
            }else if(res>n)
            {
                h=mid-1;
            }else{
                i=mid+1;
            }
        }
        return false;
    }

    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
