package old;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderLinkedList {

    public static void main(String[] args) {

        ListNode1 listNode6 = new ListNode1(6, null);
        ListNode1 listNode5 = new ListNode1(5, listNode6);
        ListNode1 listNode4 = new ListNode1(4, listNode5);
        ListNode1 listNode3 = new ListNode1(3, listNode4);
        ListNode1 listNode2 = new ListNode1(2, listNode3);
        ListNode1 listNode1 = new ListNode1(1, listNode2);

        ListNode1 listNode99 = new ListNode1(99, null);
        ListNode1 listNode98 = new ListNode1(98, listNode99);
        ListNode1 listNode97 = new ListNode1(97, listNode98);
        ListNode1 listNode96 = new ListNode1(96, listNode97);

        ListNode1 head = mergeLL(listNode1, listNode96);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }


    }

    public static ListNode1 mergeLL(ListNode1 n1, ListNode1 n2) {


        ListNode1 dummy = new ListNode1(-1, n1);

        while(n1 != null && n2 != null) {
            ListNode1 n1Next = n1.next;
            ListNode1 n2Next = n2.next;

            n2.next = n1Next;
            n1.next = n2;
            n1 = n1Next;
            n2 = n2Next;

        }
        return dummy.next;
    }

    public static void reorderList(ListNode1 head) {
        //put all node into arraylist or a stack
        Deque<ListNode1> stack = new ArrayDeque<>();
        ListNode1 headCopy = head;
        while (headCopy != null) {
            stack.push(headCopy);
            headCopy = headCopy.next;
        }
        headCopy = head;
        int stackSize = stack.size();
        for (int i = 0; i < stackSize / 2; i++) {
            ListNode1 next = headCopy.next;
            ListNode1 fromEnd = stack.pop();
            fromEnd.next = next;
            headCopy.next = fromEnd;
            headCopy = next;

        }

        headCopy.next = null;
    }
}


class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}
