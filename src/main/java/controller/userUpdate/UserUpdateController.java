package controller.userUpdate;

import java.util.HashMap;

import model.user.User;
import model.user.UserUpdateImpl;

public class UserUpdateController implements IUserUpdateController {

	UserUpdateTemplate userUpdateImpl;

	public UserUpdateController(UserUpdateImpl userUpdateImpl) {
		this.userUpdateImpl=userUpdateImpl;
	}

	@Override
	public User getUser(String firstName, String lastName, String emailId) {
		return userUpdateImpl.getUser(firstName, lastName, emailId);
	}

	@Override
	public User checkUserExists(String firstName,String lastName,String emailId) {
		return userUpdateImpl.checkUserExists(firstName, lastName, emailId);
	}

	@Override
	public boolean updateUserDetails(User user,final HashMap<String,String> updateValues)
	{
		return userUpdateImpl.updateUserDetails(user, updateValues);
	}


}
