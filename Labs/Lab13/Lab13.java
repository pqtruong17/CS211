import java.util.Arrays;

public class Lab13 {

    /*
     * Binary Search
     * Divide and conquer algorithm that compares the target value to the middle element of the array
     * If the target value is equal to the middle element, return the index
     * If the target value is less than the middle element, search the left half of the array
     * If the target value is greater than the middle element, search the right half of the array
     * Time Complexity: O(log n)
     * 
     * @param arr:  array of integers
     * @param x:    integer to search for
     * @return:     index of the element if found, -1 otherwise
     * 
     */
    public int BinarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right){
          int middle = left+right/2;
          if (x == arr[middle]){
            return middle;
          }
           if(x<arr[middle]){
            right = middle-1;
          } else{
            left = middle + 1;
          }
        }
        return -1;
    }


    public static void main(String[] args) {
        Lab13 lab = new Lab13();
        int[] arr_search = { 2, 3, 4, 10, 15, 20, 30 };
        int[] arr_sort = { 12, 11, 13, 5, 6 , 15, 7, 1, 8, 14 , 2, 4, 3, 10, 9};

        // Task 1: Understand Arrays.sort() and Arrays.binarySearch()
        // TODO:
        Arrays.sort(arr_sort);
        System.out.printf("Sorted Array: %s\n", Arrays.toString(arr_sort));

        // Sorted Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
        
        int searching_element =1;
        // TODO:
        int result = Arrays.binarySearch(arr_search,searching_element);
        System.out.println("Using Java embedded binary search");
        System.out.println("Element " + searching_element + " found at index " + result);
        // Task 2: Test Binary Search
        int result2 = lab.BinarySearch(arr_search, searching_element);
        System.out.println("\nUsing custom binary search");
        System.out.println("Element " + searching_element + " found at index " + result2);
        // Element 10 found at index 3


    }

}