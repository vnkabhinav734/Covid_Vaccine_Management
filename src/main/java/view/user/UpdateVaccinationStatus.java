package view.user;

import controller.userUpdate.IUserUpdateController;
import controller.userUpdate.IVaccineUpdateController;
import controller.userUpdate.UserUpdateController;
import controller.userUpdate.VaccinationStatusUpdateController;
import model.user.User;
import model.user.UserUpdateImpl;

import java.util.Scanner;

public class UpdateVaccinationStatus {

	private final Scanner scanner;

	public UpdateVaccinationStatus(final Scanner scanner){
		this.scanner=scanner;
	}

	public void updateVaccinationStatus(){
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
		else {
			final IVaccineUpdateController vaccineUpdateController=new VaccinationStatusUpdateController();
			boolean updatedVaccinationStatus= vaccineUpdateController.updateVaccinationStatus(user);
			if(updatedVaccinationStatus) {
				System.out.println("vaccination status updated");
			}
		}
	}
}
