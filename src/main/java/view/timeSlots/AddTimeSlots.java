package view.timeSlots;
import java.util.Scanner;

import controller.timeSlots.TimeSlotsController;
import model.timeSlots.TimeSlots;
import model.timeSlots.TimeSlotsImpl;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

public class AddTimeSlots {
	private final Scanner scanner;

	public AddTimeSlots(final Scanner scanner) {
		this.scanner = scanner;
	}

	public final void add() {
		try {
			VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl=new VaccinationCentreDetailsImpl();
			System.out.println("Enter Centre Code");
			final String centreCode = scanner.nextLine().trim().toLowerCase();

			VaccinationCentreDetails centre=vaccinationCentreDetailsImpl.checkVaccineCentreExists(centreCode);

			if(centre==null) {
				System.out.println("Centre doesn't exist. Enter proper Centre Code.");
			}
			else {
				this.addTimeSlots(centre);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public final void addTimeSlots(VaccinationCentreDetails centre) {
		try {	
			System.out.println("Enter Date");
			final String date = scanner.nextLine().trim();
			System.out.println("Enter Start time(24 hours format ex.13:00 for 1 pm)");
			final String startTime = scanner.nextLine().trim();
			System.out.println("Enter End time(24 hours format ex.13:00 for 1 pm)");
			final String endTime = scanner.nextLine().trim();

			TimeSlots timeSlotEntry=new TimeSlots();
			timeSlotEntry.setCentreId(centre.getCentre_id());
			timeSlotEntry.setDate(date);
			timeSlotEntry.setStartTime(startTime);
			timeSlotEntry.setEndTime(endTime);

			TimeSlotsImpl timeSlotsImpl=new TimeSlotsImpl();
			TimeSlotsController timeSlotsController=new TimeSlotsController(timeSlotsImpl);

			boolean timeSlotInserted=timeSlotsController.addTimeSlot(timeSlotEntry);

			if(timeSlotInserted) {
				System.out.println("Time-Slot added Successfully");
			}
			else {
				System.out.println("Time-Slot not added");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
