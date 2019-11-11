class Solution {
    public boolean isHappy(int n) {
        // How to test an infinity loop
        // Use hashset
        Set<Integer> set = new HashSet<>();
        int original = n;
        int squareSum = 0;
        int count = 0;
        while(original != 1){
            squareSum = 0;
            n = original;
            while (n != 0){
                squareSum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (squareSum == original || set.contains(squareSum)){
                return false;
            }
            else{
                set.add(squareSum);
                original = squareSum;
                //System.out.println(original);
            }
        }
        return true;
    }
}