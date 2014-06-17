package training.osms.business;

import training.osms.model.Category;
import training.osms.persistense.CategoryDao;

public class CategoryController {
	
	private CategoryDao dao;
	
	/*The method below is used for the Unit test. That way we can set the DAO with the behavior that
	 * we set at the Test Class*/
	
	public void setDao(CategoryDao dao){
		this.dao = dao;
	}
	
	public CategoryController() {
		dao = new CategoryDao();
	}


	public void SaveCategory(Category category) {

		if(dao.ContainsCategory("Rodrigo"))
			throw new RuntimeException("There is a category with the same name already registered!");
		else
			dao.InsertCategory(category);	
	}
}
