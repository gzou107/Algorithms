public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //first find the min length of all the strings and then do a check
        if(strs.length == 0)
            return "";
            
        /*int min = strs[0].length();
        for(int i=1; i<strs.length; i++)
        {
            if(min > strs[i].length())
               min = strs[i].length();
        }*/
        
        int s=0;
        boolean isCommon = true;
        while(s < strs[0].length() && isCommon)
        {
            char c = strs[0].charAt(s);
            int i=0;
            for( i=1; i< strs.length ; i++)
            {
                if(s >= strs[i].length() || c != strs[i].charAt(s))
                {
                    isCommon = false;
                    break;
                }
            }
            if(isCommon)
              s++;
        }
        
        return strs[0].substring(0, s);
    }
}