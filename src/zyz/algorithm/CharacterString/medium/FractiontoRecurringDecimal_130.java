package zyz.algorithm.CharacterString.medium;

/**
 * @author zyz
 * @title: 分数到小数
 * @seq: 166
 * @address: https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 * @idea:
 */
public class FractiontoRecurringDecimal_130 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,6));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator%denominator==0) return numerator/denominator+"";
        double ans=numerator*1.0/denominator;
        String n="";
        String str=ans+"";
        String[] split=str.split("\\.");
        String tmp = "";
        if(str.length()>15)
        {
            int j=1;
            while(split[1].charAt(j)!=split[1].charAt(0)) j++;
            tmp=split[1].substring(0,j);
            n=split[0]+".("+tmp+")";
        }else{
            n=str;
        }
        return n;

    }
}
