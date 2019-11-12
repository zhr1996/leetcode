class Solution {
    //dp
    //first test if inner word is Palindrom
    //then test if outer is palindrom
    ///store left and right to retrieve the longest palindrom
    public String longestPalindrome(String s) {
        if(s.length()==1||s.length()==0)
            return s;
        boolean isPalindromic[][] = new boolean[s.length()][s.length()];
        int left = 0;
        int right = 0;
        int length = s.length();
        for(int j=1;j<=length-1;j++){
            for(int i=0;i<=j-1;i++){
                boolean isInnerwordPalindrom = isPalindromic[i+1][j-1]||j-i<=2;
                if(isInnerwordPalindrom&&s.charAt(i)==s.charAt(j)){
                    isPalindromic[i][j]=true;
                    if(j-i > right-left){
                        right = j;
                        left = i;
                    }
                }
            }
        }
        return s.substring(left,right+1);
        
    }
}