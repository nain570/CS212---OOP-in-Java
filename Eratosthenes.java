/*********************************
Title: Eratosthenes Prime Numbers
Usage: Uses basic knowledge of
        arrays to find prime
        numbers within a range
*********************************
Technology: NetBeans IDE 8.2 */

import java.util.Arrays; //for array functionalities

public class PrimeGenerator { //a class of different methods to print Prime Numbers
    
    private int limit; //end limit of prime numbers to be printed
    
    //default constructor
    public PrimeGenerator(){
        limit = 1000;
    }
    //arguemnt constructor
    public PrimeGenerator(int limit){
        this.limit =  limit;
    }
    
    public void eratosthenes(){ //ERATOSTHENES method of printing Prime Numebers
        boolean[] primeList = new boolean[limit]; //boolean array of said elements
        Arrays.fill(primeList, true); //initializing all true
        
        for(int i = 2; i < primeList.length ; ++i){
            for(int j = 2*i; j < primeList.length; j+=i)
                primeList[j] = false; //assigning false to multiples of each number
            
            if(primeList[i]) //if true i.e., multiple of no number (prime)
                System.out.println(i);
        }
    }
}
