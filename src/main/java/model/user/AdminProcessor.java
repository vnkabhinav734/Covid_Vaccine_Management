package model.user;

import model.login.LoginProcessor;
import view.user.AdminPage;

public class AdminProcessor extends LoginProcessor {

	public AdminProcessor(LoginProcessor nextLoginProcessor) {
		super(nextLoginProcessor);
	}

	public void process(User user)
	{
		if (user.getRole().equals(UserType.admin))
		{
			AdminPage admin=new AdminPage();
			admin.display();
		}
		else
		{
			super.process(user);
		}
	}

}
