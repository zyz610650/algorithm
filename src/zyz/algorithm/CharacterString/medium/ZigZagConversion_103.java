package zyz.algorithm.CharacterString.medium;

import zyz.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: Z 字形变换
 * @seq: 6
 * @address: https://leetcode-cn.com/problems/zigzag-conversion/
 * @idea:
 */
public class ZigZagConversion_103 {

    // 这个题的难点在于遍历字符串s时,需要将字符串按照之字形的顺序存储，存储后，有需要按行输出
    // 我之前一直想的是用List或这二维数组存储，造成很大的空间浪费
    //官方题解采用提前创建好每行的StringBuilder，往里面存
    public static void main(String[] args) {
        String s="ABC";
                //"PAYPALISHIRING";
                //"PAYPALISHIRING";
        int num=2;
        System.out.println(convert(s,num));
        System.out.println(convert1(s,num));
    }
    //用二维数组
    public static String convert1(String s, int numRows) {

        if (numRows==1) return s;
        int len=s.length();
        char [][] map=new char[numRows][len/numRows+20];

        int i=0;
        int col=0;
        int row=0;
        while(i<s.length())
        {
            while(row<numRows&&i<len)
            {
                map[row++][col]=s.charAt(i++);
            }
            row--;
            while(row>1&&i<len)
            {
                col++;
                row--;
                map[row][col]=s.charAt(i++);
            }
            col++;
            row--;
        }
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<numRows;k++)
        {
            for (int j=0;j<=col;j++)
            {
                if (map[k][j]!='\0')
                    sb.append(map[k][j]);
            }
        }
        System.out.println(sb.toString());
        Utils.print2Arr(map);
        return null;

    }
    //用List存
    public static String convert2(String s, int numRows) {

        if (numRows==1) return s;
        int len=s.length();
        List<List<Character>> lists=new ArrayList<>();

        int i=0;
        int col=0;
        int row=0;
        List<Character> list=null;
        int t=1;
        while(i<s.length())
        {
            list=new ArrayList<>();
            row=0;
            while(row<numRows&&i<len)
            {
                row++;
                list.add(s.charAt(i++));
            }
            lists.add(list);
            t=1;
            while (t<=numRows-2&&i<s.length())
            {
                row=numRows-1;
                list=new ArrayList<>();
                while(row>-1)
                {
                    if (row==t)
                        list.add(s.charAt(i++));
                    else
                        list.add('\0');
                    row--;
                }
                t++;
                lists.add(list);
            }

        }
        StringBuilder sb=new StringBuilder();
       for(int x=0;x<numRows;x++)
       {
           for (int j=0;j<lists.size();j++)
           {
               if (x>=lists.get(j).size()) break;
               char ch=lists.get(j).get(x);
               if (ch!='\0') sb.append(ch);
           }
       }
        System.out.println(sb.toString());

        return sb.toString();

    }

    //改进 自己的实现太过荣誉了 看下面官方的
    public static String convert3(String s, int numRows)
    {
        if (numRows==1) return s;
        List<StringBuilder> list=new ArrayList<>();
        for (int i=0;i<numRows;i++)
            list.add(new StringBuilder());
        int cnt=0;
        int t=numRows-1;
        char[] ch=s.toCharArray();
        for (int i=0;i<ch.length;)
        {
            if(cnt<numRows)
            {
                list.get(cnt++).append(ch[i]);
                i++;
                if(cnt==numRows)  t=1;

                continue;
            }

            if (t<=numRows-2)
            {
                list.get(numRows-t-1).append(ch[i]);
                i++;
                t++;
            }
            if (t==numRows-1)
            {
                cnt=0;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<list.size();i++)
        {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static String convert(String s, int numRows)
    {
        if (numRows==1) return s;
        List<StringBuilder> list=new ArrayList<>();
        for (int i=0;i<numRows;i++)
            list.add(new StringBuilder());
        boolean goDown=false;
        int cnt=0;
        for(char ch:s.toCharArray())
        {
            list.get(cnt).append(ch);
            if(cnt==0||cnt==numRows-1) goDown=!goDown;
            cnt+=goDown?1:-1;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<list.size();i++)
        {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
