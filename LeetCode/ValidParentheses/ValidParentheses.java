public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c =='[' ) //careful, can NOT peek directly
            {
                st.push(c);
            }else if( c == ')')
            {
                if(!st.empty() && st.peek() == '(')
                {
                    st.pop();
                }else
                {
                    return false;
                }
            }else if( c == '}')
            {
                if(!st.empty() && st.peek() == '{')
                {
                    st.pop();
                }else
                {
                    return false;
                }
            }else if( c == ']')
            {
                if(!st.empty() && st.peek() == '[')
                {
                    st.pop();
                }else
                {
                    return false;
                }
            }else
            {
                return false;
            }
            
        }
        
        if(st.empty())
          return true;
          
        return false;
    }
}