class Solution {
    //override string comparision method
    //An interesting problem
    //So override the compare function, then pass it as a parameter to Arrays.sort()
    //Interesting thing is this is purely treated as a sorting problem
    ///only need to define in which condition first stirng is smaller or second string is smaller.
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int s1si = s1.indexOf(" ");
                int s2si = s2.indexOf(" ");
                if (s1.charAt(s1si + 1) <= '9'){
                    if (s2.charAt(s2si + 1) <= '9') return 0; //tie
                    else return 1;
                }
                if (s2.charAt(s2si + 1) <= '9') return -1;
                int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
                if (preCompute < 0){
                    return -1;
                }
                else if (preCompute >0){
                    return 1;
                }
                else{
                    return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                }
            }
        };
    
        Arrays.sort(logs, myComp);
        return logs;
    }
}