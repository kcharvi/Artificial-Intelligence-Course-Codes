/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterjug;

/**
 *
 * @author Charvi
 */
import java.util.*;
class WaterJug{
    public static void main(String sap[]){
    Scanner sc = new Scanner(System.in);

    // j1 is capacity of small tank
    System.out.print("\nEnter odd capacity of small tank: ");
    int j1 = sc.nextInt();

    // j2 is capacity of large tank
    System.out.print("\nEnter odd capacity of large tank: ");
    int j2 = sc.nextInt();

    // count takes care of number of iterations
    int count = j1 + j2;

    /* jug1 array would hold the values for smaller tank and jug2 array would hold the values for larger     tank */
    int jug1[] = new int[count];
    int jug2[] = new int[count];

    int i=0;

    // initialzing jug1 and jug2 array
    jug1[i] = j1;
    jug2[i] = 0;
    i++;

    jug1[i] = 0;
    jug2[i] = j1;
    i++;

    while(i < count){
          if(jug1[i-1] > 0){
               // if jug1 has any amount of water i.e. it is not empty
               jug1[i] = jug1[i-1];
               jug2[i] = 0;
          }
          else{
               // jug1 is fully empty
               jug1[i] = j1;
               jug2[i] = jug2[i-1];
          }
          i++;

          if(jug2[i-1] > 0){
               // if jug2 has any amount of water i.e. it is not empty
               if(jug1[i-1] + jug2[i-1] < j2){
                     // final result obtained
                     jug2[i] = jug1[i-1] + jug2[i-1];
                     jug1[i] = 0;
               }
               else{
                     int temp = jug2[i-1];
                     temp = j2 - temp;
                     jug2[i] = temp + jug2[i-1];
 
                     jug1[i] = jug1[i-1] - temp;
               }
          }
          else{
               // jug2 is fully empty
               jug2[i] = jug1[i-1];
               jug1[i] = 0; 
         }
         i++;
    }

    // display final result
    for(i=0; i<count; i++){
             System.out.print("\nJUG1: "+jug1[i]+"\tJUG2: "+jug2[i]);
    }

    System.out.println();
    }
}