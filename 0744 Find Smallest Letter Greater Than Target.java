class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int cnt = 1;
        char prev = letters[0];
        for (char ch : letters) {
            if (ch != prev) {
                letters[cnt++] = ch;
                prev = ch;
            }
        }
        int index = Arrays.binarySearch(letters, 0, cnt, target);
        if (index >= 0) {
            return index == cnt - 1 ? letters[0] : letters[index+1];
        } else {
            index = -index - 1;
            if (index == 0 || index == cnt) return letters[0];
            else return letters[index];
        }
    }
}

/* Better solution, no need to do set.
class Solution {
    public char nextGreatestLetter(char[] a, char x) {
        int n = a.length;

        //hi starts at 'n' rather than the usual 'n - 1'. 
        //It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1', 
        //we can never consider value at index 'n - 1'
        int lo = 0, hi = n;

        //Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x)     hi = mid;
            else    lo = mid + 1;                 //a[mid] <= x
        }
 
        //Because lo can end up pointing to index 'n', in which case we return the first element
        return a[lo % n];
    }
}
*/