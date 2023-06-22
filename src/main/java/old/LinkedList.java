package old;

public class LinkedList {

    public static void main(String[] args) {

        ListNode n = new ListNode(1);
        ListNode d = new ListNode(2);
        ListNode z = new ListNode(3);

        n.next = d;
        n.next.next = z;

        System.out.println("out firsst");
        System.out.println(n.val);

        traverse(n);
        System.out.println("out second");

        System.out.println(n.val);

        System.out.println("END");
        String s = "TUUBS";
        stringDo(s);
        System.out.println(s);

     System.out.println("print n");
        printNode(n);
        ListNode nNode = reverse(n);
     System.out.println("printing nNode");
        printNode(nNode);

    }

    public static void printNode(ListNode node) {
     while(node != null) {
      System.out.print(node.val + " ");
      node = node.next;
     }
    }

    public static ListNode reverse(ListNode node) {

        ListNode curr = node;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void traverse(ListNode node) {
        System.out.println("in first");
        System.out.println(node.val);
        node = node.next;
        System.out.println("in second");
        System.out.println(node.val);
    }

    public static void stringDo(String s) {
        s = "booba";
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}