public class Solution {
    public int sumNums(int n){
        int sum = 0;
        boolean flag = n > 0 && (sum += n + sumNums(n - 1)) > 0;
        return sum;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.sumNums(9 ));
    }
}
