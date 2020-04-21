import java.util.Date;
/**
 * 
 * @author Bradley
 *
 */

public class Plant extends AddOn{
	
	Date bloomTime = new Date();
	
	String color;
	
	/**
	 * int waterNeed, int sunLightNeed
	 * 
	 * on a scale of 1 - 5 (or whatever we decide) for the need of water and light
	 */
	int waterNeed;
	int sunLightNeeded;
	int locationPref;
	
	double plantHeight;
	/**
	 * boolean provideShade
	 * 
	 * whether or not the plant requires shade
	 */
	boolean provideShade;
	
	
	String[] seasonImages;
	String[] ageImages;
	String[] plantType;
	String[] animlasFed;

	
	/**
	 * Constructor 
	 * 
	 * @param color
	 * @param wN
	 * @param sLN
	 * @param ph
	 * @param pS
	 */
	public void Plant(String  color, int wN, int sLN, double ph, boolean pS){
		

		this.color = color;
		this.waterNeed = wN;
		this.sunLightNeeded = sLN;
		this.plantHeight = ph;
		this.provideShade = pS;
		
	}


	public void Plant(){
		
	}
}


