package zyz.algorithm.hot.top;

import java.util.*;

/**
 * @author zyz
 * @title: 380. O(1) 时间插入、删除和获取随机元素
 * @seq: 380
 * @address: https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * @idea:
 */
public class T380_324 {
    class RandomizedSet {
        Map<Integer,Integer> map;
        List<Integer> list;
        Random ran;
        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList<>();
            ran=new Random();

        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val,list.size());
            list.add(list.size(),val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int key = list.get(list.size()-1);
            int index=map.get(val);
            list.set(index,key);
            map.put(key,index);
            map.remove(val);
            list.remove(list.size()-1);

            return true;
        }

        public int getRandom() {
            return list.get(ran.nextInt(list.size()));

        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
