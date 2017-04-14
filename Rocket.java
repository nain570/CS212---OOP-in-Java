/* Developed using Eclipse 
 Demonstrating working of a rocket
 using OOP structures.*/

import java.util.Timer; //for launch time
import java.util.TimerTask;

public abstract class Rocket {
    
	protected String name;
    protected String engine;
    protected String propellant;
    protected double fuel;
    
    Rocket(String name, String engine, String propellant, double fuel){
    	setName(name);
    	installEngine(engine);
    	installPropellant(propellant);
    	addFuel(fuel);
    }
    
    
    public String getEngine(){
        return this.engine;
    }
    
    public String getPropellant(){
        return this.propellant;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public double getFuel(){
    	return this.fuel;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public void installEngine(String engine){
    	System.out.println("\nInstalling engine...");
        this.engine = engine;
        wait(1);
        System.out.println(engine + " installed succesfully!");
    }
    
    public void installPropellant(String propellant){
    	System.out.println("\nInstalling propellant...");
        this.propellant = propellant;
        wait(1);
        System.out.println(propellant + " installed succesfully!");
    }
    
    public void addFuel(double fuel){
    	this.fuel = fuel;
    	System.out.println("\nFilling fuel tank...");
    	wait(1);
    	System.out.println(fuel + " lb fuel added succesfully!");
    }
    
    public void checkEngine(){
    	System.out.println("\nChecking engine...");
    	wait(1);
        if(getEngine().isEmpty()){
        	System.out.println("\nNO ENGINE FOUND, ABORT!!");
        	System.exit(0);
        }
        else
        	System.out.println("Engine is working properly, you are good to go!");
    }
   
    public void checkPropellant(){
    	System.out.println("\nChecking propellant...");
    	wait(1);
    	if(getPropellant().isEmpty()){
    		System.out.println("\nNO PROPELLANT FOUND, ABORT!!");
        	System.exit(0);
    	}
        else
        	System.out.println("Your propellant is working properly, you are good to go!");
    }
    
    public void checkFuel(){
    	System.out.println("\nChecking fuel...");
    	wait(1);
    	if(getFuel() == 0.0){
    		System.out.println("\nFUEL TANK IS EMPTY, ABORT!!");
        	System.exit(0);
    	}
        else
        	System.out.println("Your tank is full, you are good to go!");
    }
    
    public void checkStatus() throws InterruptedException{
    	checkEngine();
    	wait(1);
    	checkPropellant();
    	wait(1);
    	checkFuel();
    }
    
    private void wait(int count){
    	try {
    	    Thread.sleep(count * 1000);
    	} catch(InterruptedException ex) {
    	    Thread.currentThread().interrupt();
    	}
    }
    
    //extra variety
    private int interval = 5;
	private Timer timer = new Timer();
	
    public void launch() throws InterruptedException{
    	checkStatus();
    	System.out.println("\n " + name + " is ready to take off! Taking off in ");
    	timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println(setInterval() + 1  + " ... ");
            	}
        	}, 1000, 1000);
    	wait(interval + 1);
    	System.out.println("SHOOOOOOOOOOOOOOT!!");
    }
    private int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}


class Shuttle extends Rocket{
        
        private double payLoad;
        
        Shuttle(String name, String engine, String propellant, double fuel, double payLoad) throws InterruptedException{
           super(name, engine, propellant, fuel);
           setPayLoad( payLoad );
        }
 
        public double getPayLoad(){
            return this.payLoad;
        }
        
        public void setPayLoad( double payLoad) throws InterruptedException{
        	System.out.println("\nLoading.........");
        	this.payLoad = payLoad;
        	wait(1);
        	System.out.println(payLoad + "lb load added on the shuttle.");
        }
        
        public void checkPayLoad() throws InterruptedException{
        	System.out.println("\nChecking pay load...");
        	wait(1);
        	if( getFuel() < 24*payLoad){
        		System.out.println("\n24 pounds of fuel can carry 1 pound of pay load, your shuttle cannot shoot, ABORT.");
        		System.exit(0);
        	}
        	else
        		System.out.println("Perfect load!");
        }
        
        @Override
        public void checkStatus() throws InterruptedException{
        	super.checkStatus();
        	wait(1);
        	checkPayLoad();
        }
}


class Missile extends Rocket {
	
    private double explosives;
    private double tarLong;
    private double tarLat;
	
    Missile(String name, String engine, String propellant, double fuel, double explosives, double longitude, double lattitude) throws InterruptedException{
        super(name, engine, propellant, fuel);
        installExplosives( explosives );
        setTarget(longitude, lattitude);
    }
    
    public void setTarget(double longitude, double lattitude) throws InterruptedException{
    	this.tarLat = lattitude;
    	this.tarLong = longitude;
    	System.out.println("\nLocating target...");
    	wait(1);
    	System.out.println("Target Locked!");
    }
    
    public void installExplosives(double explosives) throws InterruptedException{
    	this.explosives = explosives;
    	System.out.println("\nAdding explosives...");
    	wait(1);
    	System.out.println("Explosives Loaded!");
    }
    
    public String getTarget(){
    	return tarLong + ", " + tarLat;
    }
    
    public double getExplosives(){
    	return explosives;
    }
    
    public void checkExplosives() throws InterruptedException{
    	System.out.println("\nChecking explosives...");
    	wait(1);
    	if( getExplosives() == 0.0){
    		System.out.println("\nNO EXPLOSIVES FOUND, ABORT!!");
    		System.exit(0);
    	}
    	else
    		System.out.println("Your Missile's got enough nukes!");
    }
    
    public void checkTarget() throws InterruptedException{
    	System.out.println("\nChecking target...");
    	wait(1);
    	if(tarLong != 0.0 && tarLat != 0.0 )
    		System.out.println("Target Locked!");
    	else{
    		System.out.println("\nNO TARGET FOUND, ABORT!!");
    		System.exit(0);
    	}
    }
    
    @Override
    public void checkStatus() throws InterruptedException{
    	super.checkStatus();
    	wait(1);
    	checkExplosives();
    	wait(1);
    	checkTarget();
    }
}
