class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len <= 1)
            return a;
        int[] mulPre = new int[len];
        int[] mutSuf = new int[len];
        int[] b = new int[len];
        // 计算前缀乘积
        for (int i = 0; i < len; i++){
            if (i == 0)
                mulPre[i] = a[i];
            else
                mulPre[i] = mulPre[i - 1] * a[i];
        }
        // 计算后缀乘积
        for (int i = len - 1; i >= 0; i--){
            if (i == len - 1)
                mutSuf[i] = a[i];
            else
                mutSuf[i] = a[i] * mutSuf[i + 1];
        }
        // 填充b
        for (int i = 0; i < len; i++)
            if (i == 0)
                b[i] = mutSuf[i + 1];
            else if (i == len - 1)
                b[i] = mulPre[i - 1];
            else
                b[i] = mulPre[i - 1] * mutSuf[i + 1];
        return b;
    }
}