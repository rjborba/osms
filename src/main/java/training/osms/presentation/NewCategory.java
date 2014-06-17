package training.osms.presentation;
import javax.faces.bean.ManagedBean;

import training.osms.business.CategoryController;
import training.osms.model.Category;

@ManagedBean
public class NewCategory {
	private Category category; /** We should remember that JSF do not interact with attributes, it does
	 							** with properties. So, do attribute a property always! */
	
	
	public NewCategory() {
		this.category = new Category();
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void saveCategory(){
		CategoryController controller = new CategoryController();
		
		controller.SaveCategory(category);
	}
}
