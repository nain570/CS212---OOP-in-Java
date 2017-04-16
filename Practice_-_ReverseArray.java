/*
  Reversing a String without using a buffer String or
  other temporary variables.
  Built own logic.
*/

import java.util.Scanner; //for inputs


public class Reverse {

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        
        //getting input String
        System.out.print( "Enter the string here: " );
        //getting new line as StringBuilder
        StringBuilder message = new StringBuilder( input.nextLine() );
        
        //Logic: Use character-as-integer arithmetic and swap the characters using addition and subtraction.
        //This will not require any new variable.
        //x = x + y
        //y = x - y
        //x = x - y
        for(int i = 0; i < message.length()/2; ++i){
            message.setCharAt(i, (char)( message.charAt(i)  +  message.charAt( message.length() - 1 - i) ));
            message.setCharAt( message.length() - 1 - i, (char)( message.charAt(i)  -  message.charAt( message.length() - 1 - i) ));
            message.setCharAt(i, (char)( message.charAt(i)  -  message.charAt( message.length() - 1 - i) ));
        }
        System.out.println(message);
    }
}
