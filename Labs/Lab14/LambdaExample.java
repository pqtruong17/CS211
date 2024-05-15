import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Using lambda expression to filter even numbers and print them
        numbers.forEach(number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        });
    }
}
