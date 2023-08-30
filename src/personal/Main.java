package personal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        playDynamicArray();
        playQueue();
    }

    private static void playQueue() {
        var myqueue = new PriorityQueue<>();
        myqueue.add(8);
        myqueue.add(6);
        myqueue.add(5);
        myqueue.add(7);
        myqueue.forEach(item -> System.out.print(item + " "));
        System.out.println(myqueue.peek());
        System.out.println(myqueue.poll());
        System.out.println(myqueue.poll());
        System.out.println("Size of the queue: " + myqueue.size());
    }

    private static void playDynamicArray() {
        var dynamicArray = new DynamicArray<Integer>();
        dynamicArray.add(1, 2, 3, 4, 5);
        dynamicArray.append(6);
        dynamicArray.prepend(0);
        dynamicArray.addAtIndex(4, 10);

        Object[] items = dynamicArray.get();
        Arrays.stream(items).forEach(System.out::println);
        System.out.println();

        dynamicArray.removeLast();
        dynamicArray.removeFirst();
        dynamicArray.removeAtIndex(3);

        Object[] items2 = dynamicArray.get();
        Arrays.stream(items2).forEach(System.out::println);
        System.out.println();
    }
}