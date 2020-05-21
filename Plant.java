import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.io.*;

/**
 * Plant class represents various kinds of plants from Milkweed to Southern Golden Rod. 
 * The class contains a Latin name which a string which is the Latin name of the plant.
 * The color of the plant, which is a string, represents the colors the plant can come in.
 * Integers waterNeed/sunLighNeed represent how much water/light the plant need to survive.
 * Locaiton Pref, an int, represents where in the Garden Plot plants would like to be 
 * located. BloomTime and BloomTime str represent what season the plants are in currently
 * while the seasonImgStr representes different image URLS used to load in pictures of plants
 * from GardenPlant.txt GardenFlower.txt, and GardenTree.txt
 * <p>
 * @author Bradley Fusting
 *
 */
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
	//private String[] seasonImages;
	
	private String plantType;
	
	private ArrayList<String> animalsFed = new ArrayList();
	private ArrayList<String> compatiblePlants = new ArrayList();
	
	private String waterStr;
	private String sunStr;
	
	private static String[] waterStrArr = {"Low","Low/medium","Medium","Medium/High","High"};
	private static String[] sunStrArr = {"Completely Shaded","Mostly Shaded", "Partial Shade", "Sunny / Partial shade", "Completely Sunny"};
	
	
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
	
	/**
	 * A constructor for plant including an array of season images. Used to read in from text file and create new plant arrays.
	 * 
	 * @param name
	 * @param latinName
	 * @param color
	 * @param bloomTimeStr
	 * @param habit
	 * @param size
	 * @param waterNeed
	 * @param sunLightNeed
	 * @param soilMoisture
	 * @param animalsFedStr
	 * @param seasonsImgArr
	 */
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
		
		bloomTime = Seasons.valueOf(this.bloomTimeStr.toUpperCase());
		this.latinName = latinName;
		this.sunLightNeed = sunLightNeed;
		this.waterNeed = waterNeed;
		this.size = size;
		this.habit = habit;
		this.soilMoisture = soilMoisture;
		this.animalsFedStr = animalsFedStr;
		this.seasonsImgArr = seasonsImgArr;
		
		//Changing water and sun need integers to strings for user understanding
		for (int i=1; i<6; i++) {
			if (waterNeed == i) {
				this.waterStr = waterStrArr[i-1];
			}
			if (sunLightNeed == i) {
				this.sunStr = sunStrArr[i-1];
			}
		}	
	}
	/**
	 * Constructor for the Plant class. Initializes the characteristics and requirements for the plant
	 * and the arrays of Strings containing the urls for the images of the plant at different ages and in
	 * different seasons.
	 */
	/*public Plant(String name, int tileSize, String description, String color, int waterNeed, int sunLightNeed, double plantHeight, int locationPref,
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
	}*/
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
	
	/**
	 * To string method, returns the string based on which plant attributes are available for the plant
	 * 
	 * @return returningStr - the String listing all available plant attributes except name
	 */
	public String toString() {
		String returningStr = null;
		
		if (this.getSize() == 0) {
			if (this.getSoilMoisture().contentEquals("null")) {
				if (this.getAnimalsFedStr().equals("null")) {
					returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + 
							"Water need: " +waterStr + "\n" +  "Light Requirements: " +
			        		sunStr + "\n" ;
				} else {
					returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" +"Water need: " +waterStr + "\n" +  "Light Requirements: " +
			        		sunStr + "\n" +"Animals Fed: " + animalsFedStr + "\n";
				}
			}  else if (this.getAnimalsFedStr().equals("null")) {
				returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" +"Water need: " +waterStr + "\n" +  "Light Requirements: " +
		        		sunStr + "\n" +"Soil Moisture: " + soilMoisture + "\n" ;
			}
		} else if (animalsFedStr.contentEquals("null")){
			if (soilMoisture.contentEquals("null")) {
				returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + 
						"Height: " + size + " ft" +"\n" +"Water need: " +waterStr + "\n" +  "Light Requirements: " +
		        		sunStr + "\n" ;
			} else {
				returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + 
						"Height: " + size + " ft" + "\n" + "Water need: " +waterStr + "\n" +  "Light Requirements: " +
						sunStr + "\n" +"Soil Moisture: " + soilMoisture + "\n" ;
			}
		} else if (soilMoisture.contentEquals("null")) {
			returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + 
					"Height: " + size + " ft"+ "\n" +"Water need: " +waterStr + "\n" +  "Light Requirements: " +
	        		sunStr + "\n" +"Animals Fed: " + animalsFedStr + "\n";
		} else {
			returningStr= "Plant color: " + color + "\n" + "Bloom Time: " + bloomTime + "\n" + "Habit: " + habit + "\n" + 
				"Height: " + size + " ft"+ "\n" +"Water need: " +waterStr + "\n" +  "Light Requirements: " +
        		sunStr + "\n" +"Soil Moisture: " + soilMoisture + "\n" +"Animals Fed: " + animalsFedStr + "\n";
		}
		return returningStr;
	}
	
	/**
	 * Gets the maximum height of the plant
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Gets the required soil moisture of the plant
	 * 
	 * @return soilMoisture
	 */
	public String getSoilMoisture() {
		return soilMoisture;
	}
	
	/**
	 * Gets the list of animals the plant feeds/benefits
	 * 
	 * @return animalsFedStr;
	 */
	public String getAnimalsFedStr() {
		return animalsFedStr;
	}
	
	/**
	 * Gets the name of the plant (non-latin)
	 * 
	 * @return name
	 */
    public String getName() {
    	return name;
    }
    
    /**
     * Gets the Latin name of the plant
     * 
     * @return latinName
     */
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

	
	/*public String[] getSeasonImages() {
		return seasonImages;
	}*/

	/**
	 * Sets the String array containing the urls for the images of the plant in each season.
	 * 
	 * @param seasonImages an array of Strings containing the urls for the images of the
	 * plant in each season.
	 */
	/*public void setSeasonImages(String[] seasonImages) {
		this.seasonImages = seasonImages;
	}*/
	
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
	
	/**
	 * Returns the urls for the images of the plant in each season in a String array, in order 
	 * corresponding to the Seasons enum.
	 * 
	 * @return seasonsImgArr an array of Strings containing the urls for the images of the
	 * plant in each season.
	 */
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
	
	public static String[] getWaterStrArr() {
		return waterStrArr;
	}
	public static String[] getSunStrArr() {
		return sunStrArr;
	}
	
}//Plant
