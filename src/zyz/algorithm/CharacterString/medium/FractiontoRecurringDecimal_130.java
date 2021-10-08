package zyz.algorithm.CharacterString.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 分数到小数
 * @seq: 166
 * @address: https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 * @idea:
 */
public class FractiontoRecurringDecimal_130 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-2147483648,-1));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        long a=numerator,b=denominator;
        if(a%b==0) return String.valueOf(a/b);

        StringBuilder sb=new StringBuilder();
        if((a*b)<0) sb.append("-");
        a=Math.abs(a);
        b=Math.abs(b);
        sb.append(a/b);
        a%=b;
        Map<Long,Integer> map = null;

        if(a!=0)
        {
            map=new HashMap<>();
            sb.append(".");

        }

        while(a!=0)
        {
            map.put(a,sb.length());
            a*=10;
            sb.append(a/b);
            a%=b;
            if(map.containsKey(a))
            {
                int index=map.get(a);
                return String.format("%s(%s)", sb.substring(0, index), sb.substring(index));

            }
        }
        return sb.toString();

    }
}
