class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= list.removeLast();
            }
            else if (op.equals("D")) {
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            }
            else if (op.equals("+")) {
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            }
            else {
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
        return sum;
    }
}

/* Fastest solution using only int array
class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        int valid[] = new int[ops.length];
        int v = -1;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                sum -= valid[v];
                v--;
            } else if (ops[i].equals("D")) {
                int d = (valid[v] + valid[v]);
                v++;
                valid[v] = d;
                sum += d;
            } else if (ops[i].equals("+")) {
                int p = (valid[v] + valid[v - 1]);
                v++;
                valid[v] = p;
                sum += p;
            } else {
                int val = Integer.parseInt(ops[i]);
                v++;
                valid[v] = val;
                sum += val;
            }
        }

        return sum;
    }
}
*/