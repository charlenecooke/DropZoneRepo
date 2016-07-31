package za.co.dropzone.backend.utils;

public final class DAOConstants {

	public static final String SELECT_USER = "SELECT * FROM [DropZone].[dbo].[User]" ;
	
	
	public static final String INSERT_PROFILE = "INSERT INTO [dbo].[Profile] " + 
			" ([Name] " + 
			" ,[ShortDescription] " + 
			" ,[LongDescription] " + 
			" ,[NPONumber] " + 
			" ,[PBONumber] " + 
			" ,[CompanyNumber] " + 
			" ,[TrustNumber] " + 
			" ,[VATNumber] " + 
			" ,[EntityId]) " + 
			" VALUES " + 
			" (?" + 
			" ,? " + 
			" ,? " + 
			" ,? " + 
			" ,? " + 
			" ,? " + 
			" ,? " + 
			" ,? " + 
			" ,?) " ;
	
	
public static final String VIEW_OPEN_DONATIONS = "SELECT d.Id, dt.Description donationType, Address town, c.Description country, d.description " + 
											"from Donation d, " + 
											"donationtype dt , " + 
											"Country c " + 
											"where d.DonationTypeId = dt.Id " + 
											"and c.id = d.countryid " + 
											"and d.destinationEntityId is null ";
	
}
