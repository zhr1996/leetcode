/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    //Rand 7 -> Rand 49
    //think of it has a 2d array
    //Rand 49 -> Rnad 40
    //Rejection Sampling if rand49 > 40, simply reject
    //Rand 40 -> Rand 10
    public int rand10() {
        int rand49 = rand7() + 7 * (rand7() - 1);
        if (rand49 <= 40){
            return rand49%10 + 1;
        }
        return rand10();
    }
}