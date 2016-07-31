package za.co.dropzone.sessionbeans;

import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import za.co.dropzone.dao.ProfileDAO;
import za.co.dropzone.dto.ProfileDTO;

/**
 * Session Bean implementation class Profile
 */
@Stateless
@EJB(name="ProfileStatelessSessionBean", beanInterface=ProfileLocal.class)

public class ProfileStatelessSessionBean implements ProfileLocal {

    /**
     * Default constructor. 
     */
    public ProfileStatelessSessionBean() {
    	
    }
    
	@Override
	public ProfileDTO insertProfile(ProfileDTO profile) {
		
		ProfileDAO dao = new ProfileDAO();
		
		//Do some business logic
		
		try {
			dao.insertProfile(profile);
		} catch (SQLException e) {
			// TODO map e to business exception
			//log trace and then throw business exception
			e.printStackTrace();
		}
		
		return profile;
	}

}
