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
	
	public Date getBloomTime() {
		return bloomTime;
	}


	public void setBloomTime(Date bloomTime) {
		this.bloomTime = bloomTime;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getWaterNeed() {
		return waterNeed;
	}


	public void setWaterNeed(int waterNeed) {
		this.waterNeed = waterNeed;
	}


	public int getSunLightNeeded() {
		return sunLightNeeded;
	}


	public void setSunLightNeeded(int sunLightNeeded) {
		this.sunLightNeeded = sunLightNeeded;
	}


	public int getLocationPref() {
		return locationPref;
	}


	public void setLocationPref(int locationPref) {
		this.locationPref = locationPref;
	}


	public double getPlantHeight() {
		return plantHeight;
	}


	public void setPlantHeight(double plantHeight) {
		this.plantHeight = plantHeight;
	}


	public boolean isProvideShade() {
		return provideShade;
	}


	public void setProvideShade(boolean provideShade) {
		this.provideShade = provideShade;
	}


	public String[] getSeasonImages() {
		return seasonImages;
	}


	public void setSeasonImages(String[] seasonImages) {
		this.seasonImages = seasonImages;
	}


	public String[] getAgeImages() {
		return ageImages;
	}


	public void setAgeImages(String[] ageImages) {
		this.ageImages = ageImages;
	}


	public String[] getPlantType() {
		return plantType;
	}


	public void setPlantType(String[] plantType) {
		this.plantType = plantType;
	}


	public String[] getAnimlasFed() {
		return animlasFed;
	}


	public void setAnimlasFed(String[] animlasFed) {
		this.animlasFed = animlasFed;
	}


	
}


