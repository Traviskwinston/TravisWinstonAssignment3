package Assignment3;

//User Service Class
public class UserService {
	//one method named createUser that takes in an array of Strings as input
	public User createUser(String[] stringInput) { //This works without the 'public' in the front. Why needed?
		User user = new User();
		user.setUsername(stringInput[0]);
		user.setPassword(stringInput[1]);
		user.setName(stringInput[2]);
		return user;
	}
	
	public String[] parseText(String splitText) {
		String[] element = splitText.split(",");
		return element;
	}
//	public User createUser(String username, String password, String name) {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setName(name);
//		return user;
//	}
}
