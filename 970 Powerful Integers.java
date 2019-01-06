class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        if (bound < 2) return new ArrayList<>();
        for (int xp = 1; xp < bound; xp *= x) {
            for (int yp = 1; xp + yp <= bound; yp *= y) {
                set.add(xp + yp);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<Integer>(set);
    }
}