// 以下的解均未處理index < 0的狀況。 第一個解72ms, 第二個解76ms.
class MyLinkedList {

    /** Initialize your data structure here. */
    public int length;
    public Node head;
    public Node tail;
    public MyLinkedList() {
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if ( index > length - 1 || head == null )
            return -1;
        else {
            Node ite = getNode(index);
            return ite.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        // System.out.printf("Before addAtHead:");
        // printAll();
        Node node = new Node(val);
        if (length != 0)
            node.next = head;
        else {
            tail = node;
        }
        head = node;
        ++length;
        // System.out.printf("After  addAtHead:");
        // printAll();
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        // System.out.printf("Before addAtTail:");
        // printAll();
        Node node = new Node(val);
        if (length != 0)
            tail.next = node;
        else {
            head = node;
        }
        tail = node;
        ++length;
        // System.out.printf("After  addAtTail:");
        // printAll();
    }
    
    public Node getNode(int index) {
        Node ite = head;
        for (int i = 1; i <= index; ++i) {
            ite = ite.next;
        }
        return ite;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // System.out.printf("Before addAtIndex:");
        // printAll();
        if (head == null && index != 0) return;
        if (index == length) addAtTail(val);
        else if (index < length) {
            if (index == 0) addAtHead(val);
            else {
                Node ite = getNode(index - 1); // ite -> newNode -> ite.next
                Node newNode = new Node(val);
                newNode.next = ite.next;
                ite.next = newNode;
            }
            ++length;
        }
        // System.out.printf("After  addAtIndex:");
        // printAll();
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // System.out.printf("Before deleteAtIndex:");
        // printAll();
        if (length == 0) return;
        if (index < length) {
            if (index == 0) {
                head.next = head.next.next;
                head = head.next;
            } else if (index == length - 1) {
                Node node = getNode(index - 1);
                node.next = null;
                tail = node;
            } else {
                Node node = getNode(index - 1);
                if (head == node) head.next = node.next.next;
                else node.next = node.next.next;
            }
            --length;
        }
        // System.out.printf("After  deleteAtIndex:");
        // printAll();
    }
    /*public void printAll() {
        if (head == null) 
            System.out.printf("Null List!\n");
        else {
            Node ite = head;
            System.out.printf(" length = %d, list: %d", length, ite.val);
            while (ite.next != null){
                ite = ite.next;
                System.out.printf("->%d", ite.val);
            }
            System.out.println("");
        }
    }*/
}
class Node {
    Node next;
    int val;
    Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/* Using two constant Node as head and tail
class MyLinkedList {
    final Node head = new Node(0), tail = new Node(0);
    int len;

    public MyLinkedList() { head.next = tail;}

    public int get(int i) {
        if (i >= len) return -1;
        Node node = findPrev(i);
        return node.next.val;
    }

    public void addAtHead(int val) { addAtIndex(0, val);}

    public void addAtTail(int val) { addAtIndex(len, val);}

    public void addAtIndex(int i, int val) {
        if (i > len) return;
        Node prev = findPrev(i), next = prev.next;
        prev.next = new Node(val);
        prev.next.next = next;
        len++;
    }

    public void deleteAtIndex(int i) {
        if (i >= len) return;
        Node prev = findPrev(i);
        prev.next = prev.next.next;
        len--;
    }

    Node findPrev(int i) {
        Node node = head;
        while (i-- > 0)
            node = node.next;
        return node;
    }

    class Node {
        int val;
        Node next;

        Node(int val) { this.val = val;}
    }
}
*/