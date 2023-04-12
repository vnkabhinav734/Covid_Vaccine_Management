package view.main;

import controller.vaccinationDetails.VaccinationDetailsController;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationDetails.VaccinationDetails;
import model.vaccinationDetails.VaccinationDetailsImpl;
import view.appointment.BookAppointmentView;
import view.vaccinationCentre.ShowVaccinationCentres;

import java.util.List;

public class ShowDetails extends User implements IShowDetails{

	private VaccinationDetails vac_details = new VaccinationDetails();

	@Override
	public void showUserDetails(User user) {
		System.out.println("\nUSER DETAILS\n");
		System.out.println("Name:     "+user.getFirstName()+" "+ user.getLastName());
		System.out.println("DOB:      "+user.getDateOfBirth());
		System.out.println("Gender:   "+user.getGender());
		System.out.println("Address:  "+user.getAddress()+" "+user.getAddressZipCode()+" "+user.getAddressCity());
	}

	@Override
	public void showVaccinationDetails(User user)
	{
		try
		{
			VaccinationDetailsImpl vaccinationDetailsImpl=new VaccinationDetailsImpl();
			VaccinationDetailsController vac_con = new VaccinationDetailsController(vaccinationDetailsImpl);
			System.out.println("\n *Vaccination Details*\n ");
			vac_details = vac_con.fetchVaccinationDetails(user);
			if(vac_details.getVaccination_status().contains("vaccinated")) {
				System.out.println("Vaccination_status:       " +vac_details.getVaccination_status());
			}
			else {
				System.out.println("Not Vaccinated ");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void showVaccineCentres(User user){
		ShowVaccinationCentres showCentre = new ShowVaccinationCentres();
		BookAppointmentView bk = new BookAppointmentView();
		if(vac_details.getVaccination_status().contains("fully")){
			System.out.println("Fully Vaccinated");
		}
		else {
			System.out.println("\n BOOK YOUR APPOINTMENT\n ");
			List<VaccinationCentreDetails> vac_centres = showCentre.showVaccinationCentres(user);
			bk.bookAppointment(user, vac_centres);
		}
	}

}
