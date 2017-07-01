import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPlateRegex {
    
    
    public static void main( String args[] ){
        
        String REGEX = "^\\s*[a-zA-z]{1,4}\\s*[-]*[0-9]{0,2}\\s*[-]*[0-9]{3,4}\\s*$"; //regular expression
        String numbers[] = {"ICT LKI-12-1245", "N864 152", "AB05 CD", "APF--5452 Punjab", "ABC123", "EKD 182", "ABC 123", "ABC 1234", "ABC1234", "he12467", "b13486894", "345abc", "sfa13saf", "_09313_alk", "2jlk0a", "jajlk 02", "1234 ABC", "abcde 1234"};
        
        Pattern pattern; //a pattern of compiled regex
        Matcher matcher; //helps in matching the regex

        for(String number : numbers){ //for every number
            //fixing
            Pattern p = Pattern.compile("ICT|Islamabad|Sindh|Punjab");
            Matcher m = p.matcher(  number );
            number = m.replaceAll("");
            
            pattern = Pattern.compile(REGEX); //compile regex
            matcher = pattern.matcher(number); //create its matcher
            System.out.println(number + " : " + matcher.matches()); //match the input with regex
        }
   }
}
