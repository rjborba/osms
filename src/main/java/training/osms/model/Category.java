package training.osms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	Integer id;
	String name;
	String description;

	/* Below we see that was used two annotations: Id and GenetatedValue
	 *  The first one is used to set a Identifier(id) that is the primary and unique key from table(Entity) 
	 * The second is used to set a generator to the Id (annotation above). There is a parameter(strategy) used to set
	 * the type of generator. We're using the Identity as strategy. It makes the generator unique for this table(Entity) */
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
