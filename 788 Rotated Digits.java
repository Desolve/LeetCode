class Solution {
    public int rotatedDigits(int N) {
        // dynamic programming: 0 -> invalid, 1 -> valid but not good, 2 -> good
        int[] dp = new int[N + 1];
        int cnt = 0;
        for (int i = 0; i <= N; ++i) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) dp[i] = 1;
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    ++cnt;
                }
            } else {
                int s1 = dp[i / 10], s2 = dp[i % 10];
                if (s1 == 1 && s2 == 1) dp[i] = 1;
                else if (s1 >= 1 && s2 >= 1) {
                    dp[i] = 2;
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}

/* Faster solution digit by digit
class Solution {
    private int[] allPossibleCount =  new int[]{1,2,3,3,3,4,5,5,6,7}; // 0,1,2,5,6,8,9
    private int[] excludeNumCount = new int[]{1,2,2,2,2,2,2,2,3,3}; // 0, 1, 8
    private boolean[] isExclude = new boolean[] {true,true,false,false,false,false,false,false,true,false};
    private boolean[] isValid = new boolean[]{true, true, true, false,false,true, true,false,true,true};
    public int rotatedDigits(int N) {
        char[] cs = Integer.toString(N).toCharArray();
        int len = cs.length, count = 0;        
        boolean exclude = true;
        for(int i = 0, mul = len; i<len; i++, mul--)
        {
            if(cs[i] == '0'&& i != len-1 )continue;
            int index = i == len-1? cs[i]-'0': cs[i]-'0'-1;
            double c =  allPossibleCount[index]*Math.pow(7,mul-1);   
            double e =  exclude ? excludeNumCount[index]*Math.pow(3,mul-1) : 0; // # of numbers which only contain 0,1,8
            count+=c-e;
            if(!isValid[cs[i]-'0'])break;
            exclude = exclude & isExclude[cs[i]-'0'];
        }
        return count;
    }
}
*/