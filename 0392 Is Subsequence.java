class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int pre = 0;
        for (int i = 0; i < s.length(); ++i, ++pre) {
            char si = s.charAt(i);
            pre = t.indexOf(si, pre);
            if (pre == -1) return false;
        }
        return true;
    }
}

/* Binary Search solution from shuoshankou
class Solution {
    //Follow up: Binary search for multiple coming string
    public boolean isSubsequence(String s, String t) {
        //O(t.length())
        Map<Character, List<Integer>> myMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!myMap.containsKey(t.charAt(i))) {
                myMap.put(t.charAt(i), new ArrayList<Integer>());
            }
            myMap.get(t.charAt(i)).add(i);
        }
        
        //search: O(s.length() * log(t.length()))
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);

            int nextIndex = getNextIndex(myMap.get(ch), index);
            if (nextIndex < 0) return false;
            index = nextIndex;
        }        
        return true;
    }
    
    public int getNextIndex(List<Integer> list, int index) {
        if (list == null) return -1;
        int left = 0, right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= index) left = mid + 1;
            else right = mid;
        }
        
        return list.get(left) > index ? list.get(left) : -1;        
    }
}
*/