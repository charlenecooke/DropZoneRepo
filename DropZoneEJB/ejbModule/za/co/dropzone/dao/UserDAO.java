package za.co.dropzone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import za.co.dropzone.backend.utils.ConnectionFactory;
import za.co.dropzone.backend.utils.DAOConstants;
import za.co.dropzone.dto.UserDTO;

public class UserDAO {
    private Connection connection;
    private Statement statement;
 
    public UserDAO() { }
     
    public UserDTO getDonators() throws SQLException {

        ResultSet rs = null;
        UserDTO donator = new UserDTO();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(DAOConstants.SELECT_USER);
            rs.next();
            donator.setName(rs.getString("Username"));
            
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
        return donator;
    }
}
