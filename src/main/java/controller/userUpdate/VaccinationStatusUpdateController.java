package controller.userUpdate;

import model.user.User;
import model.user.VaccinationStatusUpdateImpl;

public class VaccinationStatusUpdateController implements IVaccineUpdateController{

	public VaccinationStatusUpdateImpl vaccinationStatusUpdateImpl=new VaccinationStatusUpdateImpl();
	@Override
	public boolean updateVaccinationStatus(User user) {
		return vaccinationStatusUpdateImpl.updateVaccinationStatus(user);
	}
}
