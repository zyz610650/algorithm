package zyz.algorithm.CharacterString.medium;

import java.util.*;

/**
 * @author zyz
 * @title: 整数转罗马数字
 * @seq: 12
 * @address: https://leetcode-cn.com/problems/integer-to-roman/
 * @idea:
 */

//1994
// "MDCDXCIV"
// "MCMXCIV" 整解
public class IntegertoRoman_107 {
//MIII MMM
    public static void main(String[] args) {

        String s="IVVCD";



        System.out.println(s);

        System.out.println(intToRoman(1994));
    }

    // 用Map存 20%
    public static String intToRoman1(int num) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        int[] arr=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};

        List<String> list=new ArrayList<>();
        int t=0;
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(num>0)
        {

            t=num/arr[i];
            num=num%arr[i];
            for( int j=0;j<t;j++)
                sb.append(map.get(arr[i]));
            i++;
        }
        return sb.toString();
    }

    // 用数组存 99.97%
    public static String intToRoman(int num) {

        int[] arr={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int t=0;
        int i=0;
        String s;

        StringBuilder sb=new StringBuilder();
        while(num>0)
        {
            t=num/arr[i];
            num=num%arr[i];
            for( int j=0;j<t;j++)
                sb.append(symbols[i]);
            i++;
        }
        return sb.toString();
    }


}
