package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import za.co.dropzone.entities.Profile;
 
public class Test {
 
	public static void main(String[] args) {
 
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExamples");
 
		/* Create and populate Entity */
		Profile profile = new Profile();
		profile.setName("prasad");
		profile.setShortDescription("descrip");
		profile.setLongDescription("LongDescrip");
 
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
 
		/* Persist entity */
		em.getTransaction().begin();
		em.persist(profile);
		em.getTransaction().commit();
 
		/* Retrieve entity */
		profile = em.find(Profile.class, 22);
		System.out.println(profile);
 
		/* Update entity */
		em.getTransaction().begin();
		profile.setName("JPAName");
		System.out.println("Profile after update :- " + profile);
		em.getTransaction().commit();
 
//		/* Remove entity */
//		em.getTransaction().begin();
//		em.remove(profile);
//		em.getTransaction().commit();
// 
//		/* Check whether entity is removed or not */
//		profile = em.find(Profile.class, 1);
//		System.out.println("Profile after removal :- " + profile);
 
	}
}