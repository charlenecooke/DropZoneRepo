package za.co.dropzone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import za.co.dropzone.backend.utils.ConnectionFactory;
import za.co.dropzone.backend.utils.DAOConstants;
import za.co.dropzone.dto.OpenDonationDTO;

public class DonationDAO {
    private Connection connection;
    private Statement statement;
 
    public DonationDAO() { }
     
    public OpenDonationDTO insertProfile(OpenDonationDTO profile) throws SQLException {

        ResultSet rs = null;
        OpenDonationDTO dto = new OpenDonationDTO();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(DAOConstants.SELECT_USER);
            rs.next();
            dto.setId(rs.getInt("Id"));
            dto.setDonationType(rs.getString("donationType"));
            dto.setTown(rs.getString("town"));
            dto.setCountry(rs.getString("country"));
            dto.setDescription(rs.getString("description"));
            
        } 
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
            rs.close();
        }
        return dto;
    }
}
        
