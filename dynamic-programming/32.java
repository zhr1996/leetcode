class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> par = new Stack<Integer>();
        int left = -1;
        int max = 0;
        for(int i=0;i<=s.length()-1;i++){
            if(s.charAt(i) == '('){
                par.push(i);
            }
            else{
                if(par.isEmpty()==true){
                    left = i; 
                }
                else{
                    par.pop();
                    if(par.isEmpty()==true){
                        max = Math.max(max, i-left);
                    }
                    else{
                        max = Math.max(max, i-par.peek());
                    }
                }
            }
        }
        return max;
        
    }
}