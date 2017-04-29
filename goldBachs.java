package goldBachs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class goldBachs {
    
    //array lists for prime numbers and their pairs
    private List<Integer> primes = new ArrayList<Integer>();
    private List<List<Integer>> pairs = new ArrayList<List<Integer>>(); //to make "pairs"
    private int number; //number to apply Gold Bachs Problem on
    
    //constructor
    public goldBachs(int number){
        this.number = number;
    }
    
    // CALL THIS METHOD TO BEGIN OPERATION
    public void initiate(){
        getPrimes();
        findingPairs();
        display();
    }
    
    private void getPrimes(){
        //finding prime numbers
        for(int i = 2; i < number; i++){
            int counter = 0; // used in finding prime numbers
            for(int j = 2; j <= i/2; j++)
                if( i%j==0 )
                    counter++;
            if(counter == 0)
                primes.add(i);
        }
    }
    // Main Logic of the Whole program, solution to the problem
    private void findingPairs(){
        for(int i = 0; i < primes.size() ; i++){
            for(int j = 0; j < primes.size(); j++){
                //these variables don't require to call .get() function over and again, also improve readability
                int at_i = primes.get(i), at_j = primes.get(j);
                if( at_i + at_j == number && !pairs.contains(at_i) && !pairs.contains(at_j)){
                    pairs.add( new ArrayList<Integer>(Arrays.asList(at_i, at_j)) ); //making pairs
                }		
            }		
        }
    }
    /* Method to display GoldBach's Conjucture */
    public void display(){
        System.out.printf("GoldBachs Conjecture for number %d: \n", this.number);
        for(int i = 0; i < pairs.size(); i++){ //each row in pair list
          for(int j = 0; j < pairs.get(i).size() ; j+=2){ //each elemnt of each row
              System.out.println( pairs.get(i).get(j) + ", " + pairs.get(i).get(j + 1) );
          }
          System.out.println();
      }
    }
}