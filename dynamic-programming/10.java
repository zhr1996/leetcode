class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] M = new boolean[s.length()+1][p.length()+1];
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        //a*b*
        M[0][0] = true;
        for(int k=1;k<=M[0].length-1;k++){
            if(pattern[k-1]=='*'){
                M[0][k]=M[0][k-2];
            }
        }
        for(int i=1;i<=M.length-1;i++){
            for(int j=1;j<=M[0].length-1;j++){
                if(text[i-1]==pattern[j-1]||pattern[j-1]=='.'){
                    M[i][j]=M[i-1][j-1];
                }
                else if(pattern[j-1]=='*'){
                    if(M[i][j-2]==true)
                        M[i][j] = true;
                    else if(pattern[j-2]=='.'||text[i-1]==pattern[j-2]){
                        M[i][j] = M[i-1][j];
                    }
                }
                
            }
        }
        return M[s.length()][p.length()];  
    }
}