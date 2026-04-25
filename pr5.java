//AIM
/*To develop and execute Quick Sort for large input values and evaluate the algorithm's execution time.  */

import java.util.*;
public class pr5 {
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Partition Index " + pi + " : ");
            for(int x = 0; x < arr.length; x++) {
                System.out.print(arr[x] + " ");
            }
            System.out.println();
            
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        
        long startTime = System.nanoTime();
        quicksort(arr, 0, n - 1);

        long endTime = System.nanoTime();
        System.out.println("\n Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n Execution Time: " + (endTime - startTime) + "ns");
    }
}

/*Enter no. of elements:
8
Enter elements:
Partition Index 4 :
18 4 37 16 39 72 80 46
Partition Index 1 :
4 16 37 18 39 72 80 46
Partition Index 2 :
4 16 18 37 39 72 80 46
Partition Index 5 :
4 16 18 37 39 46 80 72
Partition Index 6 :
4 16 18 37 39 46 72 80

 Sorted Array:
4 16 18 37 39 46 72 80
 Execution Time: 13075400ns */

 /*Enter no. of elements:100
Execution Time: 41500ns */