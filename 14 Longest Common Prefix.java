class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int minlen = strs[0].length();
        for(int i=1; i < strs.length; i++){
            minlen = Math.min(strs[i].length(), minlen);
        }
        int commonlen;
        for(commonlen = 0; commonlen < minlen; commonlen++) {
            boolean ifSame = true;
            for(int i=1; i < strs.length; i++){
                if(strs[0].charAt(commonlen) != strs[i].charAt(commonlen)){
                    ifSame = false;
                    break;
                }                    
            }
            if(ifSame == false)
                break;
        }
        return strs[0].substring(0, commonlen);
    }
}