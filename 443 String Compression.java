class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        Stack<Character> nums = new Stack<Character>();
        int pos = 0, cnt = 0, i = 0;
        char start;
        while (true) {
            start = chars[i];
            chars[pos++] = start;
            while (i < chars.length) {
                if (chars[i] == start) {
                    i++; cnt++;
                } else
                    break;
            }       
            if (cnt == 1) cnt=0;
            if (cnt > 1) {
                while(cnt > 0) {
                    nums.push((char)('0' + cnt % 10));
                    cnt /= 10;
                }
                while (!nums.empty()) {
                    chars[pos++] = nums.pop();  // Pop from the stack to insert the repeated counts
                }
            }
            if (i == chars.length) break;
        }
        return pos;
    }
}