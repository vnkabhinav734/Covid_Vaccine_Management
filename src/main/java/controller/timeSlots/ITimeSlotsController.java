package controller.timeSlots;

import model.timeSlots.TimeSlots;
import model.vaccinationCentre.VaccinationCentreDetails;

public interface ITimeSlotsController {
	public boolean addTimeSlot(TimeSlots timeSlotEntry);
	public boolean deleteAllTimeSlot(VaccinationCentreDetails centre);
}
