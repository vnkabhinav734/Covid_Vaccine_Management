package controller.vaccinationDetails;

import model.user.User;
import model.vaccinationDetails.VaccinationDetails;
import model.vaccinationDetails.VaccinationDetailsImpl;

public class VaccinationDetailsController implements IVaccinationDetailsController{
    private VaccinationDetails vac_details = new VaccinationDetails();
    private VaccinationDetailsImpl vac_impl;
    
    public VaccinationDetailsController(VaccinationDetailsImpl vac_impl) {
    	this.vac_impl=vac_impl;
    }
    
    @Override
    public VaccinationDetails fetchVaccinationDetails(User user) {
        try {
            vac_details = vac_impl.selectVaccinationDetails(user);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return vac_details;
    }

}
