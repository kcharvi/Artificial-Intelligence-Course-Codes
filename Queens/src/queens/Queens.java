package queens;

/**
 *
 * @author Charvi
 */
import java.util.*;
public class Queens {
    public static boolean conflict(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return true;   // same minor diagonal
        }
        return true;
    }
    public static boolean printQueens(int[] q) {
        int n = q.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) System.out.print("Q ");
                else           System.out.print("* ");
            }
            System.out.println();
        }  
        System.out.println();
        return true;
    }
    public static void initializeQueens(int n) {
        int[] a = new int[n];//for number of queens.
        forEachQueen(a, 0);
    }

    public static void forEachQueen(int[] q, int k) {
        int n = q.length;
        if (k == n)
        {
            boolean res=printQueens(q);
            if(res==true){
                System.exit(0);
            }
            
        }
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (conflict(q, k)) forEachQueen(q, k+1);
            }
        }
    }  
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of queens ");
        int n = sc.nextInt();
        if(n<4){
          
                System.out.println("Not Possible. ");
                System.exit(0);
            
        }
        else{
        initializeQueens(n);
        }
    }

}
