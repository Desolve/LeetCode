// Use a 200001-length table to record candies' counts
class Solution {
    public int distributeCandies(int[] candies) {
        int[] hashtable = new int[200001];
        int kind = 0;
        for (int i: candies) 
            if(++hashtable[i + 100000] == 1) 
                ++kind;
        return kind <= candies.length / 2 ? kind : candies.length / 2;
    }
}