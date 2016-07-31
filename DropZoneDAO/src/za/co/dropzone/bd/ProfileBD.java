package za.co.dropzone.bd;

import za.co.dropzone.dto.ProfileDTO;
import za.co.dropzone.ejb.ProfileEjb;

public class ProfileBD {

	
	//This is an example of the class which will receive the values from the service and execute required backend functionality
	
	public static void insertProfile() {
		ProfileDTO dto = new ProfileDTO();
		
		dto.setCompanyNumber("comp num");
		dto.setEntityId(1);
		dto.setLongDescription("long descrip");;
		dto.setName("Name");
		dto.setNpoNumber("npoNumber");
		dto.setPboNumber("pboNumber");
		dto.setShortDescription("shortDescription");
		dto.setTrustNumber("trustNumber");
		dto.setVatNumber("vatNumber");
		
		ProfileEjb e = new ProfileEjb();
		e.insertProfile(dto);
	}
}
