class Solution {
    //backtraking is used when there are no better ways than just iterating through all possibilities
    //Basically 2^n
    //backtracking means when testing out one possibilities, then you need to go back to the previous state.
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[score.length];
        for (char letter : letters){
            count[letter - 'a'] ++;
        }
        int index = 0;
        int max = backtrack(words, count, score, index);
        return max;
    }
    public int backtrack(String[] words, int[] count, int[] score, int index){
        int max = 0;
        for (int i = index; i < words.length; ++i){
            int res = 0;
            boolean isValid = true;
            for (char ch : words[i].toCharArray()){
                count[ch - 'a']--;
                res += score[ch - 'a'];
            }
            for (char ch : words[i].toCharArray()) {
                if (count[ch - 'a'] < 0) isValid = false;
            }
            if (isValid) {
                res += backtrack(words, count, score, i + 1);
                max = Math.max(res, max);
            }
            
            //backtracking
            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']++;
                res = 0;
            }
        }
        return max;
        
        
        
        
    }
    
}