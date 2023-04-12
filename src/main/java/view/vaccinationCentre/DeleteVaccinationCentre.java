package view.vaccinationCentre;

import java.util.Scanner;

import controller.vaccinationCentreDetails.VaccinationCentreDetailsController;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

public class DeleteVaccinationCentre {

	public void delete(Scanner scanner)
	{
		System.out.println("Enter the Centre-code of the Centre which you want to delete");
		String centre_code=scanner.nextLine();
		VaccinationCentreDetailsImpl vaccinationCentreImpl=new VaccinationCentreDetailsImpl();
		VaccinationCentreDetailsController vaccinationCentreDetailsController=new VaccinationCentreDetailsController(vaccinationCentreImpl);
		String deletionResult=vaccinationCentreDetailsController.deleteVaccinationCentreDetailsController(centre_code);
		System.out.println(deletionResult);
	}
}
