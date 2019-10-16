class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //从下到上
        int n = triangle.size();
        int[] array = new int[n];
        
        for(int i = 0;i <= n - 1;i++){
            array[i] = triangle.get(n - 1).get(i);
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                array[j] = Math.min(array[j], array[j+1]) + triangle.get(i).get(j);
            }
        }
        
        return array[0];
    }
}