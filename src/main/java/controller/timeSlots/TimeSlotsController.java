package controller.timeSlots;

import model.timeSlots.TimeSlots;
import model.timeSlots.TimeSlotsImpl;
import model.vaccinationCentre.VaccinationCentreDetails;

public class TimeSlotsController implements ITimeSlotsController{

	TimeSlotsImpl timeSlotsImpl;

	public TimeSlotsController(TimeSlotsImpl timeSlotsImpl) {
		this.timeSlotsImpl=timeSlotsImpl;
	}

	public boolean addTimeSlot(TimeSlots timeSlotEntry) {
		return timeSlotsImpl.addTimeSlot(timeSlotEntry);
	}

	public boolean deleteAllTimeSlot(VaccinationCentreDetails centre) {
		return timeSlotsImpl.deleteAllTimeSlot(centre);
	}
}
