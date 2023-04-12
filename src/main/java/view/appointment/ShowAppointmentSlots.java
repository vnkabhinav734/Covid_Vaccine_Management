package view.appointment;

import controller.bookAppointment.BookAppointmentController;
import model.bookAppointment.BookAppointment;
import model.bookAppointment.BookAppointmentImpl;
import model.timeSlots.TimeSlots;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

import java.util.List;

public class ShowAppointmentSlots {

	BookAppointmentImpl bookImpl=new BookAppointmentImpl();

	BookAppointmentController bk_ctrl = new BookAppointmentController(bookImpl);

	TimeSlots slot = new TimeSlots();

	private List<TimeSlots> timeSlots;

	public void showAvailableSlots(VaccinationCentreDetails vac_details){
		int index=1;
		System.out.println("Centre_name: "+ vac_details.getCentre_name()+" 	id: "+ vac_details.centre_id);
		timeSlots = bk_ctrl.getAvailableAppointmentSlots(vac_details);
		if(timeSlots.isEmpty())
		{
			System.out.println("No Time-Slots available at this Centre !!");
		}
		else {
			System.out.println("Available Time Slots: ");
			for (TimeSlots timeSlot : timeSlots) {
				System.out.println(index + ")	 Date: " + timeSlot.getDate()+"			Time: " + timeSlot.getStartTime() + " " + timeSlot.getEndTime());
				index++;
			}
		}
	}
	public boolean checkUserAppointmentSlot(int index, User user){
		boolean flag = false;
		if(index < timeSlots.size()){
			slot = timeSlots.get(index);
			if(bk_ctrl.addAppointment(slot,user)) {
				flag = true;
			}
		}
		else{
			flag = false;
		}
		return flag;
	}

	public void showBookedAppointment(User user)
	{
		List<BookAppointment> bookedAppointments;
		bookedAppointments = bk_ctrl.getUserAppointments(user);
		if(bookedAppointments.size() > 0){
			int index = 1;
			for (BookAppointment bookAppointment : bookedAppointments){
				System.out.println(index + " User_id " + bookAppointment.getUser_id()+" Centre_id: "+ bookAppointment.getCentre_id()+" Time_slot_id: "+ bookAppointment.getTime_slot_id());
				index++;
			}
		}
		else{
			System.out.println("No Appointment Found !!");
		}
	}

}
