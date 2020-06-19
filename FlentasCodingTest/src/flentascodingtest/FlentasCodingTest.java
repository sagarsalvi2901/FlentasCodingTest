
package flentascodingtest;

import java.util.Scanner;
import java.util.regex.Pattern;


public class FlentasCodingTest {

    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter number of test cases ");
        int t= sc.nextInt();
        int i=0;
        String pat;
        
        for(i=1;i<=t;i++)
        {
            System.out.println("");
            System.out.println("Test case number "+ i);
            
            System.out.println("");            
            System.out.println("Enter the pattern");
            pat=sc.next();
            if(!(Pattern.matches("^[a-z_\\-]+$", pat)) )
            {
                System.out.println("only lower case input allowed");
                break;
            }
            
            
            System.out.println("");            
            System.out.println("Enter the text string");
            String txt=sc.next();
            if(!(Pattern.matches("^[a-z_\\-]+$", txt)) )
            {
                System.out.println("only lower case input allowed");
                break;
            }
            
            System.out.println("permutations of pattern " + pat + " are"); 
            String[] patArray = permute(pat,0,pat.length()-1).split("");
            
            for(int z=0;z<=patArray.length;z++)
            {              
                if(pat.length()>txt.length())
                {
                System.out.println("No");    
                }
                if (txt.contains(patArray[z]) == true) 
                { 
                System.out.println("Yes"); 
                } 
                else 
                { 
                System.out.println("No"); 
                } 
            }

        }
        
    }
    
    
    static String swap(String pat, int i, int j){
        char ch;
        char[] array = pat.toCharArray();
        ch = array[i];
        array[i] = array[j];
        array[j] = ch;
        return String.valueOf(array);
    }
    
    
    static String permute(String pat,int low,int high){
        if(low == high)
            System.out.println(pat);
 
        int i;
        for(i = low; i<=high; i++){
            pat = swap(pat,low,i);
            permute(pat, low+1,high);
            pat = swap(pat,low,i);
        }
        return pat;
    }
    
    
}
