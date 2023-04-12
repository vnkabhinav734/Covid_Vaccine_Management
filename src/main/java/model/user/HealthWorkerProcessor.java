package model.user;

import model.login.LoginProcessor;
import view.user.HealthWorkerPage;

public class HealthWorkerProcessor extends LoginProcessor {

	public HealthWorkerProcessor(LoginProcessor nextLoginProcessor) {
		super(nextLoginProcessor);
	}

	public void process(User user)
	{
		if (user.getRole().equals(UserType.healthworker))
		{
			HealthWorkerPage healthWorkerPage = new HealthWorkerPage();
			healthWorkerPage.display();
		}
		else
		{
			super.process(user);
		}
	}

}
