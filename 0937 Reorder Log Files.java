class Solution {
    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String[] sp1 = s1.split(" ");
            String[] sp2 = s2.split(" ");
            String log1 = s1.substring(sp1[0].length() + 1);
            String log2 = s2.substring(sp2[0].length() + 1);
            int res = log1.compareTo(log2);
            return (res != 0) ? res : sp1[0].compareTo(sp2[0]);
        }
    }
    public boolean isDigit(String s) {
        return Character.isDigit(s.charAt(0));
    }
    public boolean isLetter(String s) {
        return Character.isLetter(s.charAt(0));
    }
    
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return new String[0];
        List<String> lelogs = new ArrayList<>();
        List<String> dilogs = new ArrayList<>();
        for (String log : logs) {
            String[] splog = log.split(" ");
            if (isLetter(splog[1])) lelogs.add(log);
            else dilogs.add(log);
        }
        Collections.sort(lelogs, new StringComparator());
        lelogs.addAll(dilogs);
        return lelogs.toArray(new String[0]);
    }
}

/* Faster solution
class Solution {
    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int s1i = s1.indexOf(' ') + 1;
            int s2i = s2.indexOf(' ') + 1;
            char s1c = s1.charAt(s1i);
            char s2c = s2.charAt(s2i);
            
            if (s1c <= '9') {
                if (s2c <= '9') return 0; // digit-log, the order won't change
                else return 1; // letter-log comes before digit-log
            }
            if (s2c <= '9') return -1;
            
            String log1 = s1.substring(s1i);
            String log2 = s2.substring(s2i);
            int res = log1.compareTo(log2);
            return (res != 0) ? res : s1.substring(0, s1i).compareTo(s2.substring(0, s2i));
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return new String[0];
        Arrays.sort(logs, new StringComparator());
        return logs;
    }
}
*/