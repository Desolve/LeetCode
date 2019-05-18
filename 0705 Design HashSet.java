class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] arr;
    public MyHashSet() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

/* Using bucket to reduce some memory usage
class MyHashSet {

    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;
    
    // Initialize your data structure here. 
    public MyHashSet() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }
    
    public void add(int key) {
        int hashkey = hash(key);
        
        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null)
            table[hashkey][pos(key)] = false;
    }
    
    // Returns true if this set did not already contain the specified element 
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }
}

*/