class Solution:
    def convertToTitle(self, n: int) -> str:
        res = ""
        while n > 0:
            n -= 1
            res += chr(ord('A') + n % 26)
            n //= 26
        return res[::-1]

'''
# Solution from liuyaozhong123
class Solution:
    def convertToTitle(self, n: int) -> str:
        digit2char = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
        resList = []
        
        while(n):
            n -= 1
            resList.append(n % 26)
            n = n//26
        res = ""
        reslength = len(resList)
        for i in range(reslength):
           res = digit2char[resList[i]] + res
        return res
'''