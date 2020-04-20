import java.util.Date;

public class Plant extends AddOn{
	String color;
	int waterNeed;
	Date bloomTime = new Date();
	int sunLightNeeded;
	double plantHeight;
	boolean provideShade;
	String[] seasonImages;
	String[] ageImages;
	String[] plantType;
	String[] animlasFed;

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


