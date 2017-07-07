import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import com.jaunt.component.Form;

public class NumberPlateRegex {

	public static void main(String[] args) throws JauntException {
		String REGEX = "^\\s*[a-zA-z]{1,4}\\s*[0-9]{3,4}\\s*$"; //regular expression
        String numbers[] = {"ICT LKI-12-1245", "IDL 2121", "LXH 1050", "ICT  LS 302 ISLAMABAD",
        					"IDL 1740", "AAK-760 ICT-ISLAMABAD", "ICT NE 410 ISLAMABAD", "ZV - 195",
        					"b13486894", "345abc", "sfa13saf", "_09313_alk", "2jlk0a", "jajlk 02",
        					"1234 ABC", "LWD -16-8754", "ZS -  319", "STH 374"};
        String data = "";
        
        Pattern pattern, p; //a pattern of compiled regex
        Matcher matcher, m; //helps in matching the regex
        
        for(String number : numbers){ //for every number
            //fixing
        	System.out.println("Input is " + number + "\n");
        	m = Pattern.compile("[-][0-9]{2}[-]|[-]").matcher( number );
            number = m.replaceAll(" ");
            
            p = Pattern.compile("ICT|Islamabad|Sindh|Punjab|Govt of Sindh|ICT-Islamabad|ISLAMABAD|Govt of Pakistan");
            m = p.matcher(  number );
            number = m.replaceAll("");
            
            
            pattern = Pattern.compile(REGEX); //compile regex
            matcher = pattern.matcher(number); //create its matcher
            
            long start = System.currentTimeMillis();
            
            number= number.replaceAll("( +)"," ").trim();
            if (matcher.matches()) { //print if valid
	            System.out.println("Searching for " + number + " ...\n"); //match the input with regex
	            data = find( number );
            }
            else {
            	System.out.println("Invalid!\n\n");
            	continue;
            }
            
            if(!data.isEmpty())
            	   System.out.println( data ); //match the input with regex
            else
            	   System.out.println("No record found"); //match the input with regex
            
            long end = System.currentTimeMillis();
            
            System.out.println("TIme: " + (end - start)/1000.0 +" seconds.\n\n");
        }
	}
	
	public static String find(String number) throws JauntException {
	
		StringBuffer string = new StringBuffer();
		
		UserAgent userAgent = new UserAgent();
		userAgent.visit("http://www.mtmis.excise-punjab.gov.pk/");
		
		Form form = userAgent.doc.getForm(1);
		
		form.setTextField("vhlno", number);
		
		form.submit();
		try {
			Element table = userAgent.doc.findFirst("<table>");
			Elements trs = table.findEach("<tr>"); //get all rows
			
			for(Element tr: trs){ //in each row
				Elements tds = tr.findEach("<td>"); //get all cells
				
				for(Element td: tds){ // in each cell
					String text = td.getText();
					string.append( String.format("%" + -22 + "s", text ) );//get text
				}
				
				string.append("\n");
			}
			
			return string.toString();
		} catch(com.jaunt.NotFound es) {
			return "";
		}
	}
}
