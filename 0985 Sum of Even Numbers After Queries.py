class Solution:
    def sumEvenAfterQueries(self, A: 'List[int]', queries: 'List[List[int]]') -> 'List[int]':
        evenSum = 0
        res = []
        for num in A:
            if num % 2 == 0:
                evenSum += num
        for val, index in queries:
            prev = A[index]
            A[index] += val
            if A[index] % 2 == 0:
                if prev % 2 == 0:
                    evenSum += val
                else:
                    evenSum += A[index]
            else:
                if prev % 2 == 0:
                    evenSum -= prev
            res.append(evenSum)
        return res