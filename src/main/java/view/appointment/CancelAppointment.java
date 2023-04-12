package view.appointment;

import controller.deleteAppointment.DeleteAppointmentController;
import controller.deleteAppointment.IDeleteAppointmentController;
import controller.userUpdate.IUserUpdateController;
import controller.userUpdate.UserUpdateController;
import model.bookAppointment.BookAppointmentImpl;
import model.user.User;
import model.user.UserUpdateImpl;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

import java.util.Scanner;


public class CancelAppointment {
	private final Scanner scanner;

	public CancelAppointment(Scanner scanner) {
		this.scanner = scanner;
	}

	public final void updateAppointment() {
		System.out.println("Enter First name ");
		final String firstName = scanner.nextLine().trim().toLowerCase();
		System.out.println("Enter Last name ");
		final String lastName = scanner.nextLine().trim().toLowerCase();
		System.out.println("Enter Email ID ");
		final String emailId = scanner.nextLine().trim();

		UserUpdateImpl userUpdateImpl=new UserUpdateImpl();

		final IUserUpdateController userUpdateController = new UserUpdateController(userUpdateImpl);

		User user = userUpdateController.getUser(firstName, lastName, emailId);

		if (user == null)
		{
			System.out.println("User doesn't Exist. Enter proper Details.");
		}
		else {
			System.out.println("Enter Centre Code");
			final String centreCode = scanner.nextLine().trim().toLowerCase();

			VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl=new VaccinationCentreDetailsImpl();

			VaccinationCentreDetails centre = vaccinationCentreDetailsImpl.checkVaccineCentreExists(centreCode);

			if (centre == null) {
				System.out.println("Centre doesn't Exist. Enter proper Centre Code.");
			} else {
				BookAppointmentImpl deleteAppointmentImpl=new BookAppointmentImpl();
				IDeleteAppointmentController deleteAppointmentController=new DeleteAppointmentController(deleteAppointmentImpl);
				boolean result=deleteAppointmentController.deleteAppointmentForUserAndCentre(user,centre);
				if(result){
					System.out.println("Appointment Cancelled Successfully");
				}
				else{
					System.out.println("Error in Cancellation");
				}
			}
		}
	}
}