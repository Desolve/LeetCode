class Solution:
    def lengthOfLastWord(self, s: 'str') -> 'int':
        remain = s.strip()
        if remain == "":
            return 0
        return len(s.split()[-1])