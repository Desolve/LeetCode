class Solution:
    def checkIP(self, s: str, res: List[str], i: int, cnt: int, cur: str) -> None:
        if len(s) - i < 4 - cnt: return
        if cnt == 3:
            if len(s) - i <= 3:
                if s[i] != "0" and int(s[i:]) <= 255 or s[i:] == "0":
                    cur += s[i:]
                    res.append(cur)
        else:
            j = 1
            while j <= 3 and i + j <= len(s):
                if s[i] != "0" and int(s[i:i+j]) <= 255 or s[i:i+j] == "0":
                    self.checkIP(s, res, i + j, cnt + 1, cur + s[i: i + j] + ".")
                j += 1
        
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        self.checkIP(s, res, 0, 0, "")
        return res