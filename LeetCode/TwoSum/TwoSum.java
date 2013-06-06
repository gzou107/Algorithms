public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0; i<numbers.length; i++)
        {
            if(m.containsKey(numbers[i]))
            {
                m.get(numbers[i]).add(i);
            }else{
                ArrayList<Integer> pos = new ArrayList<Integer>();
                pos.add(i);
                m.put(numbers[i], pos);
            }
        }
        
        int [] res={-1, -1};
        Arrays.sort(numbers);
        int h = 0;
        int t = numbers.length -1;
        while(h < t)
        {
            int sum = numbers[h] + numbers[t];
            
            if(sum == target)
            {
                if(m.get(numbers[h]).size() > 1)
                {
                    res[0] = m.get(numbers[h]).get(0) + 1;
                    res[1] = m.get(numbers[h]).get(1) + 1;
                }else{
                    int i1 = m.get(numbers[h]).get(0) + 1;
                    int i2 = m.get(numbers[t]).get(0) + 1;
                    if(i1 < i2)
                    {
                        res[0] = i1;
                        res[1] = i2;
                    }else
                    {
                        res[0] = i2;
                        res[1] = i1;
                    }
                }
                return res;
                //break;
            }else if(sum <target)
            {
                h++;
            }else
            {
                t--;
            }
        }
        
        return res;
    }
}