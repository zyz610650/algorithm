package zyz.algorithm.CharacterString.hard;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 文本左右对齐
 * @seq: 68
 * @address: https://leetcode-cn.com/problems/text-justification/
 * @idea:
 */


public class TextJustification_118 {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        System.out.println(fullJustify(words,maxWidth));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder sb;
        int start=0,end=0;
        int tlen=0;
        ArrayList<String> list=new ArrayList<>();
        for(;end<words.length;)
        {
            sb=new StringBuilder();
            start=end;
            tlen=0;
            boolean flag=false;
            boolean kflag=false;
            while(true)
            {
                tlen+=words[end++].length();
                tlen++;
                if(tlen>=maxWidth)
                {
                    if(tlen==maxWidth)
                        kflag=true;
                    tlen--;

                }
                if(tlen>maxWidth) break;
                if(end==words.length)
                {
                    flag=true;
                    break;
                }
            }

            end--;
            if (!kflag)
            tlen--;
            if(!flag)
            tlen=tlen-words[end].length();

            //总空格数
            int blank=maxWidth-tlen+(end-start-1);
            if(flag)
            {
                blank++;
                for(int j=start;j<=end;j++)
                {
                    sb.append(words[j]).append(" ");
                    blank--;
                }
                for(int t=0;t<blank;t++) sb.append(" ");
                if(blank==-1) sb.deleteCharAt(sb.length()-1);
                end++;
            }
           else{
                //每个空格数
                int num=blank/(end-start-1);
                //余数
                int q=blank%(end-start-1);
                sb=new StringBuilder();
                for(int j=start;j<end;j++)
                {
                    sb.append(words[j]);
                    if (j<end-1)
                    for(int k=0;k<num;k++) sb.append(" ");

                    if(j==start)
                        for(int k=0;k<q;k++) sb.append(" ");

                }
            }
            list.add(sb.toString());
            System.out.println(sb.toString());
        }
        return list;
    }


}
