import java.text.DecimalFormat;
import java.util.*;

public class DempsterShaferImplementation {
	  static HashMap<String,Double> Mass=new HashMap<>();
	  static HashMap<String,Double> Belief=new HashMap<>();
	  static HashMap<String,Double> Plausibility=new HashMap<>();

  public static void main(String args[]) {
	 
	  String str[]= {"Null","Red","Yellow","Green","Red or Yellow","Red or Green","Green or Yellow"	,"Any"};  
	  
	    String pattern ="##.##";
		DecimalFormat df = new DecimalFormat(pattern);
	  
	    Mass.put("Null", 0.0);
	    Mass.put("Red", 0.35);
	    Mass.put("Yellow", 0.25);
	    Mass.put("Green", 0.15);
	    Mass.put("Red or Yellow", 0.06);
	    Mass.put("Red or Green", 0.05);
	    Mass.put("Green or Yellow", 0.04);
	    Mass.put("Any", 0.1);
	    
	    System.out.println("Masses of each event: ");
	    for(String s:str) {
	    	System.out.println(s+"  "+df.format(Mass.get(s)));
	    }
	    System.out.println();
	    
	    
	    System.out.println("Calculating Beliefs: ");
	    Beliefs();
	    System.out.println();
	    System.out.println("Belief for the 'Red','Yellow' and 'Green' hypotheses\nmatches their corresponding masses because they have no subsets.");
        System.out.println();
        System.out.println("Belief for “Either” cases consists of the sum of all three masses (Either, Color1, and Color2)\nbecause “Color1” and “Color2” are each subsets of “Either”. ");
	    System.out.println();
	    System.out.println("Beliefs: ");
        for(String s:str) {
	    	System.out.println(s+"  "+df.format(Belief.get(s)));
	    }
	    System.out.println();
	    
	    System.out.println("Calculating Plausibilities: ");
	    Plausibility();
	    System.out.println();
	    System.out.println("Pl(p) = 1-Bel(~p)");
	    System.out.println("Plausibility: ");
        for(String s:str) {
	    	System.out.println(s+"  "+df.format(Plausibility.get(s)));
	    }

	    
  }
  public static void Beliefs() {
	  
	  Belief.put("Null",0.0);
	  Belief.put("Red",Mass.get("Red"));
	  Belief.put("Yellow",Mass.get("Yellow"));
	  Belief.put("Green",Mass.get("Green"));
	  
	  double RY=Mass.get("Red or Yellow")+Mass.get("Red")+Mass.get("Yellow");
	  Belief.put("Red or Yellow",RY);
	  
	  double RG=Mass.get("Red or Green")+Mass.get("Red")+Mass.get("Green");
	  Belief.put("Red or Green",RG);
	  
	  double GY=Mass.get("Green or Yellow")+Mass.get("Green")+Mass.get("Yellow");
	  Belief.put("Green or Yellow",GY);
	  
	  Belief.put("Any", 1.0);
   }
  public static void Plausibility() {
	  
	  Plausibility.put("Null",0.0);
	  
	  double r=1-(Mass.get("Yellow")+Mass.get("Green")+Mass.get("Green or Yellow"));
	  Plausibility.put("Red", r);
	  
	  double y=1-(Mass.get("Red")+Mass.get("Green")+Mass.get("Red or Green"));
	  Plausibility.put("Yellow", y);
	  
	  double g=1-(Mass.get("Red")+Mass.get("Yellow")+Mass.get("Red or Yellow"));
	  Plausibility.put("Green", g);
	  
	  double ry=1-(Mass.get("Green"));
	  Plausibility.put("Red or Yellow", ry);
	  
	  double rg=1-(Mass.get("Yellow"));
	  Plausibility.put("Red or Green", rg);
	  
	  double gy=1-(Mass.get("Red"));
	  Plausibility.put("Green or Yellow", gy);
	  
	  Plausibility.put("Any",1.0);	  
	  
  }
}
