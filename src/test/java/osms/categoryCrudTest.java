package osms;


import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import training.osms.business.CategoryController;
import training.osms.model.Category;
import training.osms.model.CategorySearchOption;
import training.osms.persistense.CategoryDao;

public class categoryCrudTest {

	@Test
	public void NewCategoryTest() {
		Category category = new Category();
		category.setName("Rodrigo");
		category.setDescription("It is a sample of category description.");
		
		CategoryController controller = new CategoryController();

		CategoryDao dao = EasyMock.createMock(CategoryDao.class);
		EasyMock.expect(dao.ContainsCategory("Rodrigo")).andReturn(true);
		EasyMock.replay(dao);
		
		controller.setDao(dao);

		try{
			controller.SaveCategory(category);
			Assert.fail("If we get this far, the exeption should be trhowed but was't");
		}catch(RuntimeException e){
			System.out.println("Exception");
		}
		
		
		EasyMock.verify(dao);
	}
	
	@Test
	public void NewCategoryTest2() {
		Category category = new Category();
		category.setName("Rodrigo");
		category.setDescription("It is a sample of category description.");
		
		CategoryController controller = new CategoryController();

		CategoryDao dao = EasyMock.createMock(CategoryDao.class);
		EasyMock.expect(dao.ContainsCategory("Rodrigo")).andReturn(false);
		dao.InsertCategory(category);
		EasyMock.replay(dao);
		
		controller.setDao(dao);

		try{
			controller.SaveCategory(category);
		}catch(RuntimeException e){
			Assert.fail("If we get here, means that we do not add a Category for a unknow situation);
		}
		
		
		EasyMock.verify(dao);
	}

}
