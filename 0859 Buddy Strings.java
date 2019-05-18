class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int cnt = 0;
        if (A.equals(B)) {
            int[] hash = new int[26];
            for (int i = 0; i < A.length();++i) {
            	hash[A.charAt(i) - 'a']++;
            	if (hash[A.charAt(i) - 'a'] > 1) return true;
            }
        }
        char apre = ' ', bpre = ' ';
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (cnt == 2) {
                    return false;
                } else if (cnt == 0) {
                    apre = A.charAt(i);
                    bpre = B.charAt(i);
                    ++cnt;
                } else {
                    if (!(apre == B.charAt(i) && bpre == A.charAt(i)))
                        return false;
                    ++cnt;
                }
            }
        }
        if (cnt == 2)
            return true;
        return false;
    }
}

/* Faster solution by nangao
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())return false;
        if(A.equals(B)) {
            char [] hash = new char[256];
            for(int i=0;i<A.length();i++) {
                hash[A.charAt(i)]++;
                if(hash[A.charAt(i)]>1)return true;
            }
            return false;
        }
        int count = 0;
        int p0 = -1,p1=-1;
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)!=B.charAt(i)) {count++;
            if(p0==-1&&count==1) {p0=i;};
            if(p1==-1&&count==2) {p1=i;};
            if(count>2)return false;
            }
            
        }
        return count == 2&&A.charAt(p0)==B.charAt(p1)&&A.charAt(p1)==B.charAt(p0);
    }
}
*/