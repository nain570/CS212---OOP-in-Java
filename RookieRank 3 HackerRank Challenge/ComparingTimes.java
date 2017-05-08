import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ComparingTimes {

    static String timeCompare(String t1, String t2){
        String result = " ";
        
        //dealing with number 12
        if(t1.substring(0, 2).equals("12"))
            t1 = "00" + t1.substring(2);
        if(t2.substring(0, 2).equals("12"))
            t2 = "00" + t2.substring(2);
        //comparison
        if(t1.contains("AM") && t2.contains("PM"))
            result =  "First";
        else if(t1.contains("PM") && t2.contains("AM"))
            result =  "Second";
        else if( Integer.parseInt(t1.substring(0,2)) < Integer.parseInt(t2.substring(0,2)) )
            result = "First";
        else if( Integer.parseInt(t1.substring(0,2)) > Integer.parseInt(t2.substring(0,2)) )
                result = "Second";
        else if( Integer.parseInt(t1.substring(3,5)) < Integer.parseInt(t2.substring(3,5)) )
            result = "First";
        else if( Integer.parseInt(t1.substring(3,5)) > Integer.parseInt(t2.substring(3,5)) )
            result = "Second";
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String t1 = in.next();
            String t2 = in.next();
            String result = timeCompare(t1, t2);
            System.out.println(result);
        }
    }
}
