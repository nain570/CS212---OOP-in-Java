import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnitConverter implements ActionListener {
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField input;
    JLabel fromLabel, toLabel, selection;
    JButton convertTemp;
    JComboBox source;
    
    public UnitConverter() {
        //Create and set up the window.
        converterFrame = new JFrame("Conversion");
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converterFrame.setSize(new Dimension(300, 100));
        //Create and set up the panel.
        converterPanel = new JPanel(new GridLayout(3, 2));
        //Add the widgets.
        addWidgets();
        //Set the default button.
        converterFrame.getRootPane().setDefaultButton(convertTemp);
        //Add the panel to the window.
        converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);
        //Display the window.
        //converterFrame.pack();
        converterFrame.setVisible(true);
    }
    /**
    * Create and add the widgets.
    */
    private void addWidgets() {
        //Create widgets.
        String[] conversions ={ "Celsius to Fahrenheit",
                                "Celsius to Kelvin",
                                "Kilograms to Pounds", 
                                "Radians to Degrees", 
                                "Meters to Feet" };
        JComboBox convoList = new JComboBox(conversions);
    
        selection = new JLabel("Select conversion here: ", SwingConstants.LEFT);
        
        input = new JTextField(2);
        //default
        fromLabel = new JLabel("Celsius", SwingConstants.LEFT);
        convertTemp = new JButton("Convert");
        toLabel = new JLabel("Fahrenheit", SwingConstants.LEFT);
        //Listen to events from the Convert button.
        convertTemp.addActionListener( this);
        //Add the widgets to the container.
        converterPanel.add(selection);
        converterPanel.add(convoList);
        converterPanel.add(input);
        converterPanel.add(fromLabel);
        converterPanel.add(convertTemp);
        converterPanel.add(toLabel);
        fromLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        toLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        convoList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //getting selcted converstion
                source = (JComboBox)event.getSource();
                String name = (String)source.getSelectedItem();
                String[] segments1 = name.split(" to ");
                //changing labels
                fromLabel.setText(segments1[0]);
                toLabel.setText(segments1[1]);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        double answer = 0.0; //converted answer
        if(event.getSource() == convertTemp){
            switch( source.getSelectedIndex() ){
                case 0: //celsius to fahrenheit
                    answer = Double.parseDouble( input.getText() ) * 1.8 + 32;
                    break;
                case 1: //celsius to kelvin
                    answer = Double.parseDouble( input.getText() ) + 273.15;
                    break;
                case 2: //kilograms to pound
                    answer = Double.parseDouble( input.getText() ) * 2.20462;
                    break;
                case 3: //radians to degree
                    answer = Double.parseDouble( input.getText() ) * 180 / Math.PI;
                    break;
                case 4: //meters to feet
                    answer = Double.parseDouble( input.getText() ) * 3.28084;
                    break;
            }
        }
        //updating label with answer
        toLabel.setText ( answer + " " + toLabel.getText() );  	
    }
    
    		
    public static void main(String[] args) {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        UnitConverter converter = new UnitConverter();
    }
}
