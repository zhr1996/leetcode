//A very interesting problem, easily thought to be too comlicated
//Find a continuous subarray with length K, which is largest accoriding to the criteria given by the problem.
//Since A and B have the same length, and the integers are unique
//So only need to compare the first digit and see which is a larger array.

//Pretty interesting question, not hard to solve, but really require some thinking and some technique
public class Main{
    public static void main(String[] args){
        String time = "?6:4?";
        String result = maxtime(time);
        System.out.println(result);
    }
    public static String maxtime(String time){
         char[] timeArray = time.toCharArray();
        
        if (timeArray[0] == '?'){
            //23:59, 14:23
            timeArray[0] = (timeArray[1] == '?' || timeArray[1] <= '3') ? '2' : '1'; 
        }
        
        if (timeArray[1] == '?'){
            timeArray[1] = (timeArray[0] == '2') ? '3' : '9';
        }
        
        if (timeArray[3] == '?'){
            timeArray[3] = '5';
        }
        
        if (timeArray[4] == '?'){
            timeArray[4] = '9';
        }
        String result = String.valueOf(timeArray);
        return result;
    }
    
}