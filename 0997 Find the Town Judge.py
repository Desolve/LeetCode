class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trust_other = [0] * N
        be_trusted = [0] * N
        for pair in trust:
            trust_other[pair[0]-1] += 1
            be_trusted[pair[1]-1] += 1
        
        for i in range(N):
            if trust_other[i] == 0 and be_trusted[i] == N-1:
                return i+1
        return -1

''' Solution from lee215
    def findJudge(self, N, trust):
        count = [0] * (N + 1)
        for i, j in trust:
            count[i] -= 1
            count[j] += 1
        for i in range(1, N + 1):
            if count[i] == N - 1:
                return i
        return -1
'''