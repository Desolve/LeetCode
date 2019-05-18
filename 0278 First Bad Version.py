# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        lo, hi = 1, n
        while lo <= hi:
            mi = (hi + lo) // 2
            if isBadVersion(mi):
                if mi == 1 or not isBadVersion(mi - 1):
                    return mi
                hi = mi - 1
            else:
                lo = mi + 1
        return None        
        