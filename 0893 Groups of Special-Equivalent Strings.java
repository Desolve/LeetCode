// From siqizheng
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String a : A) {
            int l = a.length();
            char[] odd = new char[(l + 1) / 2];
            char[] even = new char[(l + 1) / 2];
            int to = 0, te = 0;
            for (int i = 0; i < a.length(); ++i) {
                if (i % 2 == 0) even[te++] = a.charAt(i);
                else odd[to++] = a.charAt(i);
            }
            Arrays.sort(odd);
            Arrays.sort(even);
            set.add(String.valueOf(odd)+String.valueOf(even));
        }
        return set.size();
    }
}

/* Special and fast solution from PanFriedBun
class Solution {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
    public int numSpecialEquivGroups(String[] A) {
        
        Map<String, Integer> groupMap= new HashMap<>();
        
        for (String s: A){
            int hashOdd = 1;
            int hashEven = 1;
            for (int i=0; i<s.length(); i++){
            //this hash function give us same number for anagram word, and this number will be unique
                if(i % 2== 0)hashEven *= prime[s.charAt(i) - 'a'];
                if(i % 2!= 0)hashOdd *= prime[s.charAt(i) - 'a'];
            }
            String hello = hashEven + "+" + hashOdd;
            //"+" sign in between in important as hashEven=222 hashOdd=2 is different from hashEven=22 hashOdd=22
                        
            groupMap.put(hello, groupMap.getOrDefault(hello, 0) + 1);
        }
        return groupMap.size();
    }

}
*/