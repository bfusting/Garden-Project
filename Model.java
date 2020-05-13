import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: 011
*  Lab Section: 031L
*  TA: Vineeth Gutta
*  Due: May 18th, 2020 (5/18/20)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * Where all the raw data of the program goes from the GardenPlot which holds 
 * GardenTiles which have attributes such as sunlight received and soil wetness. Furthermore
 * the GardenTiles hold an AddOn or Plant with their own attributes. 
 * 
 * @author Malachi Parks
 * 
 */

public class Model implements Serializable{
	private static final long serialVersionUID = 1558153956L;
	// Holds all the data for our plants
	
	private GardenPlot userPlot;
	private ArrayList<GardenPlot> altPlots;
	private ArrayList<Plant> flowerArr;
	private ArrayList<Plant> shrubArr;
	private ArrayList<Plant> treeArr;
	private ArrayList<Plant> underGrowthArr;
	private ArrayList<AddOn> sceneryArr;
	private ArrayList<Plant> allPlants;
	
	// Used to hold other "removed" plants while filtering
	private ArrayList<Plant> otherColors;
	private ArrayList<Plant> otherSeasons;
	private ArrayList<Plant> otherLight;
	private ArrayList<Plant> otherWater;
	
	
	private String userTemplate;
	// Prefs given by user
	private String userPrefColor;
	private Seasons userPrefSeason;
	private int userPrefLight;
	private int userPrefWater;
	private int prefsSet;
	// Width and length given by user passed in by preferences
	private int userLength;
	private int userWidth;
	
	// Range of values to filter by
	private int lowBound;
	private int highBound;
	
	// Constatns string reps to replace magic nums
	private final String flower = "Flower";
	private final String shrub = "Shrub";
	private final String tree = "Tree";
	private final String undergrowth = "UnderGrowth";
	
	/**
	 * Constructor where the ArrayLists are initialized for space and
	 * a new GardenPlot is created
	 * 
	 * @see GardenPlot
	 */
	public Model() {
		userPlot = null;
		userTemplate = "";
		prefsSet = 0;
		
		createArrs();
		
		// Creating temp Plants for Bradley to use in methods, remove later
		
		
		//These Plants have the incorrect constructor
		/*
		Plant purpleConeFlower = new Plant("Purple Cone Flower", 1, "cone flower", 
				"purple", 0, 0, 0, 0, "Autumn", false, null, null, "Flower", null, null);
		
		Plant goldenRod = new Plant("Golden Rod", "Solidago Sempervirens", "Yellow", "Autumn", "", 0, 3, 5, "Moist", new ArrayList<String>());
		
		Plant sugarMaple = new Plant("Sugar Maple", 4, "Maple Tree", "Yellow", 3, 0,
				0, 0, "Summer", true, null, null, "Tree", null, null);
		
		Plant sweetFern = new Plant("Sweet Fern", 1, "Fern Variant", "White",
				3, 2, 3.0, 0, "Spring", false, null, null, "Shrub", null, null);

		Plant milkWeed = new Plant("Milkweed", 1, "Common Milkweed", "Orange", 4, 2, 
				2.00, 0, "Summer", false, null, null, "UnderGrowth", null, null);
		
		*/
/*		
		Plant fillaree = new Plant("Fillaree", "eraniaceae Erodium texanum", "Red", 
				"Spring", "", 0, 1, 5, "Dry", new ArrayList<String>());
		
		Plant starGrass = new Plant("Star Grass", "Liliaceae Aletris aurea", "Yellow",
				"Summer", "", 0, 3, 3, "", new ArrayList<String>());
		
		Plant narrowLeafOnion = new Plant("Narrowleaf Onion","Allium amplectens", "White", 
				"Spring", "", 0, 3, 3, "", new ArrayList<String>());
		
		Plant pearThorn = new Plant("Pear Thorn", "Crataegus calpodenron", "White",
				"Summer", "", 0, 3, 3, "", new ArrayList<String>());
		
		Plant whiteSnakeroot = new Plant("White Snakeroot", "Ageratina Altissim", "White",
				"Summer", "", 0, 1, 3, "", new ArrayList<String>());
		
		// Trees
		Plant narrowleafCottonwood = new Plant("Narrowleaf Cottonwood", "Populus Angustifloia", "White",
				"Spring", "", 0, 5, 3, "", new ArrayList<String>());
		
		Plant boxElder = new Plant("Box Elder", "Acer negundo", "Yellow",
				"Spring", "", 0, 3, 5, "", new ArrayList<String>());
		
		Plant blackMaple = new Plant("Black Maple", "Acer nigrum", "Yellow",
				"Spring", "", 0, 3, 3, "", new ArrayList<String>());
		
		Plant juneBush = new Plant("Junebush", "Amelanchier canadensis", "White",
				"Spring", "", 0, 3, 4, "", new ArrayList<String>());
		
		Plant whiteBirch = new Plant("White Birch", "Betula poulifolia", "Green",
				"Spring", "", 0, 1, 3, "", new ArrayList<String>());
		
		Plant cigarTree = new Plant("Cigar Tree"," Amelanchier canadensis", "White", 
				"Summer", "", 0, 1, 1, "", new ArrayList<String>());
		
		
		//Shrubs
		Plant seasideAlder = new Plant("Seaside Alder", "Alnus Maritima", "Yellow",
				"Summer","", 0, 5, 3, "", new ArrayList<String>());
		
		Plant redChokeberry = new Plant("Red Chokeberry", "Aronia arbutifolia", "White",
				"Spring", "", 0, 5, 5, "", new ArrayList<String>());
		
		Plant sweetShrub = new Plant("Sweet Shrub", "Calycanthus floridus", "Red",
				"Spring", "", 0, 3, 3, "Moist", new ArrayList<String>());
		
		Plant newJerseyTea = new Plant("New Jersey Tea", "Ceanothus americanus", "White",
				"Spring", "", 0, 1, 2, "", new ArrayList<String>());
		
		Plant americanHazelnut = new Plant("American Hazelnut", "Corylus americana", "White",
				"Spring", "", 0, 3, 2, "", new ArrayList<String>());
		
		Plant redWillow = new Plant("Red Willow", "Cornus amomum", "White",
				"Spring", "", 0, 5, 3, "", new ArrayList<String>());
		
		Plant maidenhairFern = new Plant("Maidenhair Fern", "Adiantum pedatum", "",
				"", "", 0, 3, 3, "", new ArrayList<String>());
		
		Plant blackstemSpleenwort = new Plant("Blackstem Spleenwort", "Asplenium Resiliens", "",
				"", "", 0, 3, 2, "", new ArrayList<String>());
				
		flowerArr = new ArrayList<Plant>();
	//	flowerArr.add(purpleConeFlower);
	//	flowerArr.add(goldenRod);
		flowerArr.add(pearThorn);
		flowerArr.add(whiteSnakeroot);
		flowerArr.add(starGrass);
		flowerArr.add(narrowLeafOnion);
		flowerArr.add(fillaree);
		
		shrubArr = new ArrayList<Plant>();
		//shrubArr.add(sweetFern);
		shrubArr.add(seasideAlder);
		shrubArr.add(redChokeberry);
		shrubArr.add(newJerseyTea);
		shrubArr.add(americanHazelnut);
		shrubArr.add(redWillow);
	
		
		treeArr = new ArrayList<Plant>();
		//treeArr.add(sugarMaple);
		treeArr.add(cigarTree);
		treeArr.add(whiteBirch);
		treeArr.add(boxElder);
		treeArr.add(blackMaple);
		treeArr.add(juneBush);
		treeArr.add(narrowleafCottonwood);
		
		underGrowthArr = new ArrayList<Plant>();
	//	underGrowthArr.add(milkWeed);
		underGrowthArr.add(maidenhairFern);
		underGrowthArr.add(blackstemSpleenwort);
*/		
		// holds all scenery items like dirt to branchs
		sceneryArr = new ArrayList<AddOn>();
		AddOn bench = new AddOn("Bench",1,"A bench to sit on....duh");
		sceneryArr.add(bench);
		
		// holds all plants in program ---> Used on creation only
		allPlants = new ArrayList<Plant>();
		
		//Used for filtering methods to hold other vars
		otherColors = new ArrayList<Plant>();
		otherSeasons = new ArrayList<Plant>();
		otherLight = new ArrayList<Plant>();
		otherWater = new ArrayList<Plant>();
		
		// Prefs passed in by user
		userPrefColor = "";
		userPrefSeason = null;
		userPrefLight = 0;
		userPrefWater = 0;
		
		// user defined length and width
		userLength = 0;
		userWidth = 0;
		
		// Range of values to filter functions thats it
		lowBound = 0;
		highBound = 0;
	}//Model()
	
	private void createArrs() {

	    Scanner input;
	    String[] textFileStrings = {"GardenPlant.txt","GardenTree.txt"};
		try {
			for(int i=0;i<textFileStrings.length;i++) {
				input = new Scanner(new File(textFileStrings[i]));
			    input.useDelimiter("\n");
			    
			  
			    Plant[] plants = new Plant[0];
			    Plant[] trees = new Plant[0];
			    
			    while(input.hasNext()) {
			        String name = input.next();
			        String latinName = input.next();
			        String color = input.next();
			        String bloomTime = input.next();
			        String habit = input.next();
			        int size = input.nextInt();
			        int waterNeed = input.nextInt();
			        int sunlightNeed = input.nextInt();
			        String soilMoisture = input.next();
			        String animalsFedStr = input.next();
			        
		        	Plant newPlant = new Plant(name, latinName, color, bloomTime, habit, size, waterNeed, sunlightNeed, soilMoisture, animalsFedStr);
			        if (i==0) {
			        	plants = addPlant(plants, newPlant);
			        } else if (i==1) {
			        	trees = addPlant(trees, newPlant);
			        }
			    }

			    for (Plant plant : plants) {
			        System.out.println(plant);
			    }
			    for (Plant tree : trees) {
			    	System.out.println(tree);
			    }
			}

		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
    private static Plant[] addPlant(Plant[] plantsArr, Plant plantToAdd) {
	    Plant[] newPlants = new Plant[plantsArr.length + 1];
	    System.arraycopy(plantsArr, 0, newPlants, 0, plantsArr.length);
	    newPlants[newPlants.length - 1] = plantToAdd;

	    return newPlants;
	}
	
	/**
	 * Used to generate alternate GardenPlots for the Final View
	 * since they are generated. Calls the GardenPlot constructor
	 * then fills it by copying original array over. From there will 
	 * autofill the rest of the spaces
	 */
	public void createGardenPlotAlts() {
		System.out.println("Creating alternate gardens for final view");
		
		GardenPlot gP1 = new GardenPlot();
		gP1.setLayout(userPlot.getLayout());
		gP1.fillEmpty();
		
		GardenPlot gP2 = new GardenPlot();
		gP2.setLayout(userPlot.getLayout());
		gP2.fillEmpty();
		
		GardenPlot gP3 = new GardenPlot();
		gP3.setLayout(userPlot.getLayout());
		gP3.fillEmpty();
		
		this.altPlots.add(gP1);
		this.altPlots.add(gP2);
		this.altPlots.add(gP3);
	}
	
	/**
	 * Runs only once once the preferences page is complete transmitting the information
	 * such as color and light pref to model then filters by them and shifts 
	 * the preferred plants up to the front
	 */
	public void updateArrs() {
		// sets up the array by filter to appropriate type then filtering to all of
		// of flowerArr then
		setFlowerArr(filterByType(flowerArr,flower));
		flowerArr.addAll(filterByColor(flowerArr,userPrefColor));
		flowerArr.addAll(filterByBloomTime(flowerArr,userPrefSeason));
		flowerArr.addAll(filterByLight(flowerArr,userPrefLight));
		flowerArr.addAll(filterByWater(flowerArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into flowerArr
		flowerArr.addAll(otherColors);
		flowerArr.addAll(otherSeasons);
		flowerArr.addAll(otherLight);
		flowerArr.addAll(otherWater);
		
		// clearing other arrays
		clearOthers();
		
		// sets up the array by filter to appropriate type then filtering to all of
		// of shrubArr
		setShrubArr(filterByType(shrubArr,shrub));
		shrubArr.addAll(filterByColor(shrubArr,userPrefColor));
		shrubArr.addAll(filterByBloomTime(shrubArr,userPrefSeason));
		shrubArr.addAll(filterByLight(shrubArr,userPrefLight));
		shrubArr.addAll(filterByWater(shrubArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into shrubArr
		shrubArr.addAll(otherColors);
		shrubArr.addAll(otherSeasons);
		shrubArr.addAll(otherLight);
		shrubArr.addAll(otherWater);
		
		// clearing other arrays
		clearOthers();
		
		// sets up the array by filter to appropriate type then filtering to all of
		// of treeArr
		setTreeArr(filterByType(treeArr,tree));
		treeArr.addAll(filterByColor(treeArr,userPrefColor));
		treeArr.addAll(filterByBloomTime(treeArr,userPrefSeason));
		treeArr.addAll(filterByLight(treeArr,userPrefLight));
		treeArr.addAll(filterByWater(treeArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into treeArr
		treeArr.addAll(otherColors);
		treeArr.addAll(otherSeasons);
		treeArr.addAll(otherLight);
		treeArr.addAll(otherWater);
		
		// clearing other arrays
		clearOthers();
		
		// sets up the array by filter to appropriate type then filtering to all of
		// of underGrowth Arr
		setUnderGrowthArr((filterByType(underGrowthArr,undergrowth)));
		underGrowthArr.addAll(filterByColor(underGrowthArr,userPrefColor));
		underGrowthArr.addAll(filterByBloomTime(underGrowthArr,userPrefSeason));
		underGrowthArr.addAll(filterByLight(underGrowthArr,userPrefLight));
		underGrowthArr.addAll(filterByWater(underGrowthArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into underGrowthArr
		underGrowthArr.addAll(otherColors);
		underGrowthArr.addAll(otherSeasons);
		underGrowthArr.addAll(otherLight);
		underGrowthArr.addAll(otherWater);
		
		// clearing other arrays
		clearOthers();
		
	}//updateArrs
	
	
	
	////////////////////////////		GETTERS UNDERNEATH			////////////////////////////
	
	/**
	 * Returns a GardenPlot
	 * <p>
	 * Getter for attribute userPlot
	 * 
	 * @return userPlot the GardenPlot the user created
	 */
	public GardenPlot getUserPlot() {
		return userPlot;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for flowerArr List
	 *
	 * @return flowerArr Plnat List of flowers 
	 */
	public ArrayList<Plant> getFlowerArr() {
		return flowerArr;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for Shrub Array List
	 *
	 * @return shrubArr Shrub List of what the user is currently seeing
	 */
	public ArrayList<Plant> getShrubArr() {
		return shrubArr;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for Tree Array List
	 *
	 * @return TreeArr Tree List of what the user is currently seeing
	 */
	public ArrayList<Plant> getTreeArr() {
		return treeArr;
	}
	
	/**
	 *Returns a arrayList of Plants
	 *<p>
	 *getter for UnderGrowth Array List
	 *
	 * @return UnderGrowth UnderGrowth List of what the user is currently seeing
	 */
	public ArrayList<Plant> getUnderGrowth(){
		return underGrowthArr;
	}
	
	/**
	 * Returns the altPlots attribute from model, which will be used
	 * to add new gardenPlots to the Array
	 * <p>
	 * Returns the altPlots attribute
	 * 
	 * @return altPlots used in the final view generation
	 */
	public ArrayList<GardenPlot> getAltPlots(){
		return altPlots;
	}
	
	/**
	 * Returns the sceneryArr attribute from model, which will be used
	 * to add Addons to the Array
	 * <p>
	 * Returns the sceneryArr attribute
	 * 
	 * @return Holds items such as benchs, path, etc
	 */
	public ArrayList<AddOn> getSceneryArr(){
		return sceneryArr;
	}
	
	/**
	 * Returns the allPlants attribute from model which will be used to 
	 * hold all the plants the program has.
	 * <p>
	 * Getter for the allPlants attribute
	 * 
	 * @return allPlants is an arrayList holding all the plants in the program
	 */
	//public ArrayList<Plant> getAllPlants(){
	public ArrayList<Plant> getAllPlants(){
		return allPlants;
	}
	
	/**
	 * Returns the userPrefColor attribute
	 * <p>
	 * Getter for userPrefColor attribute
	 * @return userPrefColor is the color passed by preferences
	 */
	public String getUserPrefColor() {
		return userPrefColor;
	}
	
	public Seasons getUserPrefSeason() {
		return userPrefSeason;
	}
	
	public int getUserPrefLight() {
		return userPrefLight;
	}
	
	public int getUserPrefWater() {
		return userPrefWater;
	}
	
	public int getUserLength() {
		return userLength;
	}
	
	public int getUserWidth() {
		return userWidth;
	}
	
	////////////////////////////		SETTERS			////////////////////////////
	
	/**
	 * Takes in ArrayList of type AddOn and sets the SelectionArray to the new array
	 * <p>
	 * Used as a setter for the selectionArr
	 * 
	 * @param a new ArrayList used to set selectionArr
	 */
	public void setFlowerArr(ArrayList<Plant> a) {
		flowerArr = a;
	}
	
	/**
	 * Takes in ArrayList of type Plant and sets the ShrubArray to the new array
	 * <p>
	 * Used as a setter for the ShrubArr
	 * 
	 * @param a new ArrayList used to set ShrubArr
	 */
	public void setShrubArr(ArrayList<Plant> a) {
		shrubArr = a;
	}
	
	/**
	 * Takes in ArrayList of type Plant and sets the TreeArray to the new array
	 * <p>
	 * Used as a setter for the TreeArr
	 * 
	 * @param a new ArrayList used to set TreeArr
	 */
	public void setTreeArr(ArrayList<Plant> a) {
		treeArr = a;
	}
	
	/**
	 * Takes in ArrayList of type Plant and sets the UnderGrowthArray to the new array
	 * <p>
	 * Used as a setter for the UnderGrowthArr
	 * 
	 * @param a new ArrayList used to set UnderGrowthArr
	 */
	public void setUnderGrowthArr(ArrayList<Plant> a) {
		underGrowthArr = a;
	}
	
	/**
	 * Takes in a GardenPlot p and sets userPlot to the new plot.
	 * <p>
	 * Setter for userPlot
	 * 
	 * @param p new Gardenplot to set userPlot to
	 */
	public void setUserPlot(GardenPlot p) {
		userPlot = p;
	}
	
	/**
	 * Takes in a ArrayList and sets scenery to the new list.
	 * <p>
	 * Setter for sceneryArr
	 * 
	 * @param a is a new arrayList of addons to take in
	 */
	public void setSceneryArr(ArrayList<AddOn> a) {
		sceneryArr = a;
	}
	
	public void setUserPrefColor(String newColor) {
		if (newColor!="") {
			if (userPrefColor.equals("")) {
				prefsSet++;
			}
			userPrefColor = newColor;
			System.out.println("nc");
		}
		/*if (userPrefColor.equals("") && newColor!="") {
			prefsSet++;
			userPrefColor = newColor;
		}*/
		
	}
	
	public void setUserPrefSeason(Seasons newSeason) {
		if (newSeason!=null) {
			if (userPrefSeason==null) {
				prefsSet++;
			}
			userPrefSeason=newSeason;
 		}
		/*if (userPrefSeason==null && newSeason!=null) {
			prefsSet++;
			userPrefSeason = newSeason;
		}*/
		
	}
	
	public void setUserPrefLight(int newLight) {
		if (newLight!=0) {
			if (userPrefLight==0) {prefsSet++;}
			userPrefLight=newLight;
		}
		/*if (userPrefLight==0 && newLight!=0) {
			prefsSet++;
			userPrefLight = newLight;
		}*/
		
	}
	
	public void setUserPrefWater(int newWater) {
		if (newWater!=0) {
			
			if(userPrefWater==0) {
				prefsSet++;
			}
			userPrefWater=newWater;
		}
		
		/*if (userPrefWater == 0 && newWater!=0) {
			prefsSet++;
			userPrefWater = newWater;
		}*/
		
	}
	
	void setUserLength(int newLength) {
		if (newLength!=0) {
			if (userLength==0) { prefsSet++;}
			userLength = newLength;
		}
		/*if (userLength==0 && newLength!=0) {
			prefsSet++;
			userLength = newLength;
		}*/
		
	}
	
	/**
	 * Sets the property userWidth, ignoring if the default width has been passed in.
	 * @param newWidth
	 */
	void setUserWidth(int newWidth) {
		if (newWidth!=0) {
			if (userWidth==0) {
				prefsSet++;
			}
			userWidth = newWidth;
		}
		/*if (userWidth==0 && newWidth!=0) {
			prefsSet++;
			userWidth = newWidth;
		}*/
		
	}
	
	//////////////////// Comparators ///////////////////////////////////
	
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
	 * Takes in an ArrayList a, which represents the arrayList being sorted while
	 * the color param is the usersColor pref attribute which was obtained from
	 * the preferences of view passing in userinput.
	 * <p>
	 * Used to filter an array of plants by color. First iterates of the array and 
	 * adds all the plants that don't match the otherColorArr then filters
	 * using a stream, iterating over using a lambda then returning true items to the
	 * stream.
	 * 
	 * @param a is the arrayList to be sorted
	 * @param color the users color preferenced passed in by Controller from Preferences
	 * @return a filtered ArrayList by Plant color
	 */
	public ArrayList<Plant> filterByColor(ArrayList<Plant> a, String color){
		//Iterate over list and if doesn't match color add to the otherColors Arr via getter
		for(Plant p: a) {
			if(!p.getColor().equals(color)) {
				otherColors.add(p);
			}
		}
		// user getter for OtherColors Instead!
		otherColors.sort(new SortbyColor());
		
		// filters the arrayList taken in, makes copy so a is not disturbed
		ArrayList<Plant> userColorPlants = new ArrayList<Plant>();
		userColorPlants.addAll(a);
		//streams the plants, filters by color, then adds them back to list
		userColorPlants.stream().filter(p -> p.getColor().equals(color))
		.collect(Collectors.toList());
		return userColorPlants;
	}//filterByColor
	
	/**
	 * Takes in an ArrayList a, which represents the arrayList being sorted while
	 * the season param is the usersSeasons pref attribute which was obtained from
	 * the preferences of view passing in userinput.
	 * <p>
	 * Used to filter an array of plants by season enum. First iterates of the array and 
	 * adds all the plants that don't match the otherSeasonArr then filters
	 * using a stream, iterating over using a lambda then returning true items to the
	 * stream.
	 * 
	 * @param a is the arrayList to be sorted
	 * @param season the users bloomTime preferenced passed in by Controller from Preferences
	 * @return a filtered ArrayList by Plant arrayList
	 */
	public ArrayList<Plant> filterByBloomTime(ArrayList<Plant> a, Seasons season){
		//Iterate over list and if doesn't match bloom add to the otherBloomTime Arr via getter
		for(Plant p: a) {
			if(!p.getBloomTime().equals(season)) {
				otherSeasons.add(p);
			}
		}
		// user getter for otherSeasons Instead!
		otherSeasons.sort(new SortbyBloomTime());
		
		ArrayList<Plant> userBloomPlants = new ArrayList<Plant>();
		userBloomPlants.addAll(a);
		//streams the plants, filters by BloomTime, then adds them back to list
		userBloomPlants.stream().filter(p -> p.getBloomTime().equals(season))
		.collect(Collectors.toList());
		return userBloomPlants;
	}//fliterByBloomTime
	
	/**
	 * Takes in an ArrayList a, which represents the arrayList being sorted while
	 * the waterReq param is the usersWaterPref attribute which was obtained from
	 * the preferences of view passing in userinput.
	 * <p>
	 * Used to filter an array of plants by waterReq. First takes in the waterReq
	 * into a switchStatement and creates a high and low bound to add to when filtering.
	 * Then adds all the plants that don't meet the waterRange to the otherWater Arr
	 * finally sorts the array by the range and returns it
	 * 
	 * @param a is the arrayList to be sorted
	 * @param waterReq is the amount of water a plant needs
	 * @return a filtered ArrayList by Plant waterReq
	 */
	public ArrayList<Plant> filterByWater(ArrayList<Plant> a, int waterReq){
		// switch statement to setup range (if 0 range is 0-2, if five range is 3-5)
		switch(waterReq) {
			case 0: lowBound = 0; highBound = 2; break;
			case 5: lowBound = 3; highBound = 5; break;
			default: lowBound = waterReq-1;highBound = waterReq+1;
		}//switch
		
		//Iterate over list and if water int isn't
		//range add to the otherWater Arr via getter
		for(Plant p: a) {
			if(!(p.getWaterNeed() >= lowBound) && !(p.getWaterNeed() <= highBound)) {
				otherWater.add(p);
			}
		}
		// user getter for otherWater Instead!
		otherWater.sort(new SortbyWaterNeed());
	
		ArrayList<Plant> userWaterPlants = new ArrayList<Plant>();
		userWaterPlants.addAll(a);
		//streams the plants, filters by BloomTime, then adds them back to list
		userWaterPlants.stream().filter(p -> p.getWaterNeed() >= lowBound
				&& p.getWaterNeed() <= highBound).collect(Collectors.toList());
		return userWaterPlants;
	}//filterByWater
	
	/**
	 * Takes in an ArrayList a, which represents the arrayList being sorted while
	 * the lightRqq param is the usersLightPref attribute which was obtained from
	 * the preferences of view passing in userinput.
	 * <p>
	 * Used to filter an array of plants by waterReq. First takes in the lightReq
	 * into a switchStatement and creates a high and low bound to add to when filtering.
	 * Then adds all the plants that don't meet the lightRange to the otherLight Arr
	 * finally sorts the array by the range and returns it
	 * 
	 * @param a is the arrayList to be sorted
	 * @param lightReq is the amount of light a plant needs
	 * @return a filtered ArrayList by Plant waterReq
	 */
	public ArrayList<Plant> filterByLight(ArrayList<Plant> a, int lightReq){
		// switch statement to setup range (if 0 range is 0-2, if five range is 3-5)
		switch(lightReq) {
			case 0: lowBound = 0; highBound = 2; break;
			case 5: lowBound = 3; highBound = 5; break;
			default: lowBound = lightReq-1;highBound = lightReq+1;
		}//switch
		
		//Iterate over list and if light int isn't
		//range add to the otherLight Arr via getter
		for(Plant p: a) {
			if(!(p.getSunLightNeed() >= lowBound) && !(p.getSunLightNeed() <= highBound)) {
				otherLight.add(p);
			}
		}
		// user getter for otherWater Instead!
		otherLight.sort(new SortbyLightNeed());
	
		ArrayList<Plant> userLightPlants = new ArrayList<Plant>();
		userLightPlants.addAll(a);
		//streams the plants, filters by BloomTime, then adds them back to list
		userLightPlants.stream().filter(p -> p.getSunLightNeed() >= lowBound
				&& p.getSunLightNeed() <= highBound).collect(Collectors.toList());
		return userLightPlants;
	}//filterByLight
	
	/**
	 * Takes in an ArrayList a, which represents the arrayList being sorted while
	 * the type param which is the kind of plant it is (Shrub, Tree, Flower, UnderGrowth)
	 * Called in each of hte update methods to set up the inital arrays
	 * <p>
	 * Used to filter an array of plants by their types. Creates a new array list
	 * checks if the streram of that array is plant type is equal to the type passed in
	 * if so added into array
	 * 
	 * @param a is the arrayList to be sorted
	 * @param type is the category the plant is in (Shrub, Tree, Flower, UnderGrowth)
	 * @return a filtered ArrayList of types
	 * @see Model#updateFlowerArr()
	 * @see Model#updateSceneryArr()
	 * @see Model#updateShrubArr()
	 * @see Model#updateTreeArr()
	 * @see Model#updateUnderGrowthArr()
	 */
	public ArrayList<Plant> filterByType(ArrayList<Plant> a, String type){
		ArrayList<Plant> typeArr = new ArrayList<Plant>();
		typeArr.addAll(a);
		//streams the plants, filters by BloomTime, then adds them back to list
		typeArr.stream().filter(p -> p.getPlantType().equals(type)).collect(Collectors.toList());
		return typeArr;
	}//filterByType
	
	/**
	 * Used to empty the otherArrays such as light/water/seasons and color between each
	 * filter so no wrong types are in each list
	 */
	public void clearOthers() {
		otherColors.clear();
		otherSeasons.clear();
		otherLight.clear();
		otherWater.clear();
	}
	
	/**
	 * Sets the property userTemplate, a string representing the template shape chosen by the user that
	 * the userPlot will be.
	 * @param shape A string representing the template shape chosen by the user.
	 */
	public void setUserTemplate(String shape) {
		userTemplate = shape;
	}
	
	/**
	 * Returns the property userTemplate, a string representing the template shape chosen by the user.
	 * @return
	 */
	public String getUserTemplate() {
		return userTemplate;
	}
	
	/**
	 * Sets the property userPlot to a new GardenPlot with the user specified template, length and width.
	 */
	public void createUserPlot() {
		userPlot = new GardenPlot(userTemplate,userLength,userWidth);
	}
	
	/**
	 * Returns the value of property prefSet.
	 * 
	 * @return An int, the number of preferences that have been modified from their default value.
	 */
	public int getPrefsSet() {
		return prefsSet;
	}
	
	public boolean necessaryPrefsSet() {
		return !(userPrefColor.equals("") || userPrefSeason==null || userPrefLight==0 || userPrefWater==0 );
	}
	// then getters and setters for new attributes
}//Modeld