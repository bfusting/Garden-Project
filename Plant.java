import java.util.ArrayList;
import java.util.Date;
import java.util.Date;
import java.util.*;


public class Plant extends AddOn {

	private String color;
	private int waterNeed;
	private int sunLightNeed;
	private double plantHeight;
	private int locationPref;
	private Date bloomTime;
	private boolean provideShade;
	
	private String[] ageImages;
	private String[] seasonImages;
	
	private String plantType;
	
	private ArrayList<String> animalsFed = new ArrayList();
	private ArrayList<String> compatiblePlants = new ArrayList();
	
	/**
	 * Constructor for the Plant class. Initializes the characteristics and requirements for the plant
	 * and the arrays of Strings containing the urls for the images of the plant at different ages and in
	 * different seasons.
	 */
	public void Plant(String color, int waterNeed, int sunLightNeed, double plantHeight, int locationPref,
			Date bloomTime, boolean provideShade, String[] ageImages, String[] season, String plantType, 
			ArrayList<String> animalsFed, ArrayList<String> compatiblePlants) {
		
		this.color = color;
		this.waterNeed = waterNeed;
		this.sunLightNeed = sunLightNeed;
		this.plantHeight = plantHeight;
		this.locationPref = locationPref;
		this.bloomTime = bloomTime;
		this.provideShade = provideShade;
		
		this.ageImages = ageImages;
		this.seasonImages = seasonImages;
		this.plantType = plantType;
		this.animalsFed = animalsFed;
		this.compatiblePlants = compatiblePlants;
		
		
	}
	

	/**
	 * Gets the String describing the color of the plant.
	 * 
	 * @return color the color of the plant
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the String describing the color of the plant.
	 * 
	 * @param color the color of the plant
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the int representing the water level requirements of the plant.
	 * 
	 * @return waterNeed the water level that the plant needs
	 */
	public int getWaterNeed() {
		return waterNeed;
	}

	/**
	 * Sets the int representing the water level requirements of the plant.
	 * 
	 * @param waterNeed the water level that the plant needs
	 */
	public void setWaterNeed(int waterNeed) {
		this.waterNeed = waterNeed;
	}

	/**
	 * Gets the int representing the sunlight level requirements of the plant.
	 * 
	 * @return sunLightNeed the sunlight level that the plant needs
	 */
	public int getSunLightNeed() {
		return sunLightNeed;
	}

	/**
	 * Sets the int representing the sunlight level requirements of the plant.
	 * 
	 * @param sunLightNeed the sunlight level that the plant needs
	 */
	public void setSunLightNeed(int sunLightNeed) {
		this.sunLightNeed = sunLightNeed;
	}

	/**
	 * Gets the double representing the height of the plant.
	 * @return plantHeight the height of the plant
	 */
	public double getPlantHeight() {
		return plantHeight;
	}

	/**
	 * Sets the double representing the height of the plant.
	 * @param plantHeight the height of the plant
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
 * Returns the bloom period of the plant as a Date object.
 * @return bloomTime the bloom period of the plant
 */
	public Date getBloomTime() {
		return bloomTime;
	}
	
	/**
	 * Sets the bloom period of the plant as a Date object.
	 * @param bloomTime the bloom period of the plant
	 */
	public void setBloomTime(Date bloomTime) {
		this.bloomTime = bloomTime;
	}

	/**
	 * Indicates whether or not the plant requires shade.
	 * @return provideShade true if the plant requires shade, false otherwise
	 */
	public boolean isProvideShade() {
		return provideShade;
	}

	/**
	 * Sets the indicator for whether or not the plant requires shade as a boolean.
	 * @param provideShade true if the plant requires shade, false otherwise
	 */
	public void setProvideShade(boolean provideShade) {
		this.provideShade = provideShade;
	}

	/**
	 * Returns the urls for the images of the plant in each season in a String array.
	 * season
	 * @return seasonImages an array of Strings containing the urls for the images of the
	 * plant in each season.
	 */
	public String[] getSeasonImages() {
		return seasonImages;
	}

	/**
	 * Sets the String array containing the urls for the images of the plant in each season.
	 * 
	 * @param seasonImages an array of Strings containing the urls for the images of the
	 * plant in each season.
	 */
	public void setSeasonImages(String[] seasonImages) {
		this.seasonImages = seasonImages;
	}
	
	/**
	 * Returns the urls for the images of the plant at different growth stages in a String array.
	 * 
	 * @return ageImages an array of Strings containing the urls for the images of the plant
	 * at different growth stages.
	 */
	public String[] getAgeImages() {
		return ageImages;
	}

	/**
	 * Sets the String array containing the urls for the images of the plant at different growth
	 * stages.
	 * 
	 * @param ageImages an array of Strings containing the urls for the images of the plant at different
	 * growth stages
	 */
	public void setAgeImages(String[] ageImages) {
		this.ageImages = ageImages;
	}

	/**
	 * Returns the String representing the classification of the plant.
	 * 
	 * @return plantType the classification of the plant
	 */
	public String getPlantType() {
		return plantType;
	}

	/**
	 * Sets the classification of the plant as a String.
	 * 
	 * @param plantType the classification of the plant
	 */
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	/**
	 * Returns an ArrayList of Strings representing the animal populations that
	 * the plant will feed.
	 * 
	 * @return animalsFed the ArrayList<String>, each String representing an animal population
	 * fed by the plant 
	 */
	public ArrayList<String> getAnimalsFed() {
		return animalsFed;
	}

	/**
	 * Sets the ArrayList of Strings representing the animal populations that the plant
	 * will feed.
	 * 
	 * @param animalsFed the ArrayList<String>, each String representing an animal population
	 * fed by the plant 
	 */
	public void setAnimalsFed(ArrayList<String> animalsFed) {
		this.animalsFed = animalsFed;
	}

	/**
	 * Returns the ArrayList of String identifiers for the other plants compatible with this plant.
	 * 
	 * @return compatiblePlants ArrayList<String> of names of plants compatible to this plant
	 */
	public ArrayList<String> getCompatiblePlants() {
		return compatiblePlants;
	}

	/**
	 * Sets the ArrayList of String identifiers for the other plants compatible with this plant.
	 * @param ArrayList<String> of names of plants compatible to this plant
	 */
	public void setCompatiblePlants(ArrayList<String> enemyPlants) {
		this.compatiblePlants = enemyPlants;
	}

	
}
