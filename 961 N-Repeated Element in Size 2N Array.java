class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (set.contains(i)) return i;
            else set.add(i);
        }
        return -1;
    }
}
/* Using HashMap
class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            int cnt = map.getOrDefault(i, 0);
            if (cnt == 1) return i;
            else map.put(i, 1);
        }
        return -1;
    }
} */

/* Using int[] to do hash
class Solution {
    public int repeatedNTimes(int[] A) {
        int[] cnt = new int[10000];
        
        for (int i : A) {
            if (cnt[i] == 1) return i;
            else cnt[i]++;
        }
        return -1;
    }
}
*/

/* Using boolean[], but slower than int[]
class Solution {
    public int repeatedNTimes(int[] A) {
        boolean[] exist = new boolean[10000];
        
        for (int i : A) {
            if (exist[i]) return i;
            else exist[i] = true;
        }
        return -1;
    }
}
*/
/* solution from @awice

Intuition and Algorithm

If we ever find a repeated element, it must be the answer. Let's call this answer the major element.

Consider all subarrays of length 4. There must be a major element in at least one such subarray.

This is because either:

There is a major element in a length 2 subarray, or;
Every length 2 subarray has exactly 1 major element, which means that a length 4 subarray that begins at a major element will have 2 major elements.
Thus, we only have to compare elements with their neighbors that are distance 1, 2, or 3 away.

class Solution {
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }
}
*/