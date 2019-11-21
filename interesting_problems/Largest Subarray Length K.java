//A very interesting problem, easily thought to be too comlicated
//Find a continuous subarray with length K, which is largest accoriding to the criteria given by the problem.
//Since A and B have the same length, and the integers are unique
//So only need to compare the first digit and see which is a larger array.

public class Main{
    public static void main(String[] args){
        int[] A = {1, 4, 3, 2, 5, 7, 9, 19,11};
        int[] result = findBiggestSubarray(A, 4);
        for (int i = 0; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
    public static int[] findBiggestSubarray(int[] A, int K){
        int index = -1;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - K + 1; ++i){
            if (A[i] > maximum){
                maximum = A[i];
                index = i;
            }
        }
        int[] result = new int[K];
        for (int i = 0; i < result.length; ++i){
            result[i] = A[index + i];
        }
        return result;
    }
}