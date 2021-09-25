package zyz.algorithm.CharacterString.easy;

/**
 * @author zyz
 * @title: 最后一个单词的长度
 * @seq: 58
 * @address: https://leetcode-cn.com/problems/length-of-last-word/
 * @idea:
 */
public class LengthofLastWord_115 {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}
