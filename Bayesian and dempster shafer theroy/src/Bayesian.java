import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Bayesian {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        
		
		String pattern ="##.#####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		HashMap<String,Double> Burglary=new HashMap<>();
		HashMap<String,Double> Earthquake=new HashMap<>();
		HashMap<String,Double> Alarm=new HashMap<>();
		HashMap<String,Double> David=new HashMap<>();
		HashMap<String,Double> Sophia=new HashMap<>();
		
		Burglary.put("True",0.002);
		Burglary.put("False",0.998);
		
		Earthquake.put("True",0.001);
		Earthquake.put("False",0.999);
		
		Alarm.put("True True True", 0.94);
		Alarm.put("True True False", 0.95);
		Alarm.put("True False True", 0.31);
		Alarm.put("True False False", 0.001);			
		Alarm.put("False True True", 0.06);
		Alarm.put("False True False", 0.04);
		Alarm.put("False False True", 0.69);
		Alarm.put("False False False", 0.999);
		
		David.put("True True", 0.91);
		David.put("True False", 0.05);
		David.put("False True", 0.09);
		David.put("False False", 0.95);
		
		Sophia.put("True True", 0.75);
		Sophia.put("True False", 0.02);
		Sophia.put("False True", 0.25);
		Sophia.put("False False", 0.98);
		
		int test=0;
		System.out.println("Enter the number of test cases");
		test=sc.nextInt();
		int i=0;
		do {
			
		    System.out.println("|Burglary|         |Earthquake|\n"
		    		+ "     \"                  \""+"\n"+"          \"         \"" +"\n"
		    		+ "            |Alarm|      \n"
		    		+ "          \"         \"" +"\n"+"     \"                  \"" +"\n"
		    		+ "  |David|            |Sophia|");
		    System.out.println("Type True or False for the occurances of each event: ");
		    String b="";
		    System.out.println("Burglary: ");
		    b=sc.next();
		    String e="";
		    System.out.println("Earthquake: ");
		    e=sc.next();
		    String a="";
		    System.out.println("Alarm: ");
		    a=sc.next();
		    String d="";
		    System.out.println("David: ");
		    d=sc.next();
		    String s="";
		    System.out.println("Sophia: ");
		    s=sc.next();
		    
		System.out.println("The probability that the burglary has ");
		String burglary=(b.equalsIgnoreCase("false"))?"not occurred":"occurred";
		System.out.print(burglary);
		System.out.println(" and the earthquake has ");
		String earthquake=(e.equalsIgnoreCase("false"))?"not occurred":"occurred";
		System.out.print(earthquake);
		System.out.println(" along with alarm  ");
		String alarm=(a.equalsIgnoreCase("false"))?"not ringing,":"ringing,";
		System.out.print(alarm);
		System.out.println(" David ");
		String david=(d.equalsIgnoreCase("false"))?"does not call":"calls";
		System.out.print(david);
		System.out.println(" and Sophia ");
		String sophia=(s.equalsIgnoreCase("false"))?"does not call":"calls";
		System.out.println(sophia);
		
		
		double conditionalProbability=Sophia.get(s+" "+a)*
				David.get(d+" "+a)*Alarm.get(a+" "+b+" "+e)*
				Burglary.get(b)*Earthquake.get(e);
		System.out.println(decimalFormat.format(conditionalProbability));
		i++;
		}while(i<test);
        sc.close();

   }
}
