public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        for(int i=0; i<strs.length;i++)
        {
            char [] t = strs[i].toCharArray();
            Arrays.sort(t);
            String sig = new String(t);
            
            if(!m.containsKey(sig))
            {
                ArrayList<String> keys = new ArrayList<String>();
                keys.add(strs[i]);
                m.put(sig, keys);
            }else{
                if(m.get(sig).size()>0)
                {
                    m.get(sig).add(strs[i]);
                    
                }
            }
        }
       for(String key : m.keySet())
       {
           if(m.get(key).size()>1)
           {
               res.addAll(m.get(key));
           }
       }
        return res;
    }
}