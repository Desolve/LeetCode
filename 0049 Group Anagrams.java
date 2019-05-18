class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}
/* Inspired from mz888, just add 2 for the dict and delete 103 since 2 is a prime, too.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create an array of the first 26 prime numbers. This will be used to calculate a unique "value" for each string
        // where only anagrams have the same value.
        int[] dict = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int value = 1;
            for (char c: str.toCharArray()) {
                value *= dict[(c - 'a')];     // we multiply the value by each the prime number associated with that letter
                                              // this way the only way we can get two same values is if
                                              // they had the same letters (prime factorization)
                                              // Should work even with wraparound
            }
            // add word to hashmap. map.get(value) will return a List of all anagrams to the current word
            // due to the manner in which value was calculated
            if (map.get(value) == null) {
                map.put(value, new ArrayList<String>());
            }
            map.get(value).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
*/


/* Actually not faster than sorting first
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = getHash(str);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        
        return new ArrayList<>(map.values());
    }
    public String getHash(String str) {
        int[] chs = new int[26];
        for (char c : str.toCharArray()) chs[c - 'a']++;
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 25; i++) st.append(chs[i]).append(",");
        st.append(chs[25]);
        return new String(st);
    }
}
*/