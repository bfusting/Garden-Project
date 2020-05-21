import java.io.Serializable;

/**
 * Parent to the Plant class, the Addon Class represents items other than plants 
 * such as houses, benches, ponds, etc. 
 * <p>
 * Holds attribute name, which is the name of the feature being dropped. Tilesize,
 * the size an object will take up in the grid. Description will be a string
 * which represents what the object actualy does. All Addon's are created through 
 * a buffered Reader from the scenery.txt and Pathways.txt
 * 
 * @author Bradley Fusting
 *
 */
public class AddOn implements Serializable{
	private static final long serialVersionUID = 38L;
	
	String name;
	/**
	 * int tileSize:
	 * the number of tiles this AddOn takes up
	 */
	int tileSize;
	
	String description;

	public AddOn(){
		
	}
	
	/**
	 * 
	 * @param n name
	 * @param tS tileSize
	 */
	public AddOn(String n, int tS, String d) {
		this.name = n;
		this.tileSize= tS;
		this.description = d;
	}


	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}

	public void setTileSize(int ts){
		this.tileSize = ts;
	}

	public int getTileSize(){
		return this.tileSize;
	}
	
	public void setDescription(String d){
		this.description = d;
	}

	public String getDescription(){
		return this.description;
	}

	public boolean equals(Plant p) {
		return this.name.equals(p.name);
	}
	
	@Override
	public String toString() {
		return "Name: "+name+"\nDescription: "+description;
	}
}
