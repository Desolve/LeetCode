class RecentCounter {
    public ArrayList<Integer> arr;
    public RecentCounter() {
        arr = new ArrayList<>();
    }
    
    public int ping(int t) {
        arr.add(t);
        int index = Collections.binarySearch(arr, t-3000);
        if (index < 0) index = - index - 1;
        return arr.size() - index;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */