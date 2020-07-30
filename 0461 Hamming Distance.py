class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        ham = x ^ y # hamming distance表一個1一個0的數量，取x XOR y後，再算bit 1的個數
        cnt = 0
        
        while ham: # 當ham不等於0
            ham &= (ham - 1) # 和自己減1互相XOR會將最後一位的bit 1去除掉，所以反覆做到ham為0時的總次數即為答案
            cnt += 1
        
        return cnt