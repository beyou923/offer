public class Solution1 {
    public String reverseLeftWords(String s, int n){
        String sub = s.substring(0,n);
        s = s.substring(n);
        return s.concat(sub);
    }
}
