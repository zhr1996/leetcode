class Solution {
    public int longestStrChain(String[] words) {
        //Store every longest chain lengh in a hashmap
        //start from the shortes word, gradually build up the longest word
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int res = 0;
        for(String word : words){
            if(dp.containsKey(word)){
                continue;
            }
            dp.put(word, 1);
           
            for(int i = 0; i <= word.length() - 1; ++i){
                String prev = word.substring(0, i) + word.substring(i + 1);
                if(dp.containsKey(prev) && dp.get(prev) + 1 > dp.get(word)){
                    dp.put(word, dp.get(prev) + 1);
                }
            }
            if(dp.get(word) > res){
                res = dp.get(word);
            }
        }
        return res;
        
    }
}