import java.util.ArrayList;
import java.util.List;
public class Main {
 public static void main(String[] args) {
  List<CustomInteger> L1 = new ArrayList<>();
  L1.add(new CustomInteger(12));
  L1.add(new CustomInteger(23));
  L1.add(new CustomInteger(34));
  
  List<Integer> L2 = new ArrayList<>();
  L2.add(10);
  L2.add(20);
  L2.add(30);
  
  
  /*for(int i = 0; i < L1.size(); i++){
    System.out.println(L1.get(i)+" ");
  }
  System.out.println();*/
  
  /*for(int i = 0; i < L2.size(); i++){
    System.out.println(L2.get(i)+" ");
  }
  System.out.println();
  */
  // print L1 and L2 using printNumberListUpper and printNumberListLowerBound
  System.out.println("Using printNumberListUpper on L1");
  printNumberListUpperBound(L1);
  System.out.println("Using printNumberListUpper on L2");
  printNumberListUpperBound(L2);
  
  System.out.println("Using printNumberListLowerBound on L2");
  printNumberListLowerBound(L1);
 }
 static void printNumberListUpperBound(List<? extends Number> data){
    for(Number i: data){
      System.out.println(i+ " ");
    }
    System.out.println();
  }
  static void printNumberListLowerBound(List<? super CustomInteger> data){
    for(Object i: data){
      System.out.println(i + " ");
    }
    System.out.println();
  }
}

 
