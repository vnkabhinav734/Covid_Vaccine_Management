package model.user;

import java.util.HashMap;

public interface IUserQuery{
	String insertUser(final User user);
	String getHealthWorker(String firstName,String lastName,String emailId);
	String updateHealthWorker(final User user,final HashMap<String,String> updateValues);

	String getUser(String firstName,String lastName,String emailId);

	String updateUser(User user,HashMap<String,String> updateValues);

	String updateVaccinationStatus(User user, String vaccinationStatus);
	public String selectUserId(User user);
}
