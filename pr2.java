//AIM
/*To implement Bubble Sort on a sufficiently large dataset and measure its execution time to analyze its performance.  */

import java.util.*;
public class pr2 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100];
        int size, temp, flag;
        
        System.out.print("Enter the size of array : ");
        size = sc.nextInt();

               for(int i = 0; i < size; i++){
                a[i] = (int)(Math.random() * 100);
            }
        
        long t1 = System.nanoTime();
        
        for(int i = 0; i < size-1; i++)
        {
            flag = 0;
            for(int j = 0; j < size-i-1; j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0){
                break;
            }
   
           System.out.println("Stage of array after " + (i+1) + " step : ");
            for(int j = 0; j < size; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println("");
        }
        
        long t2 = System.nanoTime();
        
        System.out.println("\nYour sorted array :");
        for(int i = 0; i < size; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\nThe total time taken by the system to sort the array is " + (t2-t1) + " nanosecond.");
    }
}

/*Enter the size of array : 7
Stage of array after 1 step :
63 55 42 64 11 23 66
Stage of array after 2 step :
55 42 63 11 23 64 66
Stage of array after 3 step :
42 55 11 23 63 64 66
Stage of array after 4 step :
42 11 23 55 63 64 66
Stage of array after 5 step :
11 23 42 55 63 64 66

Your sorted array :
11 23 42 55 63 64 66
The total time taken by the system to sort the array is 16410800 nanosecond. */

/*Enter the size of array : 100

Your sorted array :
0 0 0 1 4 5 5 10 11 13 15 16 17 17 17 18 20 21 21 22 23 25 25 26 27 28 30 30 31 31 31 34 37 38 39 39 43 43 44 46 46 46 47 47 47 48 50 52 54 56 56 56 56 57 57 57 60 61 64 64 66 66 68 69 69 69 70 71 72 73 73 74 74 75 75 76 77 77 79 80 81 81 83 84 84 84 85 86 87 88 88 88 88 90 92 92 94 95 96 97
The total time taken by the system to sort the array is 202300 nanosecond. */