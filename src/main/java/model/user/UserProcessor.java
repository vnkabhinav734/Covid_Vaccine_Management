package model.user;

import model.login.LoginProcessor;
import view.main.ShowDetails;

public class UserProcessor extends LoginProcessor {

	public UserProcessor(LoginProcessor nextLoginProcessor) {
		super(nextLoginProcessor);
	}

	public void process(User user)
	{
		if (user.getRole().equals(UserType.user))
		{
			ShowDetails sh1 = new ShowDetails();
			sh1.showUserDetails(user);
			sh1.showVaccinationDetails(user);
			sh1.showVaccineCentres(user);
		}
		else
		{
			super.process(user);
		}
	}

}
