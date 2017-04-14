/*********************************
Title: Crytography Technique
Usage: Uses basic OOP concepts
        to help encrypt - decrypt
        data.
*********************************
Technology: NetBeans IDE 8.2 
*********************************
NOTE:   This program uses GUI,
        kindly use IDE to test.*/

import javax.swing.JOptionPane;

public class Cryptography {
    
    private int message;
    private int[] array = new int[4]; //temporary array
    private int choice;
    private int code;
    
    public void choose(){
        /* Code Credit: Oracle Documentation */
        Object[] options = {"Encryption", "Decryption"};
        choice = JOptionPane.showOptionDialog(null, //no parent frame
        "What would you like to do?", //message to display
        "Enter your choice", //title of box
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[0]);

        String input; //buffer

        if(choice == 1 || choice == 0){
            do {
                input = JOptionPane.showInputDialog("Enter a 4-digit positive number here: ");
                //CC: https://goo.gl/Ks2jr1
                message = Integer.parseInt( (input != null && !input.isEmpty() && input.matches("[0-9]+")) ? input : "0" );
                if(message == 0){
                    JOptionPane.showMessageDialog(null, "Invalid input! Close the program", "Program Termintion", JOptionPane.ERROR_MESSAGE);
                    System.exit(0); //terminate if no input is given
                }                
            } while(input.length() != 4);
        }
        else {
            JOptionPane.showMessageDialog(null, "Closing the program...", "Program Termintion", JOptionPane.ERROR_MESSAGE);
             System.exit(0); //terminate if nothing is selected
        }

        if(choice == 0)
            encrypt();
        else if(choice == 1)
            decrypt();
        
    }    
    private void encrypt(){
        //adding 7
        for(int i = 3; i >= 0; --i){
            array[i] = message % 10;
            array[i] = ( array[i] + 7 ) % 10;
            message /= 10;
        }
        prepareOutput();
    }
    
    private void decrypt(){        
        //decryption
        for(int i = 3; i >= 0; --i){
            array[i] = message % 10;
            array[i] = ( array[i] + 3 ) % 10;
            message /= 10;
        }
        prepareOutput();
    }
    
    private void prepareOutput(){ //does the swapping and forms a number
        //swapping
        int tmp;
        for(int j = 0; j < 2; j++){
            tmp = array[j];
            array[j] = array[j+2];
            array[j+2] = tmp;
        }
        
        //a complete number
        for(int k = 0; k < 4; k++)
            code += array[k]*Math.pow(10, 3 - k);
    }
    
    public int getCode(){
        String output;
        output = String.format("Your output is %04d.", code);
        JOptionPane.showMessageDialog(null, output);
        return code;
    }
}
