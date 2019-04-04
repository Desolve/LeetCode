class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num: A) sum += num;
        if (sum % 3 != 0) return false;
        int part = sum / 3;
        int i = 0, s = 0;
        for (i = 0; i < A.length - 1; ++i) {
            s += A[i];
            if (s == part) break;
        }
        if (s != part) return false;
        s = 0;
        int j = 0;
        for (j = A.length - 1; j > i; --j) {
            s += A[j];
            if (s == part) break;
        }
        
        return s == part;
    }
}

/*
// Better solution
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) sum += num;
        if (sum % 3 != 0) return false;
        int part = sum / 3;
        int s = 0, cnt = 0;
        for (int num : A) {
            s += num;
            if (s == part) {
                cnt += 1;
                if (cnt == 2) return true;
                s = 0;
            }            
        }
        return false;
    }
}
*/