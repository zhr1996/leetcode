
//Another very interesting problem.
//Not hard by itself, but again require some thought on how to deal with stirngs 
//and how to get a sorted map
//For the first problem, since string is immutable, so use StringBuilder instead,
//For the second one, use TreeMap<>() to get a map with key sorted in natural order.

public class Main{

    public static void main(String[] args){
        String[] book = {"+1A","+3E","-1A","+4F","+1A","-3E","+3C","+3C","+3C","+2B","+2B","+2B"};
        String result = maxBook(book);
        System.out.println(result);
    }
    public static String maxBook(String[] book){
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String s : book){
            if (s.charAt(0) == '+'){
                String room = s.substring(1,3);
                map.put(room, map.getOrDefault(room, 0) + 1);
            }
        }
        int max = -1;
        StringBuilder result = new StringBuilder();
        for ( Map.Entry<String, Integer> entry: map.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
                result.replace(0, result.length(), entry.getKey());
            }
        }
        return result.toString();
    }
}