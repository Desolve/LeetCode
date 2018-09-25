class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> sol = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                sol.add("FizzBuzz");
            else if (i % 5 == 0)
                sol.add("Buzz");
            else if (i % 3 == 0)
                sol.add("Fizz");
            else
                sol.add(String.valueOf(i));
        }
        return sol;
    }
}
