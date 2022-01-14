package zyz.algorithm.hot.top;

import java.util.HashMap;
import java.util.Map;

public class T387_326 {
    public int firstUniqChar(String s) {

        char[] chs=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>(26);

        for(int i=0;i<s.length();i++)
        {
            int t=map.getOrDefault(chs[i],0)+1;
            map.put(chs[i],t);
        }
        for(int i=0;i<s.length();i++)
        {
            int t=map.get(chs[i]);
            if(t==1) return i;
        }
        return -1;

    }
}
