public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
            
        String str = s.toLowerCase();
        int h = 0;
        int t = str.length()-1;
        
        while(h<t)
        {
            while((h<t) && !(charIsAlpha(str.charAt(h))))
            {
                h++;
            }
            
            while((h<t) && !(charIsAlpha(str.charAt(t))))
            {
                t--;
            }
            if(h==t)
            {
                return true;
            }else if(str.charAt(h) != str.charAt(t))
            {
                return false;
            }else
            {
                h++;
                t--;
            }
        }
        
        return true;
    }
    
    private boolean charIsAlpha(char c)
    {
        return (c >= 'a' && c<= 'z') || (c >= '0' && c <= '9');
    }
}