package view.user;

import controller.userUpdate.IUserUpdateController;
import controller.userUpdate.UserUpdateController;
import model.user.User;
import model.user.UserDatabaseColumns;
import model.user.UserUpdateImpl;

import java.util.HashMap;
import java.util.Scanner;

public class UpdateUser {

	private final Scanner scanner;

	public UpdateUser(final Scanner scanner) {
		this.scanner = scanner;
	}

	public final void update() {
		try {
			System.out.println("Enter First name ");
			final String firstName = scanner.nextLine().trim().toLowerCase();
			System.out.println("Enter Last name ");
			final String lastName = scanner.nextLine().trim().toLowerCase();
			System.out.println("Enter Email ID ");
			final String emailId = scanner.nextLine().trim();

			UserUpdateImpl userUpdateImpl=new UserUpdateImpl();

			final IUserUpdateController userUpdateController = new UserUpdateController(userUpdateImpl);

			User user= userUpdateController.getUser(firstName,lastName,emailId);

			if(user == null)
			{
				System.out.println("User doesn't Exist. Enter proper Details.");
			}
			else
			{
				HashMap<String,String> columnValueUpdate=this.getAllUpdateKeyValues();
				if(columnValueUpdate.size()==0) {
					System.out.println("No Details to Update");
				}
				else
				{
					boolean UserUpdated= userUpdateController.updateUserDetails(user,columnValueUpdate);
					if(UserUpdated)
					{
						System.out.println("User Updated");
					}
					else
					{
						System.out.println("User Not Updated");
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public final HashMap<String,String> getAllUpdateKeyValues()
	{
		HashMap<String,String> columnValue=new HashMap<String,String>();
		boolean breakLoop = true;
		String value = new String();
		while(breakLoop)
		{
			System.out.println("Enter Required Field and Value");
			System.out.println("Enter choice");
			System.out.println("Press 10 to Update all the value fields");
			System.out.println("1. Update First Name\n"
					+ "2. Update Last Name\n"
					+ "3. Update Gender\n"
					+ "4. Update Mobile\n"
					+ "5. Update Email\n"
					+ "6. Update DOB\n"
					+ "7. Update Address\n"
					+ "8. Update City\n"
					+ "9. Update Area Code\n"
					+ "10. Update all the value fields\n");
			String input=scanner.nextLine();
			switch(input)
			{
			case "1":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_first_name, value);
				break;
			case "2":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_last_name, value);
				break;
			case "3":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_gender, value.toUpperCase());
				break;
			case "4":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_mobile, value);
				break;
			case "5":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_email, value);
				break;
			case "6":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_dob, value);
				break;
			case "7":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_address, value);
				break;
			case "8":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_city, value);
				break;
			case "9":
				value=this.setValue(scanner);
				columnValue.put(UserDatabaseColumns.user_zip, value);
				break;
			case "10":
				System.out.println("Updation is in process");
				breakLoop=false;
				break;
			default:
				System.out.println("Enter the correct option");
				break;
			}
		}
		return columnValue;
	}

	public final String setValue(Scanner scanner) {
		System.out.println("Enter value");
		String value=scanner.nextLine().trim();
		return value;
	}
}
