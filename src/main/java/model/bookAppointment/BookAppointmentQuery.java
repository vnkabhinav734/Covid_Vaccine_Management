package model.bookAppointment;

import model.timeSlots.TimeSlots;
import model.timeSlots.TimeSlotsDatabaseColumns;
import model.user.User;

public class BookAppointmentQuery implements IBookAppointmentQuery{

	@Override
	public String getAppointmentSlotsQuery(String centre_id){
		return "Select * From "+ TimeSlotsDatabaseColumns.time_slots_table+" where "+TimeSlotsDatabaseColumns.centre_id+ " = '"+centre_id+"'";
	}

	@Override
	public String insertAppointment(User user, TimeSlots apt) {
		return "insert into " + BookAppointmentDatabaseColumns.bookAppointment_table+ "(" +
				BookAppointmentDatabaseColumns.user_id + ", " +
				BookAppointmentDatabaseColumns.centre_id + ", " +
				BookAppointmentDatabaseColumns.time_slot_id + ")" +
				"values (" +
				"'" + user.getUserId() + "', " +
				"'" + apt.getCentreId() + "', " +
				"'" + apt.getTime_slot_id()+ "');";
	}

	@Override
	public String deleteAppointmentByTimeSlot(String centreId) {
		return "delete from "+ BookAppointmentDatabaseColumns.bookAppointment_table+
				" where "+BookAppointmentDatabaseColumns.centre_id+
				" in ('"+centreId+"')";
	}

	public String deleteAppointmentForUserAndCentre(String userId,String centreId){
		return "delete from "+ BookAppointmentDatabaseColumns.bookAppointment_table+
				" where "+BookAppointmentDatabaseColumns.centre_id+
				" in ('"+centreId+"')"+" and "+BookAppointmentDatabaseColumns.user_id+
				" in ('"+userId+"')";
	}

	@Override
	public String getBookedAppointmentQuery(String user_id){
		return "Select * From "+BookAppointmentDatabaseColumns.bookAppointment_table+" where "+BookAppointmentDatabaseColumns.user_id+ " = '"+user_id+"'";
	}
}
