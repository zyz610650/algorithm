package zyz.algorithm.hot.top;

import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 315. 计算右侧小于当前元素的个数
 * @seq: 315
 * @address: https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @idea:
 * 该题可以用
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 这题的思路
 */
public class T315_314 {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        Integer[] res=new Integer[n];
        int[] index=new int[n];
        for(int i=0;i<n;i++)
            index[i]=i;
        Arrays.fill(res,0);
        mergeSort(nums,res,index,0,n-1);
        return Arrays.asList(res);
    }

    public void mergeSort(int[] nums,Integer[] res,int[] index,int l,int h)
    {
        if(l>=h) return;
        int mid=l+((h-l)>>1);
        mergeSort(nums,res,index,l,mid);
        mergeSort(nums,res,index,mid+1,h);

        int[] tmp=new int[h-l+1];
        int i=l,j=mid+1;
        int k=0;
        while(i<=mid&&j<=h)
        {
            if(nums[index[i]]<=nums[index[j]])
            {
                res[index[i]]+=(j-mid-1); // 注意这点 和那题的不同之处
                tmp[k++]=index[i++];

            }else {
                tmp[k++]=index[j++];
            }
        }
        // System.out.println(Arrays.toString(res));
        while(i<=mid)
        {
            res[index[i]]+=(j-mid-1);
            tmp[k++]=index[i++];
        }
        while(j<=h)  tmp[k++]=index[j++];
        for( i=0;i<k;i++)
            index[l++]=tmp[i];
    }
}
