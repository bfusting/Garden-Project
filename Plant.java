import java.util.ArrayList;
import java.util.*;

public class Plant extends AddOn {

	String color;
	int waterNeed;
	int sunLightNeed;
	double plantHeight;
	int locationPref;
	Date bloomTime;
	boolean provideShade;
	
	String[] ageImages;
	String[] seasonImages;
	
	String plantType;
	
	ArrayList<String> animalsFed = new ArrayList();
	ArrayList<String> enemyPlant = new ArrayList();
	
	/**
	 * 
	 */
	public void Plant() {
		
	}
	

	/**
	 * 
	 * @return
	 * returns color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets Color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 
	 * @return
	 * returns waterNeed
	 */
	public int getWaterNeed() {
		return waterNeed;
	}

	/**
	 * Sets waterNeed
	 * @param waterNeed
	 */
	public void setWaterNeed(int waterNeed) {
		this.waterNeed = waterNeed;
	}

	/**
	 * 
	 * @return
	 * returns sunLightNeed
	 */
	public int getSunLightNeed() {
		return sunLightNeed;
	}

	/**
	 * Sets sunLightNeed
	 * @param sunLightNeed
	 */
	public void setSunLightNeed(int sunLightNeed) {
		this.sunLightNeed = sunLightNeed;
	}

	/**
	 * 
	 * @return
	 * returns plantHeight
	 */
	public double getPlantHeight() {
		return plantHeight;
	}

	/**
	 * sets plantHeight
	 * @param plantHeight
	 */
	public void setPlantHeight(double plantHeight) {
		this.plantHeight = plantHeight;
	}

	/**
	 * returns locationPref
	 * @return
	 */
	public int getLocationPref() {
		return locationPref;
	}

	/**
	 * sets locationPref
	 * @param locationPref
	 */
	public void setLocationPref(int locationPref) {
		this.locationPref = locationPref;
	}
/**
 * 
 * @return
 * returns bloomTime
 */
	public Date getBloomTime() {
		return bloomTime;
	}
	
	/**
	 * Sets bloomTime
	 * @param bloomTime
	 */
	public void setBloomTime(Date bloomTime) {
		this.bloomTime = bloomTime;
	}

	/**
	 * 
	 * @return
	 * returns provideShade;
	 */
	public boolean isProvideShade() {
		return provideShade;
	}

	/**
	 * sets provideShade;
	 * @param provideShade
	 */
	public void setProvideShade(boolean provideShade) {
		this.provideShade = provideShade;
	}

	/**
	 * 
	 * @return
	 * returns seasonImages
	 */
	public String[] getSeasonImages() {
		return seasonImages;
	}

	/**
	 * sets seasonImages
	 * @param seasonImages
	 */
	public void setSeasonImages(String[] seasonImages) {
		this.seasonImages = seasonImages;
	}
	
	/**
	 * 
	 * @return
	 * returns ageImages
	 */
	public String[] getAgeImages() {
		return ageImages;
	}

	/**
	 * sets ageImages
	 * @param ageImages
	 */
	public void setAgeImages(String[] ageImages) {
		this.ageImages = ageImages;
	}

	/**
	 * 
	 * @return
	 * returns plantType
	 */
	public String getPlantType() {
		return plantType;
	}

	/**
	 * sets plantType
	 * @param plantType
	 */
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	/**
	 * 
	 * @return
	 * returns animalsFed
	 */
	public ArrayList<String> getAnimalsFed() {
		return animalsFed;
	}

	/**
	 * sets animalsFed
	 * @param animalsFed
	 */
	public void setAnimalsFed(ArrayList<String> animalsFed) {
		this.animalsFed = animalsFed;
	}

	/**
	 * 
	 * @return
	 * returns enemyPlant
	 */
	public ArrayList<String> getEnemyPlant() {
		return enemyPlant;
	}

	/**
	 * sets enemyPlant
	 * @param enemyPlant
	 */
	public void setEnemyPlant(ArrayList<String> enemyPlant) {
		this.enemyPlant = enemyPlant;
	}

	
}
