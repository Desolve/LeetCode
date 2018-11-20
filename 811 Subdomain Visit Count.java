class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] pair = domain.split(" ");
            int cnt = Integer.valueOf(pair[0]);
            String[] tokens = pair[1].split("\\.");
            
            String token = tokens[tokens.length - 1];
            map.put(token, map.getOrDefault(token, 0) + cnt);
            for (int i = tokens.length - 2; i >= 0; --i) {
                token = tokens[i] + "." + token;
                map.put(token, map.getOrDefault(token, 0) + cnt);
            }
        }
        Iterator it = map.entrySet().iterator();
        List<String> res = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            res.add(pair.getValue() + " " + pair.getKey());
        }
        return res;
    }
}

/* Faster solution, use indexOf and substring instead of split
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }
}
*/