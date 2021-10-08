package zyz.algorithm.CharacterString.easy;

/**
 * @author zyz
 * @title: Excel表列名称
 * @seq: 171
 * @address: https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @idea:
 *  n进制转10进制
 */
public class ExcelSheetColumnNumber_132 {

    public int titleToNumber(String columnTitle) {
        char ch;
        int n=0;
        for(int i=0;i<columnTitle.length();i++)
        {
            ch=columnTitle.charAt(i);
            n=n*26+(ch-'A'+1);
        }
        return n;
    }
}
