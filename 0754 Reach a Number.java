class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;
        while (sum < target) sum += ++step;
        while ((sum - target) % 2 != 0) sum += ++step;
        return step;
    }
}

/* Faster solution using sqrt by zq670067
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sqrt = (int) Math.sqrt(2*target);
        if(sqrt*(sqrt+1) < 2*target) sqrt++;
        if(target%2 == 0) {
            while(sqrt%4 != 0 && (sqrt+1)%4 != 0 ) sqrt++;
        } else {
            while(sqrt%4 == 0 || (sqrt+1)%4 == 0 ) sqrt++;
        }
        return sqrt;
    }
}
*/