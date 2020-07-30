class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        check = set()
        for num in arr:
            if num not in check:
                check.update({num * 2, num / 2})
            else:
                return True
        return False
            