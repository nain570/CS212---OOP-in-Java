// A simple Player Class, could contain player score, stats and other info as well
// For time being, simplest!
public class Player {
    String name;
    
    //default constructor
    public Player(){
        this.name = "Alex";
    }
		
		//another constructor
    public Player(String name){
        setName(name);
    }
    
    //setters / getters
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
