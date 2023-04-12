package model.user;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public  class UserFieldValidation {

	public static boolean nameValidation(String name) {
		if(isEmptyString(name)) {
			return true;
		}
		else {
			boolean result=!Pattern.matches("[A-Za-z ]+", name);
			return result;
		}
	}


	public static boolean genderValidation(String gender) {
		if(isEmptyString(gender)) {
			return true;
		}
		else {
			boolean result=!Gender.isGenderValid(gender);
			return result;
		}
	}


	public static boolean dateValidation(String date) {
		if(isEmptyString(date)) {
			return true;
		}
		try {
			String[] dateArr = date.split("-");
			if (Integer.parseInt(dateArr[0])<0 || Integer.parseInt(dateArr[0])>31 || dateArr[0].length() != 2) {
				return true;
			}
			if (Integer.parseInt(dateArr[1])<0 || Integer.parseInt(dateArr[1])>12 || dateArr[1].length() != 2) {
				return true;
			}
			if (dateArr[2].length() != 4) {
				return true;
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
			dateFormat.setLenient(false);
			boolean result=!(dateFormat.parse(date) != null);
			return result;
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean emailValidation(String email) {
		if (isEmptyString(email)) {
			return true;
		}
		else {
			boolean result=!Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
					email);//https://regexr.com/3e48o
			return result;
		}
	}


	public static boolean passwordValidation(String password) {
		if(isEmptyString(password)) {
			return true;
		}
		else {
			boolean result=!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
					password);//https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/
			return result;
		}
	}


	public static boolean mobileNumberValidation(String contactNumber) {
		if(isEmptyString(contactNumber)) {
			return true;
		}
		else {
			boolean result=!Pattern.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", contactNumber);
			//https://www.geeksforgeeks.org/java-program-to-check-for-a-valid-mobile-number/#:~:text=Mobile%20number%20validation%20in%20Java,with%20compiled%20pattern%2Fregular%20expression.
			return result;
		}
	}

	public static boolean areaCodeValidation(String zipCode) {
		if(isEmptyString(zipCode)) {
			return true;
		}
		else {
			boolean result=!Pattern.matches("^[A-Za-z\\d]{6}$", zipCode);
			return result;
		}
	}


	public static boolean isEmptyString(String text) {
		if(text==null || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean timeValidation(String text) {
		if(isEmptyString(text)) {
			return true;
		}
		else {
			boolean result=!Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", text);
			//https://www.w3schools.blog/validate-24-hours-format-regular-expression-regex-java
			return result;
		}
	}
}