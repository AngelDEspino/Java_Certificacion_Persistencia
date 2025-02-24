package locator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocatorEntityManager {
	static EntityManager em;
	public static EntityManager getEntityManager(){
		if(em==null) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("bancabdPU");
		return factory.createEntityManager(); 
		}
		return em;
	}
}
