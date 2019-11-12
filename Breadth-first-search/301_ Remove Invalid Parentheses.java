class Solution {
    //BFS
    //First try to elminate 1 char, loop through all possibilities, and put them in queue
    //also to prevent duplicate, declare another set to store individual sequence.
    //then 2 char
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(s);
        visited.add(s);
        
        int n = -1;
        boolean valid = false;
        while(!queue.isEmpty()){
            
            String s1 = queue.poll();
           
            if(isValid(s1)){
              
                result.add(s1);
                valid = true;
                n = s1.length();
            }
            if (valid == true){
                continue;
            }
            
            for (int i = 0; i < s1.length(); ++i){
                char cur = s.charAt(i);
                if (cur != '(' && cur != ')'){
                    continue;
                }   
                String temp = s1.substring(0,i) + s1.substring(i+1);
                if (visited.contains(temp)){
                    continue;
                }
                queue.add(temp);
                visited.add(temp);
            }
            
        }
        return result;
        
    }
    
    public boolean isValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); ++i){
            char cur = s.charAt(i);
            if (cur != '(' && cur != ')'){
                continue;
            }
            else if(cur == '('){
                 ++count;
            }
            else{
                --count;
            } 
            if (count < 0){
                return false;
            }
        }
        if(count != 0){
            return false;
        }
        return true;
        
    }
}