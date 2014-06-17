package training.osms.persistense;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import training.osms.model.Category;
import training.osms.model.CategorySearchOption;

public class CategoryDao {

	public void InsertCategory(Category category) {
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory; //Read the commentary at Entity Manager Factory Holder to understand
		/*The couple of lines below ARE NOT EXPENSIVE for the system */
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction(); 
		
		transaction.begin(); // Every persistence, update or any king of change in BD's should be between
							//this tag and the last call "transaction.commit"
		
		manager.persist(category);
		
		transaction.commit();
	}
	
	public List<Category> SearchCategory(CategorySearchOption options){
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Category> query;
		StringBuilder predicate = new StringBuilder( "1=1");
		
		if(options.getName() != null && options.getName().length() > 0){
			predicate.append(" and name like %:prName%");
		}
		
		if(options.getDescription() != null && options.getDescription().length() > 0){
			predicate.append(" and description like %:prDescription%");
		}
		
		query = manager.createQuery("select Category from category where " + predicate, Category.class);
		
		if(options.getName() != null && options.getName().length() > 0){
			query.setParameter("prName", options.getName());
		}
		
		if(options.getDescription() != null && options.getDescription().length() > 0){
			query.setParameter("prDescription", options.getDescription());
		}
		
		return query.getResultList();
	}
	
	public boolean ContainsCategory(String categoryName){
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Category> query;
		
		query = manager.createQuery("select Category from category where name = :name", Category.class);
		query.setParameter("name", categoryName);
		
		
		if(query.getResultList().isEmpty())
			return false;
		return true;
	}
}


















