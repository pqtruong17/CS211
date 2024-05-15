public class Main {

  public static long fibonacci(int num) {
    if (num < 2){
      throw new IllegalArgumentException();
    }
    if (num == 2){
      return 0;
    }
    if (num == 3){
      return 1;
    }
    return fibonacci(num-1)+fibonacci(num-2);
  }
  public static long factorial(int num) {
    if (num < 0){
      throw new IllegalArgumentException();
    }
    if (num == 0){
      return 1;
    }
    return num*factorial(num-1);
  }
  public static void main(String[] args) {
    /*
     * Part 1:
     */ 
    System.out.printf("The 1st fibonacci number is %d.\n",fibonacci(3));
    System.out.printf("The 2nd fibonacci number is %d.\n",fibonacci(4));
    System.out.printf("The 3rd fibonacci number is %d.\n",fibonacci(5));
    for(int i = 5; i < 15; i++){
      System.out.printf("the %dth fibonacci is %d.\n",i-1,fibonacci(i));
    }
    System.out.println();
    /*
     * Part 2:
     */ 
    for(int i = 0; i < 4; i++){
      System.out.printf("Factorial of 5 is %d.\n",factorial(i*5));
    }
  }
}