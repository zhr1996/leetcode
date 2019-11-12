class Solution {
    //Use Hashmap to count the number of occurrence
    //Can also use array to store , it's the same.
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i){
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
            map.put(B[i], map.getOrDefault(B[i],0) + 1);
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
             }
        }
        int maxValue = maxEntry.getValue();
        int key = maxEntry.getKey();
        if (maxValue < A.length / 2 ){
            return -1;
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < A.length; ++i){
            if (A[i] != key){
                if (B[i] != key){
                    return -1;
                }
                else{
                    ++count1;
                }
            }
        }
        
        for (int i = 0; i < A.length; ++i){
            if (B[i] != key){
                if (A[i] != key){
                    return -1;
                }
                else{
                    ++count2;
                }
            }
        }
        return Math.min(count1, count2);
    }
}