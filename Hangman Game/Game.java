/* A game class, can be modified in many. I made it very very simple for time being, and
   for the sake of OOP structure. It doesn't do much! */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener {
    
    //variables
    JFrame welcome;
    JPanel credentials, instructions;
    JTextField getName = new JTextField(20);
    JTextArea description;
    JLabel nameText, buttonText;
    ImageIcon letsgo = createImageIcon("letsgo.png");
    JButton button;
    String name;
    
    //constructor
    public Game(){
        
        button = new JButton("", letsgo);
        button.addActionListener(this);
       
        description = new JTextArea("Hangman is a word guessing game for two or more players." +
                "One player (computer) thinks of a word, phrase or sentence and the other tries to guess it by suggesting letters or numbers, within a certain number of guesses.\n" +
                "The word to guess is represented by a row of dashes, representing each letter of the word. In most variants, proper nouns, such as names, places, and brands, are not allowed.\n" + 
                "If the guessing player suggests a letter which occurs in the word, the other player writes it in all its correct positions.\n" + 
                "If the suggested letter or number does not occur in the word, the other player draws one element of a hanged man stick figure as a tally mark.\n");
        description.setFont(new Font("Georgia", Font.PLAIN, 12));
        description.setEnabled(false);

        //setting up the frame and controls
        welcome = new JFrame("Welcome to Hangman Game!");
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //setting up panels
        instructions = new JPanel();
        credentials = new JPanel();

        //labels
        nameText = new JLabel("Your name: ",JLabel.CENTER);
        buttonText = new JLabel("Seems good? ",JLabel.CENTER);
        
        //populating panels panels
        instructions.add(description);
        credentials.add(nameText);
        credentials.add(getName);
        credentials.add(buttonText);
        credentials.add(button);
        
        //adding panels
        welcome.add(instructions, BorderLayout.NORTH);
        welcome.add(credentials, BorderLayout.CENTER);
        
        //showing
        welcome.pack();
        welcome.setVisible(true);
    }
    
    //event handling
    @Override
    public void actionPerformed(ActionEvent e) {
        name = getName.getText(); //getting input
        welcome.setVisible(false); //you can't see me!
        welcome.dispose(); //Destroy the JFrame object
        //create a player
        Player player = new Player(name);
        //create the player's game
        Hangman hangmanGame = new Hangman(player);
        //start the freaking game!
        hangmanGame.start();
    }
    
    // CREDIT: docs.oracle.com
    /** Returns an ImageIcon, or null if the path was invalid.
     * @param path
     * @return  */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
