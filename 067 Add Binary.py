class Solution:
    def addBinary(self, a: 'str', b: 'str') -> 'str':
        res, c = [], '0'
        i, j = len(a) - 1, len(b) - 1
        while i >= 0 or j >= 0 or c == '1':
            ai = a[i] if i >= 0 else '0'
            bj = b[j] if j >= 0 else '0'
            if ai == '0' and bj == '0':
                res.append(c)
                c = '0'
            elif ai == '1' and bj == '1':
                res.append(c)
                c = '1'
            elif c == '1':
                res.append('0')
            else:
                res.append('1')
            i -= 1
            j -= 1
        return ''.join(reversed(res))

''' One liner using int and bin, notice that bin use 0b as start.
class Solution:
    def addBinary(self, a: 'str', b: 'str') -> 'str':
        return bin(int(a, 2) + int(b, 2))[2:]
'''