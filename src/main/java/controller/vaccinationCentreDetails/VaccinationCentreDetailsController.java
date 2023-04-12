package controller.vaccinationCentreDetails;

import java.util.ArrayList;
import java.util.List;

import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

public class VaccinationCentreDetailsController {

	private VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl;

	public VaccinationCentreDetailsController(VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl)
	{
		this.vaccinationCentreDetailsImpl=vaccinationCentreDetailsImpl;
	}

	public VaccinationCentreDetailsController() {
		super();
	}

	public String updateVaccinationCentreDetailsController(String centreCode,String updateParameterName, String value) {
		String updateResult=vaccinationCentreDetailsImpl.
				updateVaccinationCentreDetails(centreCode, updateParameterName, value);
		return updateResult;
	}

	public String deleteVaccinationCentreDetailsController(String centreCode) {
		String deleteResult=vaccinationCentreDetailsImpl.deleteVaccinationCentreDetails(centreCode);
		return deleteResult;
	}

	public boolean addVaccinationCentreDetails(VaccinationCentreDetails vaccineCentreDetails) {
		boolean insertionResult=vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccineCentreDetails);
		return insertionResult;
	}
	public List<VaccinationCentreDetails> selectVaccinationCentres(User user){
		List<VaccinationCentreDetails> vac_centres = new ArrayList<>();
		vac_centres = vaccinationCentreDetailsImpl.getVaccinationCentres(user);
		return vac_centres;
	}
}
