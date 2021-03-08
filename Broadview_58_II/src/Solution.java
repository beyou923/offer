public class Solution {
    public String reverseLeftWords(String s, int n){
        int len = s.length();
        if (len < 1) return "";
        StringBuilder str = new StringBuilder();
        for (int i = n; i < len; i++)
            str.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            str.append(s.charAt(i));
        return str.toString();
    }
}
