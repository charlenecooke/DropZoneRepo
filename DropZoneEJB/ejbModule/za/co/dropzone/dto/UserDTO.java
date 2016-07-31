package za.co.dropzone.dto;

public class UserDTO {

	private String username;
	private String userType;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}

}
