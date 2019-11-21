// "static void main" must be defined in a public class.
// Not a very hard problem, but kind of difficult to take in the rule and program 
// according to it.
// Overall a very interestin problem.
public class Main{
    public static void main(String[] args){
        String a = "abcd abc bd";
        String b = "bbb bb c";
        //System.out.println(a);
        int[] result = compare(a,b);
        for (int i = 0; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
    
    //Basically the idea is first to store the frequence in a frequence array of A
    //freq[2] for example represents how many string's frequency is less or equal to 2
    //
    public static int[] compare(String a, String b){
        String[] tempa  = a.split(" ");
        String[] tempb = b.split(" ");
        //The largest possible frequenc is 10, because the longest string is 10
        int[] freqs = new int[11]; 
        
        //result
        int[] result = new int[tempb.length];
        for (int i = 0; i < tempa.length; ++i){
            if (tempa[i].length() == 0) continue;
            int[] count = new int[26];
            int MinIdx = 26;
            for (char c : tempa[i].toCharArray()){
                count[c - 'a']++;
                MinIdx = Math.min(c - 'a', MinIdx);
            }
            freqs[count[MinIdx]]++;
        }
        //count how many string has minChar less than freqs[i]
        for(int i = 1; i < freqs.length; ++i){
            freqs[i] = freqs[i - 1] + freqs[i];
        }
        for(int i = 1; i < freqs.length; ++i){
            System.out.println(freqs[i]);
        }
        //count freq of b and see how many freqs of a is smaller than B[i]
        for (int i = 0; i < tempb.length; ++i){
            int[] count = new int[26];
            int MinIdx = 26;
            for (char c : tempb[i].toCharArray()){
                count[c - 'a']++;
                MinIdx = Math.min(c - 'a', MinIdx);
            }
            //System.out.println(MinIdx);
            result[i] = count[MinIdx] >1 ? freqs[count[MinIdx] - 1] : 0;
        }
        return result;
    }
}