package zyz.algorithm.type.CharacterString.easy;

/**
 * @author zyz
 * @title: Excel表列名称
 * @seq: 168
 * @address: https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @idea:
 * 进制转换 平常的进制转换都是从0开始，这个从1开始 所以先--
 * 10进制转26进制
 */
public class ExcelSheetColumnTitle_131 {
    public static void main(String[] args) {

        System.out.println(convertToTitle(52));
    }
    public static  String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0)
        {
            columnNumber--;
            sb.append((char)((columnNumber)%26+'A'));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}

