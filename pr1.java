//AIM
/*To implement Selection Sort on a sufficiently large dataset and measure its execution time to analyze its performance.  */

import java.util.*;

public class pr1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100];
        int size, temp;

        System.out.print("Enter the size of array : ");
        size = sc.nextInt();

        for(int i = 0; i < size; i++){
            a[i] = (int)(Math.random() * 100);
        }

        long t1 = System.nanoTime();

       for(int i = 0; i < size-1; i++){
            int min = i;

            for(int j = i+1; j < size; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }

            temp = a[i];
            a[i] = a[min];
            a[min] = temp;

          System.out.println("Stage after " + (i+1) + " step:");
            for(int j = 0; j < size; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
        
}
        long t2 = System.nanoTime();

        System.out.println("\nSorted array:");
        for(int i = 0; i < size; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\nTime: " + (t2-t1));
    }
}

/*
Enter the size of array : 5
Stage after 1 step:
0 14 33 53 18
Stage after 2 step:
0 14 33 53 18
Stage after 3 step:
0 14 18 53 33
Stage after 4 step:
0 14 18 33 53

Sorted array:
0 14 18 33 53
Time: 9962100 */

/*Enter the size of array : 89

Sorted array:
0 0 1 2 4 5 6 6 7 7 9 11 12 12 12 13 16 17 18 19 20 21 21 21 23 24 26 26 28 30 31 31 31 34 38 38 40 41 43 43 43 43 44 44 45 45 45 46 46 46 46 49 50 53 55 57 61 62 63 63 65 65 65 66 68 69 72 74 74 75 77 77 77 80 86 89 90 91 91 92 93 94 95 98 99 99 99 99 99
Time: 107300 */