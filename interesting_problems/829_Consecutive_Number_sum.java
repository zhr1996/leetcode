class Solution {
    //We know we can compute arithmetic sequence using a formula:
    //(a1 + an)*n/2
    //Make two points and compute the sum, if it is large, 
    //then shift the right point to left
    //If small, shift the left point to right
    //But directly use arithmetic sequence is not correct
    //it needs to be changed to ma1 + m(m-1)/2
    public int consecutiveNumbersSum(int N) {
        //because it have itself
        int m = 1;
        int count = 0;
        int mx = 0;
        for (; ; ++m){
            //This is line is interesting,
            //The problem only askes about how many
            //So don't need to list all possibilities
            mx = N - m*(m-1)/2;
            if (mx <= 0){
                break;
            }
            if (mx % m == 0){
                count++;
            }
        }
        return count;
        
    }
}