package view.user;

import view.appointment.CancelAppointment;

import java.util.Scanner;

public class HealthWorkerPage {

	private void updateUser( Scanner scanner) {
		UpdateUser updateUser = new UpdateUser(scanner);
		updateUser.update();
	}

	private void cancelAppointment(Scanner scanner) {
		CancelAppointment cancelAppointment = new CancelAppointment(scanner);
		cancelAppointment.updateAppointment();

	}

	private void updateVaccinationStatus(Scanner scanner){
		UpdateVaccinationStatus updateVaccinationStatus=new UpdateVaccinationStatus(scanner);
		updateVaccinationStatus.updateVaccinationStatus();
	}

	public void display() {
		final Scanner scanner = new Scanner(System.in);
		final HealthWorkerPage healthWorkerPage = new HealthWorkerPage();
		System.out.println("\n WELCOME HEALTH WORKER \n *Select an option* \n");
		boolean logout = true;
		while (logout) {
			System.out.println("1. Update User Details\n"+
					"2. Update Vaccination Status of User\n"
					+ "3. Cancel Appointment\n"
					+ "4. Logout\n");
			final String input = scanner.nextLine();
			switch (input) {
			case "1":
				healthWorkerPage.updateUser(scanner);
				break;
			case "2":
				healthWorkerPage.updateVaccinationStatus(scanner);
				break;
			case "3":
				healthWorkerPage.cancelAppointment(scanner);
				break;
			case "4":
				System.out.println("Logged Out Successfully \n");
				logout = false;
				break;
			default:
				System.out.println("enter the correct option \n");
				break;
			}

		}
	}
}
