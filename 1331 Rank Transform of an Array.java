class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sArr);
        HashMap<Integer, Integer> rk = new HashMap<>();
        for (int n: sArr) rk.putIfAbsent(n, rk.size() + 1);
        for (int i = 0; i < arr.length; ++i) arr[i] = rk.get(arr[i]);
        return arr;
    }
}