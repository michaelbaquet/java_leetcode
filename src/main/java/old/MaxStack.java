package old;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class MaxStack {

    LinkedList<Integer> primary = new LinkedList<>();
    LinkedList<Integer> secondary = new LinkedList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public MaxStack() {

    }

    public void push(int x) {
        primary.push(x);
        maxHeap.add(x);
    }

    public int pop() {
        Integer popped = primary.pop();
        maxHeap.remove(popped);
        return popped;
    }

    public int top() {
        return primary.peek();
    }

    public int peekMax() {
        return maxHeap.peek();
    }

    public int popMax() {
        Integer max = maxHeap.poll();

        if(max != null) {

            while(true) {
                Integer top = primary.pop();
                if(top.equals(max)) {
                    break;
                }
                secondary.push(top);
            }

            int reps = secondary.size();
            for(int i = 0 ; i < reps; i++) {
                primary.push(secondary.pop());
            }
        }
        return max;
    }
}
