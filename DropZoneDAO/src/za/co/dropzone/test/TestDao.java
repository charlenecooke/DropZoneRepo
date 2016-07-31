package za.co.dropzone.test;

import java.sql.SQLException;

import za.co.dropzone.dao.UserDAO;
import za.co.dropzone.dto.UserDTO;

public class TestDao {

	public static void main(String[] args) {
		UserDAO d = new UserDAO();
		UserDTO UserDTO;
		try {
			
			UserDTO = d.getDonators();
			System.out.println(UserDTO.getName());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
