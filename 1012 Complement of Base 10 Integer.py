class Solution:
    def bitwiseComplement(self, N: int) -> int:
        bf = list(str(bin(N)[2:]))
        res = ['0' if x == '1' else '1' for x in bf]
        return int(''.join(res), 2)

''' Solution from lee215
def bitwiseComplement(self, N):
    X = 1
    while N > X: X = X * 2 + 1
    return X - N

def bitwiseComplement(self, N):
    X = 1
    while N > X: X = X * 2 + 1;
    return N ^ X
'''