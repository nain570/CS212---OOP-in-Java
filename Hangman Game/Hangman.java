package hangmangame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Hangman{
    private String[] dictionary = {"square","sharp","moon","wet","ghost","ice","jump",
        "cast","wise","smile","hope","book","smoke","laugh","love","school",
        "naughty","fruit","tour","trouble","hook", "signal", "anger", "science"};
    private String word;
    private JFrame frame;
    private JPanel topPanel, guessPanel, playerPanel, inputPanel;
    private JLabel guessLabel, blanks, inputLabel, playerLabel;
    private JTextField input;
    private static String text;
    private int numGuesses = 5;
    private Player player;
    private ActionListener listener;
    
    public Hangman(Player player){
        
        setPlayer(player);
        
        //create and set properties of frame
        frame = new JFrame("Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,400));
        
        //input field
        input = new JTextField(2);
        
        //create and set properties of panels
        topPanel = new JPanel();
        guessPanel = new JPanel();
        inputPanel = new JPanel();
        playerPanel = new JPanel();
        
        //create and set properties of labels
        inputLabel = new JLabel("Input ",JLabel.CENTER);
        guessLabel = new JLabel("Guesses Remaining = " + numGuesses,JLabel.CENTER);
        blanks = new JLabel("",JLabel.CENTER);
        playerLabel = new JLabel("Player: " + player.getName());
       
        //add labels to panels
        topPanel.add(blanks);
        guessPanel.add(guessLabel);
        inputPanel.add(inputLabel);
        inputPanel.add(input);
        playerPanel.add(playerLabel, JPanel.CENTER_ALIGNMENT);
        
        //add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(guessPanel, BorderLayout.WEST);
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(playerPanel, BorderLayout.SOUTH);
        
        //visibilty
        frame.setVisible(true);
    }//constructor
    
    
    public void start(){
        //random hidden word
        word = dictionary[(int)(Math.random() * dictionary.length)];
        
        //create no. of blanks equal to the texts in word
        blanks.setText( String.format("%0" + word.length() + "d", 0).replace("0","__ ") );
        
        input.addActionListener ( new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text = ((JTextField)e.getSource()).getText();//get user input
            input.setText("");//reset textfield for next guess
            if (!word.contains(text)) {//wrong button pressed
                numGuesses--;
                guessLabel.setText("Guesses Remaining = " + numGuesses);
                if(numGuesses == 0)
                    lost();//user lost
            } else{ //right decision!
                checkGuess();
                if (!(new String(blanks.getText()).contains("__"))) //done with quessing
                    win();
            }
        }
        } );
    }
    
    public void win(){
        //if no blanks left

        Object[] options = {"Try Again", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, //no parent frame
        "You have won! Press Try Again to try again.", //message to display
        "Congratulations!", //title of box
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[0]);

        if(choice == 0)
            playAgain();
        else if (choice == 1)
            System.exit(0); //cancel
    }
    
    public void checkGuess(){
        //if correct guess
        StringBuffer array = new StringBuffer(blanks.getText()); //mutable
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == text.charAt(0)){
                array.setCharAt(3 * i, ' ');
                array.setCharAt( 3 * i + 1, text.charAt(0) );
            }
        }
        blanks.setText( array.toString() );
    }
    public void lost(){
        Object[] options = {"Try Again", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, //no parent frame
        "You have hanged the poor man! Try Again to save him next time.", //message to display
        "Shaaaaaaaaaamee!", //title of box
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[0]);

        if(choice == 0)
            playAgain();
        else if (choice == 1)
            System.exit(0); //cancel
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    
    //start over
    public void playAgain(){
        //dispose the current game
        frame.dispose();
        //start new hangman game
        new Hangman(player).start();
    }
}//class end