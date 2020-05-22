import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
	private ArrayList<AddOn> sceneryArr;
	private ArrayList<AddOn> pathwaysArr;
	private ArrayList<Plant> allPlants;
	
	// Used to hold other "removed" plants while filtering
	private ArrayList<Plant> otherColors;
	private ArrayList<Plant> otherSeasons;
	private ArrayList<Plant> otherLight;
	private ArrayList<Plant> otherWater;
	
	// represents all the plants used in the garden
	private static HashSet<Plant> usedPlants = new HashSet<Plant>();
	
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
		
		
		flowerArr = new ArrayList<Plant>();
		shrubArr= new ArrayList<Plant>();
		treeArr=new ArrayList<Plant>();
		
		
		// holds all scenery items like dirt to branchs
		pathwaysArr= new ArrayList<AddOn>();
		sceneryArr = new ArrayList<AddOn>();
		//AddOn bench = new AddOn("Bench",1,"A bench to sit on....duh");
		//sceneryArr.add(bench);
				
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
		
		
		createArrs();
		
	}//Model()
	
	/**
	 * Getter for hashSet of usedPlants in the Garden Plot
	 * 
	 * @return Hashset of used plants to be passed to InfoTips
	 */
	public static HashSet<Plant> getUsedPlants(){
		return usedPlants;
	}
	
	/**
	 * Uses a buffered reader to read GardenPlant.txt
	 * GardenTree.txt and GardenFlower.txt and create plants from
	 * what is read within those files
	 * 
	 * @author Kelsey McRae
	 */
	private void createArrs() {

//	    Scanner input;
		BufferedReader buffReader;
	    String[] textFileStrings = {"GardenPlant.txt","GardenTree.txt","GardenFlower.txt","Pathways.txt","Scenery.txt"};
	    Plant[] plants = new Plant[0];
	    Plant[] trees = new Plant[0];
	    Plant[] flowers = new Plant[0];
	    
		try {
			for(int i=0;i<textFileStrings.length-2;i++) {
				
				buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(textFileStrings[i]))); 
//				String line = buffReader.readLine(); 
				while (buffReader.readLine() != null) { 
					String name = buffReader.readLine();
					String latinName = buffReader.readLine();
					String color = buffReader.readLine();
					String bloomTimeStr = buffReader.readLine();
					String habit = buffReader.readLine();
					String sizeStr = buffReader.readLine();
					String waterNeedStr = buffReader.readLine();
					String sunlightNeedStr = buffReader.readLine();
					String soilMoisture = buffReader.readLine();
					String animalsFedStr = buffReader.readLine();
					String spring = buffReader.readLine();
					String summer = buffReader.readLine();
					String autumn = buffReader.readLine();
					String winter = buffReader.readLine();
					
					String[] seasonsArr = {spring,summer,autumn,winter};
					
					int size = Integer.parseInt(sizeStr);
			        int waterNeed = Integer.parseInt(waterNeedStr);
			        int sunlightNeed = Integer.parseInt(sunlightNeedStr);

		        	Plant newPlant = new Plant(name, latinName, color, bloomTimeStr, habit, size, waterNeed, sunlightNeed, soilMoisture, animalsFedStr, seasonsArr);

			        if (i==0) {
			        	plants = addPlant(plants, newPlant);
			        } else if (i==1) {
			        	trees = addPlant(trees, newPlant);
			        } else if (i==2) {
			        	flowers = addPlant(flowers, newPlant);
			        }
				}
			}
			
			for (int i=textFileStrings.length-2;i<textFileStrings.length;i++) {
				buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(textFileStrings[i]))); 
			
				while (buffReader.readLine() != null) {
					String addOnImgName = buffReader.readLine();
					String description = buffReader.readLine();
					int size;
					
					if (i==3) {
						size = 45;
						AddOn extra = new AddOn(addOnImgName,size,description);
						pathwaysArr.add(extra);
					} else if (i==4) {
						size = Integer.parseInt(buffReader.readLine());
						AddOn extra = new AddOn(addOnImgName,size,description);
						sceneryArr.add(extra);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i=0;i<plants.length;i++) {
			allPlants.add(plants[i]);
		}
		for (int i=0;i<trees.length;i++) {
			allPlants.add(trees[i]);
		}
		for(int i=0;i<flowers.length;i++) {
			allPlants.add(flowers[i]);
		}
	}
	
	/**
	 * Adds a specified plant to the specified array
	 * 
	 * @param plantsArr - an array of plants
	 * @param plantToAdd - a plant object
	 * @return newPlants - the new, updated plant array
	 */
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
		setFlowerArr(filterByType(allPlants,flower));
		setFlowerArr(filterByColor(flowerArr,userPrefColor));
		setFlowerArr(filterByBloomTime(flowerArr,userPrefSeason));
		setFlowerArr(filterByLight(flowerArr,userPrefLight));
		setFlowerArr(filterByWater(flowerArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into flowerArr
		flowerArr.addAll(otherWater);
		flowerArr.addAll(otherLight);
		flowerArr.addAll(otherSeasons);
		flowerArr.addAll(otherColors);
		
		// clearing other arrays
		clearOthers();
		
		// sets up the array by filter to appropriate type then filtering to all of
		// of shrubArr
		setShrubArr(filterByType(allPlants,shrub));
		setShrubArr(filterByColor(shrubArr,userPrefColor));
		setShrubArr(filterByBloomTime(shrubArr,userPrefSeason));
		setShrubArr(filterByLight(shrubArr,userPrefLight));
		setShrubArr(filterByWater(shrubArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into shrubArr
		shrubArr.addAll(otherWater);
		shrubArr.addAll(otherLight);
		shrubArr.addAll(otherSeasons);
		shrubArr.addAll(otherColors);
		
		// clearing other arrays
		clearOthers();
		
		// sets up the array by filter to appropriate type then filtering to all of
		// of treeArr
		setTreeArr(filterByType(allPlants,tree));
		setTreeArr(filterByColor(treeArr,userPrefColor));
		setTreeArr(filterByBloomTime(treeArr,userPrefSeason));
		setTreeArr(filterByLight(treeArr,userPrefLight));
		setTreeArr(filterByWater(treeArr,userPrefWater));
		
		// Adding rest of the unsorted lists back into treeArr
		treeArr.addAll(otherWater);
		treeArr.addAll(otherLight);
		treeArr.addAll(otherSeasons);
		treeArr.addAll(otherColors);
		
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
	        return a.getColor().toLowerCase().compareTo(b.getColor().toLowerCase()); 
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
			if(!p.getColor().toLowerCase().equals(color.toLowerCase())) {
				otherColors.add(p);
			}
		}
		// user getter for OtherColors Instead!
		otherColors.sort(new SortbyColor());
		
		// filters the arrayList taken in, makes copy so a is not disturbed
		ArrayList<Plant> userColorPlants = new ArrayList<Plant>();
		
		for(Plant p: a) {
			if(p.getColor().toLowerCase().equals(color.toLowerCase())) {
				userColorPlants.add(p);
			}
		}
		//userColorPlants.addAll(otherColors);
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
		//userBloomPlants.addAll(a);
		//streams the plants, filters by BloomTime, then adds them back to list
		for(Plant p: a) {
			if(p.getBloomTime().equals(season)) {
				userBloomPlants.add(p);
			}
		}
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
		for(Plant p: a) {
			if(p.getWaterNeed() != waterReq) {
				otherWater.add(p);
			}
		}
		// user getter for otherWater Instead!
		otherWater.sort(new SortbyWaterNeed());
	
		ArrayList<Plant> userWaterPlants = new ArrayList<Plant>();
		//userWaterPlants.addAll(a);
		//streams the plants, filters by BloomTime, then adds them back to list
		for(Plant p: a) {
			if(p.getWaterNeed() == waterReq) {
				otherWater.add(p);
			}
		}
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
		for(Plant p: a) {
			if(p.getSunLightNeed() != lightReq) {
				otherLight.add(p);
			}
		}
		// user getter for otherWater Instead!
		otherLight.sort(new SortbyLightNeed());
	
		ArrayList<Plant> userLightPlants = new ArrayList<Plant>();

		for(Plant p: a) {
			if(p.getSunLightNeed() == lightReq) {
				userLightPlants.add(p);
			}
		}
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
		//typeArr.addAll(a);
		for(Plant p: a) {
			if(p.getHabit().toLowerCase().contentEquals(type.toLowerCase())) {
				typeArr.add(p);
			}
		}
		//streams the plants, filters by BloomTime, then adds them back to list
		//typeArr.stream().filter(p -> p.getPlantType().equals(type)).collect(Collectors.toList());
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
	
	public String getTileContentsName(int row, int col) {
		GardenTile tile = userPlot.getLayout()[row][col];
		
		String addOnImgName = "";
		
		Plant p = tile.getPlant();
		if (!tile.isActive()) {
			addOnImgName="inactive";
		} else if (p!=null) {
			addOnImgName=p.getSeasonsImgArr()[userPrefSeason.ordinal()];
		} else if (tile.getAddOn()!=null) {
			addOnImgName = tile.getAddOn().getName();
		} 
		
		return addOnImgName;
	}
	
	/**
	 * Returns the property pathwaysArr, which holds all the AddOns that will go into the pathways tab in DesignGarden.
	 * @return
	 */
	public ArrayList<AddOn> getPathwaysArr() {
		return pathwaysArr;
	}
	
	/**
	 * Updates the tiles in the userPlot with the chosen light and water availability.
	 */
	public void updateGardenTileSettings() {
		for (int i=0;i<userLength;i++) {
			for (int j=0;j<userWidth;j++) {
				GardenTile tile =userPlot.getLayout()[i][j];
				tile.setSunLightLevel(userPrefLight);
				tile.setWaterLevel(userPrefWater);
			}
		}
	}
	
	public String getRecs(int x,int y) {
		GardenTile tile = userPlot.getLayout()[x][y];
		String recs="";
		
		for (int i=0;i<5; i++) {
			Plant p = allPlants.get(i);
			if (p.getSunLightNeed()==tile.getSunLightLevel() && p.getWaterNeed()==tile.getWaterLevel()) {
				recs+=p.getName()+" ("+p.getHabit()+")"+"\n";
			}
		}
		
		return recs;
	}
	// then getters and setters for new attributes
}//Modeld