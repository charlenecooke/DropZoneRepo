package za.co.dropzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import za.co.dropzone.dto.ProfileDTO;
import za.co.dropzone.entities.Profile;

public class ProfileDAO {
    private Connection connection;
    private PreparedStatement statement;
 
    public ProfileDAO() { }
     
    public ProfileDTO insertProfile(ProfileDTO profiler) throws SQLException {

try{
        	
    		/* Create EntityManagerFactory */
    		EntityManagerFactory emf = Persistence
    				.createEntityManagerFactory("DropZoneEJB");
     
    		/* Create and populate Entity */
    		Profile profile = new Profile();
    		profile.setName("JPA- prasad");
    		profile.setShortDescription("JPA - descrip");
    		profile.setLongDescription("JPA - LongDescrip");
     
    		/* Create EntityManager */
    		EntityManager em = emf.createEntityManager();
     
    		/* Persist entity */
    		em.getTransaction().begin(); 
    		em.persist(profile);
//    		em.getTransaction().commit(); container manages this
    		
    		/* Retrieve entity */
    		profile = em.find(Profile.class, 22);
    		System.out.println(profile);
     
    		/* Update entity */
//    		em.getTransaction().begin();
    		profile.setName("JPA - Name");
    		System.out.println("Profile after update :- " + profile);
//    		em.getTransaction().commit();        container manages this
        	
}catch(Exception e){
	e.printStackTrace();
	
}
    		
           return new ProfileDTO();
    }
    
//    public ProfileDTO updateProfile(ProfileDTO profile){
//    	
//    	
//    		 connection = ConnectionFactory.getConnection();
//             
//         	PreparedStatement statement;
//			try {
//				statement = connection.prepareStatement(DAOConstants.INSERT_PROFILE,
//				         Statement.RETURN_GENERATED_KEYS);
//
//         	
//             
//             statement.setString(1, profile.getName());
//             statement.setString(2, profile.getShortDescription());
//             statement.setString(3, profile.getLongDescription());
//             
//             statement.setString(4, profile.getNpoNumber());
//             statement.setString(5, profile.getPboNumber());
//             statement.setString(6, profile.getCompanyNumber());
//             statement.setString(7, profile.getTrustNumber());
//             statement.setString(8, profile.getVatNumber());
//             statement.setInt(9, profile.getEntityId());
//             
//
//             int affectedRows = statement.executeUpdate();
//
//             if (affectedRows == 0) {
//                 throw new SQLException("Creating profile failed, no rows affected.");
//             }
//
//             try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                 if (generatedKeys.next()) {
//                 	int anInt = new BigDecimal(generatedKeys.getLong(1)).intValueExact();//need to change this just didnt want to regenerate thrift class right now
//                     profile.setId(anInt);
//                 }
//                 else {
//                     throw new SQLException("Creating profile failed, no ID obtained.");
//                 }
//             
//         
// 			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//         return profile;    		
    	
		
}
        
