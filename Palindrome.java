package lab11;
import static java.lang.Character.isLetter;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author ranwar.bscs16seecs
 */
public abstract class Palindrome implements Queue {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner( System.in );
        System.out.println("WELCOME TO PALINDROME CHECKER!");
        System.out.print("Enter your sentence here: ");
        String exp = input.nextLine();
        
        while( exp.isEmpty() ){
            System.out.print("Enter a VALID sentence here: ");
            exp = input.nextLine();
        }
        
        if( isPalindrome( exp.toLowerCase() ) ) //case sensitivity
            System.out.println( exp + " IS palindrome.");
        else
            System.out.println( exp + " IS NOT palindrome.");
    }
    
    public static boolean isPalindrome(String exp){
        Stack paliStack = new Stack();
        Queue paliQueue = new LinkedList();
        
        for(int i = 0; i < exp.length(); ++i){
            if( isLetter( exp.charAt(i) ) ){
                paliStack.push( exp.charAt(i) );
                paliQueue.add( exp.charAt(i) );
            }
        }   
        
        while(!paliStack.isEmpty() || !paliQueue.isEmpty()){
            if(paliStack.pop() !=  paliQueue.remove()) //if characters don't match, end
                break;
        }
        
        if( paliStack.isEmpty() && paliQueue.isEmpty() )
            return true;
        return false;
    }

}