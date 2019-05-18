class Solution:
    def countPrimes(self, n: int) -> int:
        if n <= 2: return 0
        nPrime = [False] * n
        res = 0
        for i in range(2, n):
            if not nPrime[i]:
                for j in range(2 * i, n, i):
                    nPrime[j] = True
                res += 1
        return res
''' Faster solution from tusizi
class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3: return 0
        prime = [True] * n
        prime[0] = prime[1] = False
        for i in range(2, int(n ** 0.5) + 1):
            if prime[i]:
                prime[i * i: n: i] = [False] * len(prime[i * i: n: i])
        return sum(prime)
'''
''' Beat 99.08% solution from dearborn (using 0/1 is faster than True/False)
class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3: return 0
        prime = [1] * n
        prime[0] = prime[1] = 0
        for i in range(2, int(n ** 0.5) + 1):
            if prime[i]:
                prime[i * i: n: i] = [0] * ((n-1-i*i)//i + 1)
        return sum(prime)
'''