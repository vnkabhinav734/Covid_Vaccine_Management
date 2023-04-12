package view.user;
import view.timeSlots.AddTimeSlots;
import view.timeSlots.DeleteAllTimeSlots;
import view.vaccinationCentre.AddVaccinationCenter;
import view.vaccinationCentre.DeleteVaccinationCentre;
import view.vaccinationCentre.UpdateVaccinationCentre;

import java.util.Scanner;

public class AdminPage {

	private void updateHealthWorker(final Scanner scanner) {
		UpdateHealthWorker updateHealthWorker =new UpdateHealthWorker(scanner);
		updateHealthWorker.update();
	}

	private void addVaccinationCenter(final Scanner scanner) {
		AddVaccinationCenter addVaccinationCenter =new AddVaccinationCenter(scanner);
		addVaccinationCenter.add();
	}

	private void updateVaccinationCenter(final Scanner scanner){

		UpdateVaccinationCentre updateVaccinationCentre=new UpdateVaccinationCentre();
		try {
			updateVaccinationCentre.display(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteVaccinationCentre(final Scanner scanner) {

		DeleteVaccinationCentre deleteVaccinationCentre=new DeleteVaccinationCentre();
		deleteVaccinationCentre.delete(scanner);
	}

	private void addTimeSlots(final Scanner scanner) {
		AddTimeSlots addTimeSlots=new AddTimeSlots(scanner);
		addTimeSlots.add();
	}

	private void deleteAllTimeSlots(final Scanner scanner) {
		DeleteAllTimeSlots deleteAllTimeSlots=new DeleteAllTimeSlots(scanner);
		deleteAllTimeSlots.deleteAll();
	}

	public void display(){
		final Scanner scanner=new Scanner(System.in);
		final AdminPage adminPage = new AdminPage();
		System.out.println("\n WELCOME ADMIN \n*Select an option*\n");
		boolean logout=true;
		while(logout) {
			System.out.println("1. Update Health Worker\n"
					+ "2. Add Vaccination center\n"
					+ "3. Update Vaccination center\n"
					+ "4. Delete Vaccination center\n"
					+ "5. Add Time slots\n"
					+ "6. Delete all Time slots for a center\n"
					+ "7. Logout \n");
			final String input = scanner.nextLine();
			switch(input) {
			case "1":
				adminPage.updateHealthWorker(scanner);
				break;
			case "2": 
				adminPage.addVaccinationCenter(scanner);
				break;
			case "3":
				adminPage.updateVaccinationCenter(scanner);
				break;
			case "4":
				adminPage.deleteVaccinationCentre(scanner);
				break;
			case "5":
				adminPage.addTimeSlots(scanner);
				break;
			case "6":
				adminPage.deleteAllTimeSlots(scanner);
				break;
			case "7":
				System.out.println("Logged out Successfully");
				logout=false;
				break;
			default: System.out.println("Enter the correct option");
			break;
			}
		}

	}
}
