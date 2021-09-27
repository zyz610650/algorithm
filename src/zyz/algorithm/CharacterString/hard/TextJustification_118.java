package zyz.algorithm.CharacterString.hard;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 文本左右对齐
 * @seq: 68
 * @address: https://leetcode-cn.com/problems/text-justification/
 * @idea:
 */
//["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]
//["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
public class TextJustification_118 {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
                //{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 16;


        System.out.println(fullJustify(words,maxWidth));
    }

    public static List<String> fullJustify(String[] words, int maxWidth)
    {
        List<String> list=new ArrayList<>();
        StringBuilder sb;
        int left=0,right=-1;
        int len=0;
        while (right<words.length)
        {
            sb=new StringBuilder();
            right++;
            left=right;
            len=0;
            if (right==words.length) break;
            while(right<words.length&&len<maxWidth)
            {
                len+=words[right].length();
                if (len>maxWidth)
                {
                    len-=words[right].length();
                    right--;
                    break;
                }
                len++;
                right++;
            }
            if (len>=maxWidth) right--;
            int num=right-left+1;
            len-=num;

            if (right==words.length)
            {
                len++;
                right--;
                for (int t=left;t<right;t++)
                {
                    sb.append(words[t]).append(" ");
                    len++;
                }
                sb.append(words[right]);
                for (int t=0;t<maxWidth-len;t++) sb.append(" ");
                list.add(sb.toString());
                break;
            }
            int blank=0,ext_blank=0;
            if (num!=1)
            {
                blank=(maxWidth-len)/(num-1);
                ext_blank=(maxWidth-len)%(num-1);
            }else{
                blank=maxWidth-len;
            }

            for (int j=left;j<right;j++)
            {
                sb.append(words[j]);

                for(int t=0;t<blank;t++) sb.append(" ");
                if (ext_blank!=0){
                    sb.append(" ");
                    ext_blank--;
                }
            }

            sb.append(words[right]);
            if (num==1)
            {
                for(int t=0;t<blank;t++) sb.append(" ");
            }
            list.add(sb.toString());

        }
        return list;
    }




}
