class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                ++cnt[0];
            } else if (bill == 10) {
                if (cnt[0] > 0) {
                    --cnt[0];
                    ++cnt[1];
                } else {
                    return false;
                }
            } else {
                if (cnt[1] > 0 && cnt[0] > 0) {
                    --cnt[1];
                    --cnt[0];
                } else if (cnt[0] >= 3) {
                    cnt[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

// Clearer solution
/*
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) ++five;
            else if (b == 10) { ++ten; --five; }
            else if (ten > 0) { --ten; --five; }
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}*/