package za.co.dropzone.sessionbeans;

import javax.ejb.EJB;
import javax.ejb.Local;

import za.co.dropzone.dto.ProfileDTO;

@Local

public interface ProfileLocal {
	
	public ProfileDTO insertProfile(ProfileDTO profile);

}
