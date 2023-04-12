package model.bookAppointment;

import model.timeSlots.TimeSlots;
import model.user.User;

public interface IBookAppointmentQuery {
    public String getBookedAppointmentQuery(String user_id);
    public String deleteAppointmentByTimeSlot(String centreId);
    public String insertAppointment(User user, TimeSlots apt);
    public String getAppointmentSlotsQuery(String centre_id);
}
