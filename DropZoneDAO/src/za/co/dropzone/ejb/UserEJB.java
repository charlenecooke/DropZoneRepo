package za.co.dropzone.ejb;

import java.sql.SQLException;

import za.co.dropzone.dao.UserDAO;
import za.co.dropzone.dto.UserDTO;

public class UserEJB {

	public void getDonators() throws SQLException{
		UserDAO d = new UserDAO();
		UserDTO donatorDTO= d.getDonators();
		System.out.println(donatorDTO.getName());
	}
}
