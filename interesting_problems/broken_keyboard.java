//input a = "Hello, my dear friend!" , b = ['h', 'e', 'l', 'o', 'm']
//output 1

public class Main {
    public static void main(String[] args) {
        String a = "hEllo##, This^^ mo";
        char[] b = {'h', 'e', 'l', 'o', 'm'};
        System.out.println(findGoodWord(a,b));
        return;
    }
    public static int findGoodWord(String s, char[] c){
        Set set = new HashSet();
        int count = 0;
        int flag = 1;
        for(Character ch : c){
            set.add(ch);
        }
        String[] words= s.split(" ");
        for(String word : words){
            flag = 1;
            for (int i = 0; i < word.length(); ++i){
                char temp = word.charAt(i);
                if(!(Character.isUpperCase(temp) || Character.isLowerCase(temp))){
                    continue;
                }
                if(!(set.contains(Character.toLowerCase(temp))||set.contains(Character.toUpperCase(temp)))){
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                ++count; 
            }

        }


        return count;
    }
}