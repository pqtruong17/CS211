public class NumberCruncher {
  // This methods return greatest common divisor between integers a and b
  public static int greatestCommonDivisor(int a, int b){
    int new_a = Math.abs(a);
    int new_b = Math.abs(b);// Normalize for all integers not just positive 
    int min = Math.min(new_a,new_b);
    int gcd = Math.max(new_a,new_b); // gcd(0,a)=gcd(a,0)=|a|.
    for(int i = 1; i <= min; i++){
      boolean check_a = (new_a%i == 0);
      boolean check_b = (new_b%i == 0);
      // i is less than gcd 
      if ((check_a) && (check_b)){
        //if i divides both a and b, then i<= g
        gcd = i;
      }
    }
    return gcd;
  }
  public static void isCoprimeTest(){
    int[] a = {3,2,7,17,30,-23,25,0};
    int[] b = {5,4,15,257,11,21,100,2};
    for(int i = 0; i < a.length; i++){
      int value = greatestCommonDivisor(a[i],b[i]);
      boolean is_Coprime = isCoprime(a[i],b[i]);
      System.out.printf("Input %d and %d is %s since the greatest common divisor is %d\n",a[i] ,b[i],is_Coprime, value);
    }
  }
  // This method return a boolean value decide whether a and b are prime or not.
  public static boolean isCoprime(int input1, int input2) {
    Boolean is1 = (Math.abs(input1) == 1) || (Math.abs(input2) == 1);
    if (is1){// The number 1 and -1 are the only integers co-prime with every-integer
      return true; 
    }
    return greatestCommonDivisor(input1,input2) == 1;// If the integer a and b are co-prime, then gcd(a,b)=g(b,a)=1; 
  }  
  // This methods return a boolean value decide whether p is prime or not
  public static boolean isPrime(long p){
    if (p<0){// let p >= 2.
      throw new RuntimeException("Only p greater than or equal 1 allow");
    } // 1 is strictly not prime as an exception
    if ((p == 1) || (p == 0)){
      return false;
    }
    for(int i=2; i < p; i++){
      if (p%i == 0){// There exits an integer q such that p=qi other than p or 1.
        return false;
      }
    }
   return true; // There's no such integer q such that p=qi other than p or 1.
  }
  // This method return a boolean value decide input is Fibonacci
  public static boolean isFibonacci(long input){
  /* https://en.wikipedia.org/wiki/Fibonacci_sequence#Identification
   * The number x is a fibonacci number iff at least one of 5x^2+4 or 5x^2-4 */
   if (input <= 0){
      throw new RuntimeException("Input cannot be negative or zero since there's no real solution");
   }
   double condition1 = 5*Math.pow(input,2)+4;
   double condition2 = 5*Math.pow(input,2)-4;
   if (isPerfectSquare(condition1)){
     return true;
   } else if (isPerfectSquare(condition2)){
     return true;
   } 
   return false;
  }
  // This method return a boolean value decide whether input is perfect square or not
  public static boolean isPerfectSquare(double input){
   double sqrt = Math.sqrt(input);
   double before_decimal = Math.floor(sqrt);
   return (sqrt%before_decimal == 0);
  }
  
  public static void isFibonacciPrimeTest(){
    long[] input = {2,3,5,7,8,13};
    for (int i = 0; i < input.length; i++)
    {
      Boolean is_Fibonacci = isFibonacci(input[i]);
      Boolean is_Prime = isPrime(input[i]);
      Boolean check = (is_Fibonacci) && (is_Prime);
      System.out.printf("if %d ", input[i]);
      if (is_Fibonacci){
        System.out.print("is Fibonacci ");
      } else if (!is_Fibonacci){
       System.out.print("is not Fibonacci ");
      }
      if (is_Prime){
        System.out.print("and is prime, ");
      } else if (!is_Prime){
        System.out.print("and is not prime, ");
      }
      if (check){
        System.out.println("then it's a Fibonacci prime.");
      } else if (!check){
        System.out.println("then it's not a Fibonacci prime.");
      }
     }
  }  
  // This method return a boolean value decide whether input is both Fibonacci and prime or not. 
  public static boolean isFibonacciPrime(long input) {
    if ((isFibonacci(input)) && (isPrime(input))){
      return true;
    }
    return false;
  }

  public static void countCollatzStepsTest(){
    int[] arr = {9,97,27,1,7};
    for(int i = 0; i < arr.length; i++){
      int count = countCollatzSteps(arr[i]);
      System.out.printf("At n = %d, there will be %d steps\n",arr[i], count); 
    }
  }
 /* This method returns the number of steps it takes to get to 1
  * following the collatz game rules starting at the input*/
  public static int countCollatzSteps(int input){
    int fn = input;
    if (fn <= 0){
      throw new RuntimeException("n must be greater than or equal to 2");
      // at 0 then the function will stuck in a loop.
    }
    int count = 0;
    do {
      if (fn%2 == 0){
        count += 1;
        fn = fn/2;
      } else if (fn%2 == 1){ 
        count += 1;
        fn = (3*fn+1);
      }
    } while (fn != 1);
    return count;
  }
  
  public static void sieveOfEratosthenesTest(){
    boolean[][] arr_opp = {{true},{true, true, false},{true, true, false, false}, {true, true, false, false, true, false}};
    boolean[][] arr_cor = {{false},{false, false, true},{false, false, true, true},{false, false, true, true, false, true}};
    for(int i = 0; i < arr_opp.length; i++){
      boolean[] temp = arr_opp[i];
      sieveOfEratosthenes(temp);
      boolean check = arr_equal_bol(temp, arr_cor[i]);
      System.out.printf("Index %d of arr_opp and arr_cor are both ",i);
      if(check){
        System.out.print("equal.\n");
      } else if (!check){
         System.out.print("not equal\n");
      }
    }
  }
 /*This method marks off all the spots in the input array
  * corresponding to composite numbers, leaving only the
  * prime numbers as true.*/
  public static void sieveOfEratosthenes(boolean[] array){
    for( int i = 0; i < array.length; i++){
      if(isPrime(i)){
        array[i] = true;
      } else {
        array[i] = false;
      }
    }
  }
 //This method return a string total of all interger in the array that is seperate by comma
  public static String arrStringComma(int [] arr){ // Convert array to string 
   String str = "";
   for( int i = 0; i < arr.length; i++){
     if(i==arr.length-1){ // Stop here to avoid last comma
      str += Integer.toString(arr[i]);
      break;
     }
     str += Integer.toString(arr[i]) + ",";
   }
   return str; 
 }
 // This method return a new array of string split by commas.
 public static String[] arrIntToString(int[] array, int item, int[] replacement){
   String array_str = arrStringComma(array);//Stringtify the array of integers
   String replacement_str = arrStringComma(replacement);//Stringtify replacement the array of integer 
   String new_str = array_str.replaceAll(Integer.toString(item), replacement_str);//Replace existing item in array_str with replacement
   String[] final_str = new_str.split(",");
   return final_str;
 }
 // This method return a new array of integers from the array of string. 
 public static int[] arrStringToInt(String[] arr_str){
   int[] new_arr = new int[arr_str.length];
   
   for(int i = 0; i < arr_str.length; i++){
     int value = Integer.parseInt(arr_str[i]);
     new_arr[i] = value;
   }
   return new_arr;
 }
 // This method uses 
 public static void replaceItem(int[][] array, int item, int[] replacement){
   for(int i = 0; i< array.length; i++){
     String[] arr_str = arrIntToString(array[i], item, replacement);
     int[] new_arr = arrStringToInt(arr_str);
     array[i] = new_arr;
   }
 }
 public static boolean arr_equal_bol(boolean[] arr, boolean[] comp_arr){
   for(int i = 0; i < arr.length; i++){
     if(arr[i] != comp_arr[i]){
       return false;
     }
   }
   return true;
 }
 public static boolean arr_equal_int(int[] input, int[] correct ){
    for(int i = 0; i < input.length; i++){
     if(input[i] != correct[i]){
       return false;
     }
   }
   return true;
 }
 public static boolean replaceItemCheck(int[][][] edited_arr,int[][][] correct_arr){
   for(int i = 0; i < edited_arr.length; i++){
      for(int j = 0; j < edited_arr[i].length; j++){
        for(int k = 0; k < edited_arr[i][j].length; k++){
          if(edited_arr[i][j][k] != edited_arr[i][j][k]){
            return false;
          }
        }
      }
   }
   return true;
 }

 
 // Main method. Is not tested by the tester, create your own tests here!
 public static void main(String[] args){  
   //isCoprimeTest();
   //isFibonacciPrimeTest();
   //countCollatzStepsTest();
   //sieveOfEratosthenesTest();
   //replaceItemTest--bellow
   /*int[][][] input_arr = {{{1,2,3,4,5},{6,7,8,9}},{{1,2,3,4,5},{5,4,3,2}},{{1,2,3,4,5},{5,4,3,4}}};
   int[][][] corrrect_arr = {{{1,0,-1,3,4,5},{6,7,8,9}},{{1,2,3,4,-5,5},{-5,5,4,3,2}},{{1,2,3,1,2,3,5},{5,1,2,3,3,1,2,3}}};
   int[] items = {2,5,4};
   int[][] replacement_arr = {{0,-1}, {-5,5}, {1,2,3}};
   for(int i = 0; i < input_arr.length; i++){
     int item = items[i];
     int[] replacement = replacement_arr[i];
     int[][] input = input_arr[i];
     int[][] correct = corrrect_arr[i];
     System.out.printf("The hashcode before is %s", System.identityHashCode(input)); 
     replaceItem(input,item,replacement);
     System.out.printf(" and after is %s. \n", System.identityHashCode(input));
     for(int j = 0; j < input.length; j++){
       System.out.print("{");
       for(int k = 0; k < input[j].length; k++){
         if (k == input[j].length - 1){
           System.out.printf("%d", input[j][k]);
           break;
         }
         System.out.printf("%d,", input[j][k]);
       }
       System.out.println("}");
     }
     
   boolean xc = replaceItemCheck(input_arr,corrrect_arr); 
   System.out.printf("ReplaceItemCheck is %s\n",xc);
   } */
 }
}
