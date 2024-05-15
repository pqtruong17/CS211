import java.util.*;

public class Main{  
  public static void main(String[] args){
    Container<Person> personContainer = new Container<>(2);
    personContainer.add(new Person("Alice",25));
    personContainer.add(new Person("Bob",30));
    System.out.println("First element " + personContainer.get(0));
    if (personContainer.remove(personContainer.get(0)) == true){
      System.out.println("Person removed");
      System.out.println("Person container size is " + personContainer.size());
    }
    System.out.println("First element " + personContainer.get(0));
    Queue<Integer> intergerQueue = new LinkedList<>();
    intergerQueue.add(8);
    intergerQueue.add(2);
    intergerQueue.add(4);
    intergerQueue.add(1);
    intergerQueue.add(9);
    System.out.printf("Head value using the peek function:%s.\n", intergerQueue.peek());
    System.out.printf("The queue elements:");
    for(int i: intergerQueue){
      System.out.println(i);
    }
    
    PriorityQueue<Integer> intergerPriorityQueue = new PriorityQueue<>();
    intergerPriorityQueue.add(8);
    intergerPriorityQueue.add(2);
    intergerPriorityQueue.add(4);
    intergerPriorityQueue.add(1);
    intergerPriorityQueue.add(9);
    System.out.printf("Head value using the peek function:%s.\n", intergerQueue.peek());
    System.out.printf("The queue elements:");
    for(int i: intergerQueue){
      System.out.println(i);
    }
    //Queue<Integer> queue = new Queue<Integer>();
    //queue.add(0.0);
  } 
}