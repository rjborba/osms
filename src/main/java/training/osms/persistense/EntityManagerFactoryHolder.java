package training.osms.persistense;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**This class was created because create a factory is a expensive process to system and
 * WE DO NOT NEED TO DO THAT at EVERY PERSISTENCE. To solve that problem, we, below create a final variable
 * that will be instantiated just once.
 * */

public class EntityManagerFactoryHolder {
	public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("OSMS");

}
