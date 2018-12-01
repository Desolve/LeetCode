class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats.length <= 2) return 1;
        int last = -1;
        int res = 0;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (last == -1) {
                    res = i;
                } else {
                    res = Math.max(res, (i - last) / 2); 
                }
                last = i;
            }
        }
        if (last != seats.length - 1) {
            res = Math.max(res, seats.length - 1 - last);
        }
        return res;
    }
}

/* Faster solution by luyeyun
class Solution {
    public int maxDistToClosest(int[] seats) {
        int dis=0;
        int count=0;
        int max=0;
        boolean flag=false;

        for(int i=0;i<seats.length;i++)
        {
            if(seats[i]==0)
            {
                count++;
                if(i==seats.length-1)// 0 at the end
                {
                    return count>max? count:max;
                }
            }
            else
            {
                if(flag==false) {dis=count;flag=true;} // 0 at the beginning
                else {dis = (count%2==0)? count/2:count/2+1;}

                if(max<dis) max=dis;
                count=0;     
            }

        }
        return max;
    }
}
*/