package training.osms.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

import training.osms.model.Category;
import training.osms.model.Test;


public class CreateDB {
	public static void main(String[] args){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("OSMS");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction(); // 
	
	transaction.begin(); // Every persistence, update or any king of change in BD's should be between
						//this tag and the last call "transaction.commit"
	Category category = new Category();
	Test test = new Test();
	
	test.setDescripion_test("Teste one");
	test.setId_test(20);
	
	category.setDescription("Test");
	category.setName("Teste bla bla");
	
	manager.persist(category);
	
	transaction.commit();
	}
}
