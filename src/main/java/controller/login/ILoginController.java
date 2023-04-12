package controller.login;

import model.user.User;

public interface ILoginController {
	public User userLoginByEmail(String email,String password);
	public User userLoginByPhone(String mobileNumber,String password);
}
