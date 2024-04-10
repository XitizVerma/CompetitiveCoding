package DataStructures;

import java.util.PriorityQueue;

public class QSmallestInfiniteSetUsingPriorityQueue {

    int start;
    PriorityQueue<Integer> priorityQueue;
    public QSmallestInfiniteSetUsingPriorityQueue() {
        priorityQueue = new PriorityQueue<>();
        start=1;
    }

    public int popSmallest() {
        return priorityQueue.size() > 0 ? priorityQueue.poll() : start++;
    }

    public void addBack(int num) {
        if(start>num){
            priorityQueue.add(num);
        }
    }
}

