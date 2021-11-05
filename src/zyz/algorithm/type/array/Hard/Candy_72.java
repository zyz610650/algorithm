package zyz.algorithm.type.array.Hard;

/**
 * @author zyz
 * @title: 分发糖果
 * @seq: 135
 * @address: https://leetcode-cn.com/problems/candy/
 * @idea:
 */
public class Candy_72 {

    public static void main(String[] args) {
        int[] candy={1,3,2,2,1};
         System.out.println(candy2(candy));
    }
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        int res=0;

        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1]) left[i]=left[i-1]+1;
            else left[i]=1;
        }

        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1]) right[i]=right[i+1]+1;
            else right[i]=1;

        }
        for(int i=0;i<n;i++)
        {
            res+=Math.max(left[i],right[i]);
        }
        return res;
    }

    //优化1
    public static int candy1(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n];
        int right;
        left[0]=1;
        right=1;
        int res=0;

        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1]) left[i]=left[i-1]+1;
            else left[i]=1;
        }

        for(int i=n-1;i>=0;i--)
        {
            if(i!=n-1&&ratings[i]>ratings[i+1]) right=right+1;
            else right=1;
            res+=Math.max(left[i],right);
        }

        return res;
    }

    //优化2
     public static int candy2(int[] ratings) {
            int n=ratings.length;
            int pre=1,dec=0;
            int ans=1,inc=0;
            for(int i=1;i<n;i++)
            {
                if(ratings[i]>=ratings[i-1])
                {
                    dec=0;
                    pre=ratings[i-1]==ratings[i]?1:pre+1;
                    ans+=pre;
                    inc=pre;
                }else{

                    dec++;
                    if (dec==inc) dec++;
                    ans+=dec;
                    pre=1;
                }
            }

            return ans;
        }


}
