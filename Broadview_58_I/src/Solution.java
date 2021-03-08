public class Solution {
    public String reverseWords(String s){
        s = s.trim(); // 去掉首尾空格
        int j = s.length() -1, i = j;
        StringBuilder str = new StringBuilder();
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' ') // 寻找第一个单词
                i--;
            str.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') // 去掉单词间空格
                i--;
            j = i;
        }
        return str.toString().trim(); // 去掉末尾空格
    }
}
