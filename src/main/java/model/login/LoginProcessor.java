package model.login;

import model.user.User;

public abstract class LoginProcessor {

	private LoginProcessor nextLoginProcessor;

	public LoginProcessor(LoginProcessor nextLoginProcessor){
		this.nextLoginProcessor = nextLoginProcessor;
	};

	public void process(User user){
		if(nextLoginProcessor != null)
			nextLoginProcessor.process(user);
	};
}
