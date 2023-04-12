package controller.vaccinationDetails;

import model.user.User;
import model.vaccinationDetails.VaccinationDetails;

public interface IVaccinationDetailsController {
    public VaccinationDetails fetchVaccinationDetails(User user);
}
