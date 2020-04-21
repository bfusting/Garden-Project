public class AddOn{
	
	String name;
	/**
	 * int tileSize:
	 * the number of tiles this AddOn takes up
	 */
	int tileSize;
	
	String description;

	public void AddOn(){
		
	}
	
	/**
	 * 
	 * @param n name
	 * @param tS tileSize
	 * @param d description
	 */
	public void AddOn(String n, int tS, String d) {
		this.name = n;
		this.tileSize= tS;
		this.description = d;
	}
}
