package controller.bookAppointment;

import java.util.List;

import model.bookAppointment.BookAppointment;
import model.timeSlots.TimeSlots;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

public interface IBookAppointmentController {
	public boolean addAppointment(TimeSlots slot,User user);
	public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre);
	public List<BookAppointment> getUserAppointments(User user);
}
