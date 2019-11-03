class Solution {
   public String minRemoveToMakeValid(String s) {
       //StringBuilder is interesting
       //Basically this is not a very hard problem
       //But the tricky thing is string in java can't be changed
       //So may be using string builder is a very interesting bypass way.
      StringBuilder sb = new StringBuilder(s);
      Stack<Integer> st = new Stack<>();
      for (int i = 0; i < sb.length(); ++i) {
        if (sb.charAt(i) == '(') st.add(i);
        if (sb.charAt(i) == ')') {
          if (!st.empty()) st.pop();
          else sb.setCharAt(i, '*');
        }
      }
      while (!st.empty()) {
        sb.setCharAt(st.peek(), '*');
        st.pop();
      }
      return sb.toString().replaceAll("\\*", "");
    }
}