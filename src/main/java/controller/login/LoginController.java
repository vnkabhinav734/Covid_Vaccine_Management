package controller.login;

import model.login.LoginImpl;
import model.user.User;

public class LoginController {

	private LoginImpl loginImpl;

	public LoginController(LoginImpl loginImpl)
	{
		this.loginImpl=loginImpl;
	}
	public LoginController() {
		super();
	}
	private User user;


	public User userLoginByEmail(String email,String password) throws Exception {
		user=loginImpl.getPasswordByEmail(email);
		user=loginImpl.userCheck(user,password);
		return user;
	}

	public User userLoginByPhone(String mobileNumber,String password) throws Exception {
		user=loginImpl.getPasswordByPhoneNumber(mobileNumber);
		user=loginImpl.userCheck(user,password);
		return user;
	}
}