class Solution {
    public int numTrees(int n) {
        if(n<2){
            return 1;
        }
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        G[2] = 2;
        int temp = 0;
        for(int number = 3; number<=n;number++){
            for(int i=1;i<=number;i++){
                temp = temp + G[i-1]*G[number-i];
            }
            G[number] = temp;
            temp = 0;
        }
        return G[n];
    }
}