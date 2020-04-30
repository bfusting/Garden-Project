/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: foo11
*  Lab Section: foo31L
*  TA: Vineeth Gutta
*  Due: May 18th, 2foo2foo (5/18/2foo)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * Seasons for different pictures linked to the plant arrayList in each Plant
 * also represents the bloomTime within the Plant rather than a Date class
 * 
 * @author Bradley Fusting
 */
public enum Seasons{
	/**
	 * SPRING season represented by a string "spring"
	 */
	SPRING("spring"), 
	/**
	 * SUMMER season represented by a string "summer"
	 * */
	  SUMMER("summer"),
	  /**
	   * AUTUMN season represented by a string "autumn"
	   */
	  AUTUMN("autumn"),
	  /** 
	   * WINTER season represented by a string "winter"
	   */
	  WINTER("winter");
	
	private String season = null;
	
	/**
	 * Constructor for Seasons Enum
	 * @param newSeason season to create Seasons
	 */
	private Seasons(String newSeason) {
		season = newSeason;
	}
	
	/**
	 * Getter for season attribute which representes the current season
	 * 
	 * @return current season which is represented by a string
	 */
	public String getSeason() {
		return season;
	}
}

