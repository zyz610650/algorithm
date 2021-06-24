package zyz.algorithm.array.medium;

import java.util.*;

/**
 * @author zyz
 * @date
 * @title: 四数之和
 * @seq: 04
 * @address: https://leetcode-cn.com/problems/4sum/
 * @idea:  该题的解决思路就是三数之和上套了一层循环,目的时把时间复杂度从O(n^4) 讲到O(n^3)
 *  这里fourSum1 做了对于O(n^2)方法的思考，Process 1：先算出所有两个数的和2sum，存放到数组里，然后以两数之和的思路来查找
 *  c+d+2sum=target这里的关键问题是需要额外开一个数组取存储上面两数之和的下标，这样在Process 2 就不会出现重复的问题
 *  目前对于O(n^2)的fourSum1 的问题是c和d可能和得到2sum的a，b重复，还得加个数组判重 实现到这里就没有在往下实现了，只是做个引申思考
 *
 *  对于成功的版本fourSum 摘自网上的一段代码 答题思路就是三数之和+一层For循环，但这里用到的剪枝思想比较好
 */
public class fourSum_04 {
    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(nums, target).toString());
    }
    public static List<List<Integer>> fourSum(int[] nums,int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    break;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

//    作者：you-wei-wu
//    链接：https://leetcode-cn.com/problems/4sum/solution/ji-bai-9994de-yong-hu-you-dai-ma-you-zhu-shi-by-yo/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * O(n^2)方法的思考
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {

        //Process 1：
        List<List<Integer>> lists=new ArrayList<>();
        List<List<Integer>> list ;
        Map<Integer,List<List<Integer>>> map=new HashMap<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++)
        {
            if (i!=0&&nums[i-1]==nums[i]&&i<nums.length) i++;
            for (int j=i+1;j<nums.length;j++)
            {
                if (j!=i+1&&nums[j-1]==nums[j]&&j<nums.length) j++;
                list=map.get(nums[i]+nums[j]);
                if (list==null) list=new ArrayList<>();
                list.add(Arrays.asList(nums[i],nums[j]));
                map.put(nums[i]+nums[j],list);
            }
        }
//Process 2：
        for (Integer n:map.keySet()) {
            int i=0,j=0;
            while (i<j)
            {
                if (nums[i]+nums[j]+n<target)
                {
                        j--;
                }else if (nums[i]+nums[j]+n>target)
                {
                    i++;
                }else{
                   list=map.get(nums[i]+nums[j]);
                   for (int k=0;k<list.size();k++)
                   {
                       lists.add(Arrays.asList(list.get(k).get(0),list.get(k).get(1),nums[i],nums[j]));
                       while (nums[i]==nums[i+1]) i++;
                       while (nums[j]==nums[j+1]) j--;
                   }
                }
                i++;j--;
            }
        }
        return lists;
    }
}
