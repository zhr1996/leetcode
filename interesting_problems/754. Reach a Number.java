class Solution {
    public int reachNumber(int target) {
        //Basically this is a not very hard math problem
        //We can first use all positive moves towards target
        //Then try to use negative steps to go back
        //But each nagative step turn back a even number of steps
        //So in order to ensure we can go back, we need the difference to be an even number
        int sum = 0;
        int i = 1;
        target = Math.abs(target);
        for (; sum < target; ++i){
            sum += i;
        }
        while ((sum - target) % 2 != 0){
            sum += i;
            ++i;
        }
        return i - 1;
    }
}