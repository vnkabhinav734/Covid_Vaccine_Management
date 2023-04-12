package model.user;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import database.DatabaseConnection;
import model.vaccinationDetails.Subject;
import model.vaccinationDetails.VaccinationDetailsImpl;

public class UserRegistrationImpl {
	private static UserRegistrationImpl userRegistrationImpl;

	public static UserRegistrationImpl instance() {
		if (userRegistrationImpl == null) {
			userRegistrationImpl = new UserRegistrationImpl();
		}
		return userRegistrationImpl;
	}

	public boolean register(User user) {
		try {
			ArrayList<String> errorList=validateUserInputs(user);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}
			String encodedPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
			user.setPassword(encodedPassword);
			Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
			String insertUserQuery = UserQuery.instance().insertUser(user);
			int rowCount=statement.executeUpdate(insertUserQuery);
			if (rowCount > 0) {
				VaccinationDetailsImpl vac_detail =  new VaccinationDetailsImpl();
				String selectQuery = UserQuery.instance().selectUserId(user);
				ResultSet rs = statement.executeQuery(selectQuery);
				if (rs.next()) {
					user.setUserId(rs.getString(UserDatabaseColumns.user_id));
				}
				Subject.Instance().attach(vac_detail);
				Subject.Instance().notifyObservers(user);
				return true;
			}
			return false;
		}
		catch(Exception e) {
			DatabaseConnection.instance().stopDatabaseConnection();
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<String> validateUserInputs(User user){
		ArrayList<String> errorList=new ArrayList<String>();

		if(UserFieldValidation.nameValidation(user.getFirstName())) {
			errorList.add("First Name is not Valid"); }
		if(UserFieldValidation.nameValidation(user.getLastName())) {
			errorList.add("Last Name is not Valid"); }
		if(UserFieldValidation.mobileNumberValidation(user.getMobileNumber())) {
			errorList.add("Mobile Number is not Valid"); }
		if(UserFieldValidation.genderValidation(user.getGender())) {
			errorList.add("Gender is not Valid"); }
		if(UserFieldValidation.emailValidation(user.getEmailId())) {
			errorList.add("Email ID is not Valid"); }
		if(UserFieldValidation.dateValidation(user.getDateOfBirth())) {
			errorList.add("Date of Birth is not Valid"); }
		if(UserFieldValidation.areaCodeValidation(user.getAddressZipCode())) {
			errorList.add("Area Code/Zip Code is not Valid"); }
		if(UserFieldValidation.passwordValidation(user.getPassword())) {
			errorList.add("Password is not Valid"); }
		return errorList;
	}

}
