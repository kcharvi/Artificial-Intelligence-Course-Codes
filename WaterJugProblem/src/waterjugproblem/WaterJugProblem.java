/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterjugproblem;

/**
 *
 * @author Charvi
 */
import java.util.*;
public class WaterJugProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the litres JUG-1 can hold");
        int n = scan.nextInt();
        System.out.println("Enter the litres JUG-2 can hold");
        int m = scan.nextInt();
        System.out.println("Enter the litres required in any of the jug: ");
        int d = scan.nextInt();
        int result=minSteps(n,m,d);
        if(result==-1){
            System.out.println("Not possible to fill in any jug ");
        }
        else
          System.out.println("Minimum number of steps required is " + result);
    }
    public static int minSteps(int m, int n, int d)
{
    if (m > n)
    {
        int temp=m;
        m=n;
        n=temp;
    }
    if (d > n)
        return -1;
    if ((d % gcd(n,m)) != 0)
        return -1;
     return Math.min(pour(n,m,d),pour(m,n,d));  
}
    public static int pour(int jug1, int jug2, int d)
{
    int j = jug1;
    int t = 0;
    int step = 1; 
     while (j != d && t != d)
    {
        int temp = Math.min(j, jug2 - t);
        t  =t+ temp;
        j =j- temp;
        step++;
 
        if (j == d || t == d)
            break;
        if (j == 0)
        {
            j = jug1;
            step++;
        }
        if (t == jug2)
        {
            t = 0;
            step++;
        }
    }
    return step;
}
    public static int gcd(int a, int b)
{
    if (b==0)
       return a;
    return gcd(b, a%b);
}
    
}
