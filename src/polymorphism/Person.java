package polymorphism;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Person {
    String name;
    int age;

    Comparator<Person> BY_NAME= new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        System.out.println("Stack");
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println(integers.peek());
        System.out.println(integers.pop());
        System.out.println(integers.peek());

        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println("Queue");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(7);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }
}
