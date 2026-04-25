//AIM
/* Implement and Binary Search. */

import java.util.*;

public class pr6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter sorted elements:");
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0, high = n - 1;
        int pos = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(a[mid] == key){
                pos = mid;
                break;
            }
            else if(a[mid] < key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        if(pos != -1){
            System.out.println("Found at position: " + pos);
        } else {
            System.out.println("Not Found");
        }
    }
}

/*Enter size: 5
Enter sorted elements:
34
67
89
92
98
Enter element to search: 89
Found at position: 2 */

/*Enter size: 4
Enter sorted elements:
34
67
89
92
Enter element to search: 23
Not Found */