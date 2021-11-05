package zyz.algorithm.type.sort;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 堆排序
 * @seq:
 * @address:
 * @idea:
 * 时间复杂度：O(nlogn)，建堆的时间代价是 O(n)，删除的总代价是 O(klogn)，因为 k<n，故渐进时间复杂为 O(n+klogn)=O(nlogn)。
 * 堆的插入、删除元素的时间复杂度都是O(log n)； 因此堆排序的时间复杂度是O(nlog n)；
 * 空间复杂度：O(1)，
 *
 * 优先队列的实现常选用二叉堆，在数据结构中，优先队列一般也是指堆
 * 优先队列: Queue<Integer> integerPriorityQueue = new PriorityQueue<>();
 *

 */
public class heapSort {

    public static void main(String[] args) {
        int array[] = {73, 22, 93, 43,73, 22, 93,  55, 14, 28, 65, 39, 55, 14, 28, 65, 39,81, 33, 100};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void swap(int[] nums,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void adjustHap(int[] nums,int len,int par)
    {
        int tmp=nums[par];
        int lchild;
        for (lchild=par*2+1;lchild<len;lchild=lchild*2+1)
        {
            if (lchild+1<len&&nums[lchild]<nums[lchild+1]) lchild++;
            if (nums[lchild]>tmp)
            {
                nums[par]=nums[lchild];
                par=lchild;
            }else break;

        }
        nums[par]=tmp;

    }
    static void sort(int[] nums) {

        int len=nums.length;
        //构建大顶堆
        for (int i=(len-2)/2;i>=0;i--)
            adjustHap(nums,len,i);

        for (int i=len-1;i>=1;i--)
        {
            swap(nums,0,i);
            System.out.println(Arrays.toString(nums));
            adjustHap(nums,i,0);
        }
    }

    // 大顶堆正确写法 我这个写的不够简洁 太罗嗦
    public static void adjustHap2(int[] nums,int len,int par)
    {
        int lchild=par*2+1,rchild=par*2+2,tmp;
        while (par<len)
        {
            lchild=par*2+1;
            rchild=par*2+2;
            if (lchild>=len) break;
            if(rchild>=len)
            {
                if (nums[par]<nums[lchild]) swap(nums,par,lchild);
                break;
            }
            if (nums[lchild]>nums[rchild]) tmp=lchild;
            else tmp=rchild;
            if (nums[par]<nums[tmp])
            {
                swap(nums,par,tmp);
                par=tmp;
            }else break;
        }
    }

    static void sort2(int[] nums) {

        int len=nums.length;
        //构建大顶堆
        for (int i=(len-2)/2;i>=0;i--)
            adjustHap(nums,len,i);

        for (int i=len-1;i>=1;i--)
        {
            swap(nums,0,i);
            System.out.println(Arrays.toString(nums));
            adjustHap(nums,i,0);
        }
    }

    // 这样构造的不是大顶堆,虽然能正确排序,但是时间复杂度很高，
    //这样写只能保证每次到达堆订的是最大的，但是其余层并不符合大顶堆的要求 比如第i层，第i层经过adjustHeap调整好后，只能保证
    //这个第i层当前节点为最大,但是当第i-1层的值比最后一层的节点还小时就会破坏大顶堆的结构
    // 应该采取自顶向下
    public static void adjustHap1(int[] nums,int len)
    {
        int cnt=len-1;
        int left,right,tmp;
        while(cnt!=-1)
        {
            left=cnt*2+1;
            right=cnt*2+2;
            if (left>=len)
            {
                cnt--; continue;
            }
            if(right>=len)
            {
                if (nums[left]>nums[cnt]) swap(nums,left,cnt);
                cnt--;
                continue;
            }
            if (nums[left]>nums[right]) tmp=left;
            else tmp=right;
            if (nums[cnt]<nums[tmp]) swap(nums,cnt,tmp);
            cnt--;
            System.out.println(Arrays.toString(nums));
        }
    }

    static void sort1(int[] nums)
    {
        for(int i=nums.length;i>0;i--)
        {
            adjustHap1(nums,i);
            swap(nums,0,i-1);
        }
        System.out.println(Arrays.toString(nums));

    }
}
