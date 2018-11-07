class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        int[] chMap = new int[26];
        for (int i = 0; i < target.length(); ++i) {
            if (Character.isLetter(target.charAt(i))) chMap[target.charAt(i) - 'a']++;
        }
        int minLength = Integer.MAX_VALUE;
        String result = null;
        for (int i = 0; i < words.length; ++i) {
            String word = words[i].toLowerCase();
            if(matches(word, chMap) && word.length() < minLength) {
                minLength = word.length();
                result = words[i];
            }
        }
        return result;
    }
    private boolean matches(String word, int[] chMap) {
        int[] targetMap = new int[26];
        for (int i = 0; i < word.length(); ++i)
            if (Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
        for (int i = 0; i < 26; ++i)
            if (chMap[i] != 0 && targetMap[i] < chMap[i]) return false;
        return true;
    }
}

/* Interesting solution by jmcelvenny using primes
class Solution {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}; 
    
    public String shortestCompletingWord(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's (make sure longer then any words[i])
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                    shortest = word;
        return shortest;
    }
    
    private long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25) 
                product *= primes[index];
        }
        return product;
    }
}
*/