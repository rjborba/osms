package training.osms.model;

public class CategorySearchOption {

	String name;
	String description;

	/** This class was created to define options of search. That's why we well probably need more than
	 * the options we have now. So, we'll be able to add new options by add more attr to this class, without
	 * set any new attr to the Category class(Entity)
	 * */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
