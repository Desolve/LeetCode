class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> abpath = new LinkedList<String>();
        String[] sub = path.split("/+");
        for (int i = 1; i < sub.length; i++) {
            if (sub[i].equals("..")) {
                if (!abpath.isEmpty()) abpath.removeLast();
            } else if (!sub[i].equals(".")) {
                abpath.add(sub[i]);
            }
        }
        StringBuilder st = new StringBuilder();
        if (abpath.isEmpty()) st.append("/");
        for (String p : abpath) {
            st.append("/").append(p);
        }
        
        return st.toString();
    }
}

/* Faster solution by sunshine718
class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        String[] stack = new String[dir.length];
        int ptr = 0;
        for(int i = 0; i < dir.length; i++){
            if(dir[i].equals(".") || dir[i].equals("")){
                continue;
            }else if(dir[i].equals("..")){
                if(ptr > 0) ptr--;
            }else{
                stack[ptr] = dir[i];
                ptr++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < ptr; i++){
            result.append("/");
            result.append(stack[i]);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
*/