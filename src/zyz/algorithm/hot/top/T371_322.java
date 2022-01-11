package zyz.algorithm.hot.top;


/**
 * @author zyz
 * @title: 371. 两整数之和
 * @seq: 371
 * @address: https://leetcode-cn.com/problems/sum-of-two-integers/
 * @idea:
 */
public class T371_322 {
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int tmp=(a&b)<<1;
            a=a^b;
            b=tmp;
        }
        return a;
    }
}
//https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/472018/