public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> currLevel = new ArrayList<Integer>();
        if(rowIndex < 0)
            return currLevel;
            
        currLevel.add(1);        
        if(rowIndex == 0)
            return currLevel;
            
       ArrayList<Integer> nextLevel = new ArrayList<Integer>();
       for(int i=1; i<=rowIndex; i++)
       {
           nextLevel.clear();
           nextLevel.add(1);
           for(int j=1; j<currLevel.size();j++)
           {
               nextLevel.add(j, currLevel.get(j-1)+ currLevel.get(j));
           }
           nextLevel.add(1);
           
           currLevel.clear();
           currLevel.addAll(nextLevel);
       }
       return currLevel;
    }
}