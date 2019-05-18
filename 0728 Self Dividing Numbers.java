class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDivided(i)) res.add(i);
        }
        return res;
    }
    public boolean isSelfDivided(int num) {
        int pos = num;
        boolean[] digits = new boolean[10];
        while (pos != 0) {
            digits[pos % 10] = true;
            pos /= 10;
        }
        if (digits[0] == true) return false;
        for (int i = 1; i <= 9; ++i) {
            if (digits[i] == true && num % i != 0) return false;
        }
        return true;
    }
}

/* Slightly faster
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
     
        List<Integer> ans = new ArrayList<Integer>();

        for(int i=left; i<=right ; i++){
            if(isSelfDividingNumber(i))
                ans.add(i);
        }
        return ans;
    }
    
    
    public boolean isSelfDividingNumber(int n){
        int original = n;
        while(n>0){
            int r = n%10;
            if(r == 0)            return false;
            if(original%r !=0)   return false;
            n /= 10;
        }
        return true;
    }
    
}
*/