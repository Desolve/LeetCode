class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res, subset = [], []
        self.backtrack(res, subset, nums, 0)
        return res

    def backtrack(self, res: List[List[int]], subset: List[int], nums: List[int], i: int) -> None:
        if i == len(nums):
            res.append(subset.copy())
        else:
            self.backtrack(res, subset, nums, i + 1)
            subset.append(nums[i])
            self.backtrack(res, subset, nums, i + 1)
            subset.pop()