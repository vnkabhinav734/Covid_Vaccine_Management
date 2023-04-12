package controller.userUpdate;

import java.util.HashMap;

import model.user.HealthWorkerUpdateImpl;
import model.user.User;

public class HealthWorkerUpdateController implements IHealthWorkerUpdateController{

	UserUpdateTemplate healthWorkerUpdateImpl;

	public HealthWorkerUpdateController(HealthWorkerUpdateImpl healthWorkerUpdateImpl) {
		this.healthWorkerUpdateImpl=healthWorkerUpdateImpl;
	}

	@Override
	public User getHealthWorker(String firstName, String lastName, String emailId) {
		return healthWorkerUpdateImpl.getUser(firstName, lastName, emailId);
	}

	@Override
	public User checkHealthWorkerExists(String firstName,String lastName,String emailId) {
		return healthWorkerUpdateImpl.checkUserExists(firstName, lastName, emailId);
	}

	@Override
	public boolean updateHealthWorkerDetails(User user,final HashMap<String,String> updateValues) {
		return healthWorkerUpdateImpl.updateUserDetails(user, updateValues);
	}
}
