import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.io.*;


public class Plant extends AddOn{
	private static final long serialVersionUID = 998480235L;
	
	private String latinName;
	private String color;
	private int waterNeed;
	private int sunLightNeed;
	private double plantHeight;
	private int locationPref;
	
	private Seasons bloomTime;
	private String bloomTimeStr;
	
	private boolean provideShade;
	
	private String waterNeedStr;
	private String sunlightNeedStr;
	private String sizeStr;
	
	private String springImgStr;
	private String summerImgStr;
	private String autumnImgStr;
	private String winterImgStr;
	private String[] seasonsImgArr;
	
	private int size;
	private String habit;
	private String soilMoisture;
	private String animalsFedStr;
	
	private String[] ageImages;
	private String[] seasonImages;
	
	private String plantType;
	
	private ArrayList<String> animalsFed = new ArrayList();
	private ArrayList<String> compatiblePlants = new ArrayList();
	
	
	public Plant(String name, String latinName, String color, Seasons bloomTime,
			String habit, int size, int waterNeed, int sunLightNeed, String soilMoisture, ArrayList<String> animalsFed) {
		this.name = name;
		this.color = color;
		this.bloomTime = bloomTime;
		this.latinName = latinName;
		this.sunLightNeed = sunLightNeed;
		this.waterNeed = waterNeed;
		this.size = size;
		this.habit = habit;
		this.soilMoisture = soilMoisture;
		this.animalsFed = animalsFed;
		
	}
	
	public Plant(String name, String latinName, String color, String bloomTimeStr,
			String habit, int size, int waterNeed, int sunLightNeed, String soilMoisture, String animalsFedStr, String[] seasonsImgArr) {
		this.name = name;
		this.color = color;
		this.bloomTimeStr = bloomTimeStr;
		
		if (bloomTimeStr.toLowerCase().equals("fall")) {
			this.bloomTimeStr="Autumn";
		}
		
		//temporarily setting null values
		if (color.equals("null")|| color==null) {
			this.color = "Red";
		}
		if (this.bloomTimeStr.equals("null") || bloomTimeStr==null) {
			this.bloomTimeStr="Spring";
		}
		
		//
		bloomTime = Seasons.valueOf(this.bloomTimeStr.toUpperCase());
		this.latinName = latinName;
		this.sunLightNeed = sunLightNeed;
		this.waterNeed = waterNeed;
		this.size = size;
		this.habit = habit;
		this.soilMoisture = soilMoisture;
		this.animalsFedStr = animalsFedStr;
		this.seasonsImgArr = seasonsImgArr;
/*		this.springImgStr = spring;
		this.summerImgStr = summer;
		this.autumnImgStr = autumn;
		this.winterImgStr = winter;
*/		
	}
	/**
	 * Constructor for the Plant class. Initializes the characteristics and requirements for the plant
	 * and the arrays of Strings containing the urls for the images of the plant at different ages and in
	 * different seasons.
	 */
	public Plant(String name, int tileSize, String description, String color, int waterNeed, int sunLightNeed, double plantHeight, int locationPref,
			Seasons bloomTime, boolean provideShade, String[] ageImages, String[] season, String plantType, 
			ArrayList<String> animalsFed, ArrayList<String> compatiblePlants) {
		super(name,tileSize,description);
		
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
	
	public Plant() {
		
	}
	

	private static Plant[] addPlant(Plant[] plants, Plant plantToAdd) {
	    Plant[] newPlants = new Plant[plants.length + 1];
	    System.arraycopy(plants, 0, newPlants, 0, plants.length);
	    newPlants[newPlants.length - 1] = plantToAdd;

	    return newPlants;
	}
	
/*    public String toString() {
        return "Name: " + name + "\n" + "Latin Name: " + latinName + "\n" + "Plant color: " + color + "\n" + "Bloom Time String: "+ bloomTimeStr+ "\n"+
    "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + "Height: " + size + "\n" +"Water need: " +waterNeed + "\n" +  "Light Requirements: " +
        		sunLightNeed + "\n" +"Soil Moisture: " + soilMoisture + "\n" +"Animals Fed: " + animalsFedStr + "\n"+ "Seasons String Img Array: " + 
        		seasonsImgArr[0]+", " + seasonsImgArr[1]+", " +seasonsImgArr[2]+", " +seasonsImgArr[3]+", " + "\n" + "\n";
    }
	
*/
	public String toString() {
		return "Plant color: " + color + "\n" + 
    "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + "Height: " + size + "\n" +"Water need: " +waterNeed + "\n" +  "Light Requirements: " +
        		sunLightNeed + "\n" +"Soil Moisture: " + soilMoisture + "\n" +"Animals Fed: " + animalsFedStr + "\n" + "\n";
	}
	
    public String getName() {
    	return name;
    }
    
    public String getLatinName() {
    	return latinName;
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
	public Seasons getBloomTime() {
		return bloomTime;
	}
	
	/**
	 * Sets the bloom period of the plant as a Date object.
	 * @param bloomTime the bloom period of the plant
	 */
	public void setBloomTime(Seasons bloomTime) {
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
	
	/**
	 * Comparator class used to sort a collections of Plants by their type
	 * attribute of their type by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyType implements Comparator<Plant> 
	{ 
	    // Used for sorting in ascending order of 
	    // plant type ("Shrub", "UnderGrowth", "Tree", ...)
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getPlantType().compareTo(b.getPlantType()); 
	    } 
	} 
	
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their waterRequirement by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyWaterNeed implements Comparator<Plant> 
	{ 
	    // Used for sorting water requirement to live
		// in ascending order
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getWaterNeed() - b.getWaterNeed(); 
	    } 
	} 
	
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their lightReq by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyLightNeed implements Comparator<Plant> 
	{ 
	    // Used for sorting Light requirement to live
		// in ascending order
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getSunLightNeed() - b.getSunLightNeed(); 
	    } 
	} 
	  
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their Color by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyColor implements Comparator<Plant> 
	{ 
	    // Used for sorting Color requirement to live
		// in lexical order
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getColor().compareTo(b.getColor()); 
	    } 
	} 
	
	/**
	 * Comparator class used to sort a collections of Plants by their 
	 * attribute of their bloomTime by using the Comparator interface
	 * 
	 * @author Malachi Parks
	 *
	 */
	class SortbyBloomTime implements Comparator<Plant> 
	{ 
	    // Used for sorting BloomTime where the enum
		// is based off of string values
	    public int compare(Plant a, Plant b) 
	    { 
	        return a.getBloomTime().compareTo(b.getBloomTime()); 
	    } 
	}
    public String[] getSeasonsImgArr() {
	return seasonsImgArr;
    }
    
    public String getHabit() {
	return habit;
    }

	@Override
	public boolean equals(Plant p) {
		return this.latinName.equals(p.latinName);
	}
	
	@Override
	public int hashCode() {
		return (this.latinName.length() * this.waterNeed) % this.sunLightNeed;
	}
	
}//Plant
