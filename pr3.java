//AIM
/*To develop and execute Insertion Sort for large input values and evaluate the algorithm's execution time.  */

import java.util.*;

public class pr3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100];
        int size;

        System.out.print("Enter the size of array : ");
        size = sc.nextInt();

        for(int i = 0; i < size; i++){
            a[i] = (int)(Math.random() * 100);
        }

        long t1 = System.nanoTime();

        for(int i = 1; i < size; i++){
            int key = a[i];
            int j = i - 1;

            while(j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;

            System.out.println("Stage after " + i + " step:");
            for(int k = 0; k < size; k++){
                System.out.print(a[k] + " ");
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

/* Enter the size of array : 4
Stage after 1 step:
52 54 59 48
Stage after 2 step:
52 54 59 48
Stage after 3 step:
48 52 54 59

Sorted array:
48 52 54 59
Time: 16559500*/

/*Enter the size of array : 78

Sorted array:
0 1 1 1 4 5 5 6 6 9 10 13 15 17 18 22 22 23 23 25 25 25 26 27 30 31 31 32 33 33 33 34 37 38 39 41 43 49 54 56 60 61 61 62 62 62 63 65 65 67 67 68 68 69 71 71 72 73 75 77 81 82 83 86 87 87 89 89 91 91 91 92 93 94 95 95 97 98
Time: 814800 */