import java.util.*;
public class DempsterShafer {
   public static void main(String args[]) {
	   Scanner sc=new Scanner(System.in);
	   int test;
	   System.out.println("How many test cases?");
	   test=sc.nextInt();
	   int i=0;
	   do {
		   
		   i++;
		   System.out.println("Test Case number: "+i);
		   System.out.println("Is it a fair coin?(yes/no)");
		   String str=sc.next();
		   double probability=0;
		   double massFunction;
		   if(str.equalsIgnoreCase("yes"))
		   {
			   probability=0.5;
		   }
		   else if(str.equalsIgnoreCase("no")){
			   System.out.println("Enter the probability of bias: ");
			   probability=sc.nextFloat();
			   if(probability<0||probability>1) {
				   System.out.println("Invalid probability. Restart the process.");
			   }
		   }   
		   
		   System.out.println("Enter the percentage of mass function(expert's confidence level): ");
		   massFunction= sc.nextFloat();
		   System.out.println("Head/Tail?");
		   String str1=sc.next();
		   double result= BeliefFunction(probability,massFunction);
		   System.out.println("Bel("+str1+")"+"= "+result+" and Bel(~"+str1+")="+result);
	       
	   }while(i<test);
	   sc.close();
	   	   
   }
   public static double BeliefFunction(double probability, double massFunction) {
	   System.out.println("According to Dempster Shafer Theory the Belief Function ");
	   massFunction=massFunction/100;
	   double res=massFunction*probability;
	   return res;
   }
}
