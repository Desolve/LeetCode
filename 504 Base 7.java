class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean ispos;
        if (num < 0) {
            ispos = false;
            num = -num;
        } else {
            ispos = true;
        }
        StringBuilder st = new StringBuilder();
        while (num > 0) {
            st.append(String.valueOf(num % 7));
            num /= 7;
        }
        if (!ispos) st.append("-");
        
        return st.reverse().toString();        
    }
}