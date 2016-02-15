package certification.chapter3.collections.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class ArrayDequeExample {

    public static void main(String[] args) {

        // FOR QUEUE

        Queue<Integer> queue = new ArrayDeque<>();
        // add element to the back of the queue
        // and returns whether successful
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        // return next element or null
        System.out.println(queue.peek()); // 10
        // remove and return next element or null
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null

        // FOR STACK

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        /*System.out.println(stack.peek()); // 4
        System.out.println(stack.poll()); // 4
        System.out.println(stack.poll()); // 10
        System.out.println(stack.peek()); // null*/
        System.out.println("For Each");

        for(Integer i: stack){
            System.out.println(i);
        }

        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }


    }
}
