import java.util.*;

public class AnonymousNestedClassExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Using anonymous nested class to filter even numbers and print them
        numbers.forEach(new NumberProcessor() {
            @Override
            public void process(int number) {
                if (number % 2 == 0) {
                    System.out.println(number);
                }
            }
        });
    }

    // Anonymous nested class implementing NumberProcessor interface
    interface NumberProcessor {
        void process(int number);
    }
}
