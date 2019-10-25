class Solution {
   public String smallestGoodBase(String n) {
    long num = Long.valueOf(n);
        
    for (int m = (int)(Math.log(num + 1) / Math.log(2)); m > 2; m--) {
        long l = (long)(Math.pow(num + 1, 1.0 / m));
        long r = (long)(Math.pow(num, 1.0 / (m - 1)));
        	
        while (l <= r) {
            long k = l + ((r - l) >> 1);
            long f = 0L;
            for (int i = 0; i < m; i++, f = f * k + 1);
        		
            if (num == f) {
        	    return String.valueOf(k);
            } else if (num < f) {
        	    r = k - 1;
            } else {
        	    l = k + 1;
            }
        }
    }
        
    return String.valueOf(num - 1);
    }
}