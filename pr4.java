//AIM
/*To implement Merge Sort on a sufficiently large dataset and measure its execution time to analyze its performance.  */

import java.util.*;
public class pr4 {
    static void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }    
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        } 
        System.out.print("Merging " + left + ":" + right + " : ");
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
        System.out.println();
    }
    
    static void mergesort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        
        long startTime = System.nanoTime();
        mergesort(arr, 0, n - 1);
        long endtime = System.nanoTime();
        System.out.println("\n Sorted Array: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n Execution Time: " + (endtime - startTime) + "ns");
    }
}

/*
Enter no. of elements: 7
Enter elements: Merging 0:1 : 23 71 43 36 26 92 99
Merging 2:3 : 23 71 36 43 26 92 99
Merging 0:3 : 23 36 43 71 26 92 99
Merging 4:5 : 23 36 43 71 26 92 99
Merging 4:6 : 23 36 43 71 26 92 99
Merging 0:6 : 23 26 36 43 71 92 99

 Sorted Array:
23 26 36 43 71 92 99
 Execution Time: 16421100ns*/

 /* Enter no. of elements: 100
Enter elements:
 Execution Time: 118900ns*/