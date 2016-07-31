package za.co.dropzone.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import za.co.dropzone.backend.utils.ConnectionFactory;
import za.co.dropzone.backend.utils.DAOConstants;
import za.co.dropzone.dto.ProfileDTO;

public class ProfileDAO {
    private Connection connection;
    private PreparedStatement statement;
 
    public ProfileDAO() { }
     
    public ProfileDTO insertProfile(ProfileDTO profile) throws SQLException {

        try {
        	
            connection = ConnectionFactory.getConnection();
            
        	PreparedStatement statement = connection.prepareStatement(DAOConstants.INSERT_PROFILE,
                    Statement.RETURN_GENERATED_KEYS);
        	
            
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getShortDescription());
            statement.setString(3, profile.getLongDescription());
            
            statement.setString(4, profile.getNpoNumber());
            statement.setString(5, profile.getPboNumber());
            statement.setString(6, profile.getCompanyNumber());
            statement.setString(7, profile.getTrustNumber());
            statement.setString(8, profile.getVatNumber());
            statement.setInt(9, profile.getEntityId());
            

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating profile failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	int anInt = new BigDecimal(generatedKeys.getLong(1)).intValueExact();//need to change this just didnt want to regenerate thrift class right now
                    profile.setId(anInt);
                }
                else {
                    throw new SQLException("Creating profile failed, no ID obtained.");
                }
            
        } 
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        }
        finally {
            connection.close();
        }
        return profile;
    }
}
        
