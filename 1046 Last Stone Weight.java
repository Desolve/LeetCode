class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int a : stones) pq.offer(a);
        while (pq.size() > 1) {
            int y = pq.isEmpty() ? 0 : pq.poll();
            int x = pq.isEmpty() ? 0 : pq.poll();
            int delta = y - x;
            if (delta != 0)
                pq.offer(delta);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}