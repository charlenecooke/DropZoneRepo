package za.co.dropzone.services.impl;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.thrift.TException;

import za.co.dropzone.dto.ProfileDTO;
import za.co.dropzone.sessionbeans.ProfileLocal;
import za.co.dropzone.thriftservices.ProfileService.Iface;


public class ProfileServer implements Iface{

	@Override
	public int createProfile(String organisationName, String shortDescription,
			String longDescription, String npoNumber, String companyNumber,
			String trustNumber, String vatNumber, int entityId)
			throws TException {
		
			ProfileDTO dto = new ProfileDTO();
			dto.setName(organisationName);
			dto.setShortDescription(shortDescription);
			dto.setLongDescription(longDescription);
			dto.setNpoNumber(npoNumber);
			dto.setCompanyNumber(companyNumber);
			dto.setTrustNumber(trustNumber);
			dto.setVatNumber(vatNumber);
			dto.setEntityId(entityId);
			
//			ProfileEjb e = new ProfileEjb();
//			dto = e.insertProfile(dto);
			
//			@EJB(lookup="java:global/DropZoneEar/DropZoneEJB/HelloWorld") ; This is how we want to do it, with injection
			try {
				
				InitialContext ic = new InitialContext();

				ProfileLocal ejb = (ProfileLocal) ic.lookup("java:global/DropZoneEar/DropZoneEJB/ProfileStatelessSessionBean");
				ejb.insertProfile(dto);
				
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			System.out.println("Request to add profile received - added successfully with new primary key = " + dto.getId());
			
			return dto.getId();
	}

}
