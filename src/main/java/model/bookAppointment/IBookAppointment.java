package model.bookAppointment;

import model.timeSlots.TimeSlots;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.user.User;

import java.util.List;

public interface IBookAppointment {
    public boolean bookAppointment(TimeSlots slot, User user);
    public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre);
}
