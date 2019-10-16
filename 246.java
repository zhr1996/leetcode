class Solution {
    //主要是要想到把这个数列分成三部分
    //每个数都是在前一个数的基础上产生的
    public int nthUglyNumber(int n) {
        if(n == 0){
            return -1;
        }
        int[] result = new int[n];
        result[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for(int i = 1; i <= n - 1;i++){
            result[i] = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
            if(result[i] == result[i2] * 2){
                i2++;
            }
            if(result[i] == result[i3] * 3){
                i3++;
            }
            if(result[i] == result[i5] * 5){
                i5++;
            }
        }
        return result[n-1];
    }
}