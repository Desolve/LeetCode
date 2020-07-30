class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> check = new HashSet<Integer>();
        for (int num : arr) {
            if (check.contains(num)) {
                return true;                
            }
            else {
                check.add(num * 2);
                if (num % 2 == 0) {
                    check.add(num / 2);
                }
            }
        }
        return false;
    }
}