class Solution:
    def addToArrayForm(self, A: 'List[int]', K: 'int') -> 'List[int]':
        res = []
        digit = len(A) - 1;
        while (K > 0 and digit >= 0):
            sum = A[digit] + K % 10
            res.insert(0, sum % 10)
            K = K // 10 + sum // 10
            digit -= 1
        if K == 0:
            while digit >= 0:
                res.insert(0, A[digit])
                digit -= 1
        else:
            while K > 0:
                res.insert(0, K % 10)
                K //= 10
        return res
		
''' Faster Solution
class Solution:
    def addToArrayForm(self, A: 'List[int]', K: 'int') -> 'List[int]':
        A[-1] += K
        i = len(A) - 1
        while i > 0 and A[i] > 9:
            A[i-1] += A[i] // 10
            A[i] = A[i] % 10
            i -= 1
        while A[0] > 9:
            A.insert(0, A[0] // 10)
            A[1] = A[1] % 10
        return A
'''

''' One line solution
class Solution:
    def addToArrayForm(self, A: 'List[int]', K: 'int') -> 'List[int]':
        return [int(j) for j in str(int(''.join([str(i) for i in A])) + K)]

# In python 3, map returns an iterator instead of a list, so we need to use list() for output.
class Solution:
    def addToArrayForm(self, A: 'List[int]', K: 'int') -> 'List[int]':
        return list(map(int,list(str(int("".join(map(str,A))) +K))))
'''