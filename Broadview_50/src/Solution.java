import java.util.Arrays;

public class Solution {
    public static char firstUniqChar(String s){
        int map[] = new int[256];
        Arrays.fill(map,0); // 初始化为0
        char[] arr = s.toCharArray();
        for (char c: arr) {
            map[c]++;
        }
        for (char c: arr) {
            if (map[c] == 1)
                return c;
        }
        return ' ';
    }
    static public void main(String[] args){
        String s = "abaccdeff";
        char a = firstUniqChar(s);
        System.out.println(a);
    }
}
