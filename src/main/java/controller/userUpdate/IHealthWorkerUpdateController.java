package controller.userUpdate;

import java.util.HashMap;

import model.user.User;

public interface IHealthWorkerUpdateController {
	User checkHealthWorkerExists(final String firstName,final String lastName,final String emailId);
	User getHealthWorker(final String firstName,final String lastName,final String emailId);
	boolean updateHealthWorkerDetails(final User user,final HashMap<String,String> updateValues);
}
