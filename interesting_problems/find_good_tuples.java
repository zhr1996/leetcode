// Give an array and find the count of a pair number and a single number combination in a row of this array. Target array is a[i - 1], a, a[i + 1]
// Example：
// Input: a = [1, 1, 2, 1, 5, 3, 2, 3]
// Output: 3
// Explain:
// [1, 1, 2] -> two 1 and one 2(O)
// [1, 2, 1] -> two 1 and one 2(O)
// [2, 1, 5] -> one 2, one 1 and one five(X)
// [1, 5, 3] -> (X)
// [5, 3, 2] -> (X)
// [3, 2, 3] -> (O)

public class Main{
    public static void main(String[] args){

    }
    public int goodTuples(int[] arr){
        for (int i  = 1; i <= arr.length - 2; ++i){
            Map<Integer, Integer> map = new HashMap<>();
            if (map.containsKey(arr[i])){
                map.
            }
        }

    }
}
