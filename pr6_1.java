//AIM
/*Implement Linear search. */

import java.util.*;

public class pr6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int pos = -1;

        for(int i = 0; i < n; i++){
            if(a[i] == key){
                pos = i;
                break;
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
Enter elements:
23
44
13
98
35
Enter element to search: 98
Found at position: 3 */

/*Enter size: 5
Enter elements:
23
44
13
98
35
Enter element to search: 45
Not Found */