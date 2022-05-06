
public class Movie {

	// instance variables
	private String title;
	private String category;	
	
	// constructor
	public Movie(String title, String category) {
		this.title = title;
		this.category = category;
	}
	
	// getters and setters
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
