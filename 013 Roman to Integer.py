class Solution:    
    def romanToInt(self, s: 'str') -> 'int':
        rti = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        sum, l = 0, len(s)
        for i in range(l):
            if i+1 >= l or rti[s[i+1]] <= rti[s[i]]:
                sum += rti[s[i]]
            else:
                sum -= rti[s[i]]
        return sum
        