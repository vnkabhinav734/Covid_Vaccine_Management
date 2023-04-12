package view.user;

import java.util.Scanner;

import controller.userRegistration.IUserRegistrationController;
import controller.userRegistration.UserRegistrationController;
import model.user.User;
import model.user.UserRegistrationImpl;
import model.user.UserType;

public class UserRegistration {
	private final Scanner scanner;

	public UserRegistration(final Scanner scanner) {
		this.scanner = scanner;
	}

	public final void registerUser() {
		try {			  
			System.out.println("Enter first name");
			final String firstName = scanner.nextLine().trim();

			System.out.println("Enter last name");
			final String lastName = scanner.nextLine().trim();

			System.out.println("Enter gender(MALE/FEMALE/OTHER)");
			final String gender = scanner.nextLine().trim().toUpperCase();

			System.out.println("Enter mobile number");
			final String mobileNumber = scanner.nextLine().trim();

			System.out.println("Enter email ID");
			final String emailId = scanner.nextLine().trim();

			System.out.println("Enter Date Of Birth(DD-MM-YYYY)");
			final String dateOfBirth = scanner.nextLine().trim();

			System.out.println("Enter Address");
			final String address = scanner.nextLine().trim();

			System.out.println("Enter City(Address)");
			final String city = scanner.nextLine().trim();

			System.out.println("Enter AreaCode(Address)");
			final String areaCode = scanner.nextLine().trim();

			System.out.println("Enter password(1 UPPERCASE/1 LOWERCASE/1 NUMBER/1 SPECIAL CHAR)");
			String firstPass = scanner.nextLine().trim();

			System.out.println("Confirm password");
			String secondPass = scanner.nextLine().trim();

			this.confirmPassword(firstPass, secondPass);

			final String password = firstPass;

			User user=new User(firstName,lastName,gender,mobileNumber,emailId,
					dateOfBirth,address,city,areaCode,password,UserType.user);

			UserRegistrationImpl userRegistrationImpl=new UserRegistrationImpl();
			final IUserRegistrationController userRegistrationController = new UserRegistrationController(userRegistrationImpl);
			boolean userInserted=userRegistrationController.register(user);
			if(userInserted) {
				System.out.println("User Registered Successfully");
			}
			else {
				System.out.println("User Not Registered");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private final void confirmPassword(String firstPass,String secondPass) {
		while(!firstPass.equals(secondPass)) {
			System.out.println("Enter Password");
			firstPass = scanner.nextLine().trim();

			System.out.println("Confirm Password");
			secondPass = scanner.nextLine().trim();
		}
	}
}
