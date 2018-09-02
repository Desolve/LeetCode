class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int len = s.length();
    	if (len == 0) return 0;
    	int start = 0, end = 0, max = 1, sublen = 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	while (end < len) {
    		if (!map.containsKey(s.charAt(end))){
    			map.put(s.charAt(end++), 1);
    			sublen++;
    			max = Math.max(sublen, max);
    		} else { 
    			map.remove(s.charAt(start++));
    			sublen--;
    		}
    	}
    	return max;
    }
}
