public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we need a  blacklist to keep track of the number we have processed
        // we keep a map to remember the lower bound and upper bound for num can reach
        // we do not check the same number again --> O(n)
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
        HashSet<Integer> l = new HashSet<Integer>();
        
        int res = 0;
        int opt = 0;
        
        for(int i=0; i<num.length; i++)
        {
            if(l.contains(num[i]))
            {
                continue;
            }else
            {
                l.add(num[i]);
                ArrayList<Integer> bound = new ArrayList<Integer>();
                bound.add(num[i]);
                bound.add(num[i]);
                m.put(num[i], bound);
                
                //find the lower bound we can get
                int up = num[i] + 1;
                if(l.contains(up))
                {
                    int j=up;
                    for( ;j!=getUpper(j, m); )
                    {
                        j=getUpper(j, m);
                    }
                    bound.set(1, j);
                    m.get(j).set(0, num[i]); 
                }else
                {
                    bound.set(1, num[i]);
                }
                
                int lo = num[i] -1;
                if(l.contains(lo))
                {
                    int j = lo;
                    for(;j!=getLower(j, m); )
                    {
                        j=getLower(j, m);
                    }
                    bound.set(0,j);
                    m.get(j).set(1, num[i]);
                }else
                {
                    bound.set(0, num[i]);
                }
                
                res = bound.get(1) - bound.get(0) + 1;
                if(res > opt)
                {
                    opt = res;
                }
            }
            
        }
        return opt;
    }
    
    private int getUpper(int i, HashMap<Integer, ArrayList<Integer>> m)
    {
        if(m.containsKey(i))
          return m.get(i).get(1);
        else
         return i;
    }
    
    
    private int getLower(int i, HashMap<Integer, ArrayList<Integer>> m)
    {
        if(m.containsKey(i))
          return m.get(i).get(0);
        else
          return i;
    }
}