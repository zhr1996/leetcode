class Solution {
    public int numDecodings(String s) {
        int[] result = new int[s.length()];
        if(s.charAt(0) == '0'){
            return 0;
        }
        result[0] = s.charAt(0) == '0' ?  0 :  1;
        for(int i = 1; i <= s.length()-1; i++){
            if(s.charAt(i) - '0' >= 1 && s.charAt(i) - '0' <= 9){
                result[i] = result[i-1];
            }
            if(Integer.parseInt(s.substring(i-1,i+1)) <= 26 && (Integer.parseInt(s.substring(i-1,i+1)) >= 10)){
             if(i != 1){
                result[i] += result[i-2] ;
             }
             else{
                 result[i] += 1;
             }
            }
            
        
        }
        return result[s.length()-1];
    }
}