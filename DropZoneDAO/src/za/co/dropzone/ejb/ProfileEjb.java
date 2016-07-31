package za.co.dropzone.ejb;

import java.sql.SQLException;

import za.co.dropzone.dao.ProfileDAO;
import za.co.dropzone.dto.ProfileDTO;

public class ProfileEjb {
	
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
