package model.user;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import controller.userUpdate.UserUpdateTemplate;
import database.DatabaseConnection;

public class HealthWorkerUpdateImpl extends UserUpdateTemplate{

	private static HealthWorkerUpdateImpl healthWorkerUpdateImpl;

	public static HealthWorkerUpdateImpl instance() {
		if (healthWorkerUpdateImpl == null) {
			healthWorkerUpdateImpl = new HealthWorkerUpdateImpl();
		}
		return healthWorkerUpdateImpl;
	}

	public User getUser(String firstName, String lastName, String emailId) {
		User healthWorker=this.checkUserExists(firstName, lastName, emailId);
		return healthWorker;
	}

	public User checkUserExists(String firstName,String lastName,String emailId) {
		try {
			Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
			String selectUserQuery = UserQuery.instance().getHealthWorker(firstName,lastName,emailId);
			ResultSet rs=statement.executeQuery(selectUserQuery);
			User healthWorker=new User();
			while(rs.next()) {
				healthWorker.setUserId(rs.getString(UserDatabaseColumns.user_id));
				healthWorker.setFirstName(rs.getString(UserDatabaseColumns.user_first_name));
				healthWorker.setLastName(rs.getString(UserDatabaseColumns.user_last_name));
				healthWorker.setGender(rs.getString(UserDatabaseColumns.user_gender));
				healthWorker.setEmailId(rs.getString(UserDatabaseColumns.user_email));
				healthWorker.setMobileNumber(rs.getString(UserDatabaseColumns.user_mobile));
				healthWorker.setDateOfBirth(rs.getString(UserDatabaseColumns.user_dob));
				healthWorker.setAddress(rs.getString(UserDatabaseColumns.user_address));
				healthWorker.setAddressCity(rs.getString(UserDatabaseColumns.user_city));
				healthWorker.setAddressZipCode(rs.getString(UserDatabaseColumns.user_zip));
				return healthWorker;
			}
			return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}

	public boolean updateUserDetails(User user,final HashMap<String,String> updateValues) {
		try {
			ArrayList<String> errorList=validateUserInputs(updateValues);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}
			Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
			String updateUserQuery = UserQuery.instance().updateHealthWorker(user,updateValues);
			int rowCount=statement.executeUpdate(updateUserQuery);
			if (rowCount > 0) {
				return true;
			}
			return false;		
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally{
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}

	public ArrayList<String> validateUserInputs(HashMap<String,String> updateValues){
		ArrayList<String> errorList=new ArrayList<String>();
		if(updateValues.get(UserDatabaseColumns.user_first_name)!=null) {
			if(UserFieldValidation.nameValidation(updateValues.get(UserDatabaseColumns.user_first_name))) {
				errorList.add("First Name is not Valid"); }
		}
		if(updateValues.get(UserDatabaseColumns.user_last_name)!=null) {
			if(UserFieldValidation.nameValidation(updateValues.get(UserDatabaseColumns.user_last_name))) {
				errorList.add("Last Name is not Valid"); }
		}
		if(updateValues.get(UserDatabaseColumns.user_mobile)!=null) {
			if(UserFieldValidation.mobileNumberValidation(updateValues.get(UserDatabaseColumns.user_mobile))) {
				errorList.add("Mobile Number is not Valid"); }
		}
		if(updateValues.get(UserDatabaseColumns.user_gender)!=null) {
			if(UserFieldValidation.genderValidation(updateValues.get(UserDatabaseColumns.user_gender))) {
				errorList.add("Gender is not Valid"); }
		}
		if(updateValues.get(UserDatabaseColumns.user_email)!=null) {
			if(UserFieldValidation.emailValidation(updateValues.get(UserDatabaseColumns.user_email))) {
				errorList.add("Email ID is not Valid"); }
		}
		if(updateValues.get(UserDatabaseColumns.user_dob)!=null) {
			if(UserFieldValidation.dateValidation(updateValues.get(UserDatabaseColumns.user_dob))) {
				errorList.add("Date of Birth is not Valid"); }
		}
		if(updateValues.get(UserDatabaseColumns.user_zip)!=null) {
			if(UserFieldValidation.areaCodeValidation(updateValues.get(UserDatabaseColumns.user_zip))) {
				errorList.add("Area Code/Zip Code is not Valid"); }
		}
		return errorList;
	}

}
