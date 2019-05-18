class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] isJewel = new boolean[52];
        int cnt = 0;
        for (char type : J.toCharArray()) {
            if (type >= 'a') 
                isJewel[type - 'a'] = true;
            else
                isJewel[type - 'A' + 26] = true;
        }
        for (char stone : S.toCharArray()) {
            if (stone >= 'a') {
                if (isJewel[stone - 'a'])
                    cnt++;
            } else {
                if (isJewel[stone - 'A' + 26])
                    cnt++;
            }                
        }
        return cnt;
    }
}