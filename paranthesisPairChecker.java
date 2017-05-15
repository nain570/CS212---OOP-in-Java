import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author ranwar.bscs16seecs
 */
public class paranthesisPairChecker {
    public static void main(String[] args){
        Scanner input = new Scanner( System.in );
        System.out.println("WELCOME TO PARANTHESIS CHECKER!");
        //getting input
        System.out.print("Enter your expression here: ");
        String exp = input.nextLine();
        
        while( exp.isEmpty() ){
            System.out.print("Enter a VALID expression here: ");
            exp = input.nextLine();
        }
        
        if( isBalanced( exp ) )
            System.out.println( exp + " has BALANCED paranthesis.");
        else
            System.out.println( exp + " has UNBALANCED paranthesis.");
    }
    
    public static boolean isBalanced(String exp){
        Stack paranStack = new Stack();
        //following the pre algo
        for(int i = 0; i < exp.length(); ++i){
            if( exp.charAt(i) == '(' )
                paranStack.push( exp.charAt(i) );
            else if(exp.charAt(i) == ')')
                paranStack.pop();
        }   
        
        if( paranStack.isEmpty() )
            return true;
        return false;
    }
}
