package view.vaccinationCentre;

import controller.vaccinationCentreDetails.VaccinationCentreDetailsController;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

import java.util.ArrayList;
import java.util.List;

public class ShowVaccinationCentres {
	List<VaccinationCentreDetails> vac_centres = new ArrayList<>();
	public List<VaccinationCentreDetails> showVaccinationCentres(User user) {
		int index = 1;
		VaccinationCentreDetailsImpl vaccinationCentreDetails=new VaccinationCentreDetailsImpl();
		VaccinationCentreDetailsController vac_ctrl = new VaccinationCentreDetailsController(vaccinationCentreDetails);
		vac_centres = vac_ctrl.selectVaccinationCentres(user);
		System.out.println("No of Centres in your City: " + vac_centres.size());
		if(vac_centres.size() > 0) {
			System.out.println("* Select a Vaccination Centre *\n");
			System.out.println("Vaccine Centres: ");
			for (VaccinationCentreDetails vac_centre : vac_centres) {
				System.out.println(index + ")           " + vac_centre.getCentre_name());
				System.out.println("Centre code: " + vac_centre.getCentre_code());
				System.out.println("Address:     " + vac_centre.getCentre_address());
				index++;
			}
		}
		return vac_centres;
	}
}
