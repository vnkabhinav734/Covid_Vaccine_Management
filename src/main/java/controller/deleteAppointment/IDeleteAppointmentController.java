package controller.deleteAppointment;

import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

public interface IDeleteAppointmentController {
	public boolean deleteAppointmentForUserAndCentre(User user,VaccinationCentreDetails centre);
}
