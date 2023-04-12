package model.timeSlots;

import java.sql.Statement;
import java.util.ArrayList;

import database.DatabaseConnection;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.bookAppointment.BookAppointmentQuery;
import model.user.UserFieldValidation;

public class TimeSlotsImpl {

	public boolean addTimeSlot(TimeSlots timeSlotEntry) {
		try {
			ArrayList<String> errorList=validateInputs(timeSlotEntry);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}
			Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
			String insertUserQuery = TimeSlotsQuery.instance().insertSlots(timeSlotEntry);
			int rowCount=statement.executeUpdate(insertUserQuery);
			if (rowCount > 0) {
				return true;
			}
			return false;
		}
		catch(Exception e) {
			DatabaseConnection.instance().stopDatabaseConnection();
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<String> validateInputs(TimeSlots timeSlotEntry){
		ArrayList<String> errorList=new ArrayList<String>();

		if(UserFieldValidation.dateValidation(timeSlotEntry.getDate())) {
			errorList.add("Date is not Valid"); }
		if(UserFieldValidation.timeValidation(timeSlotEntry.getStartTime())) {
			errorList.add("Start time is not Valid"); }
		if(UserFieldValidation.timeValidation(timeSlotEntry.getEndTime())) {
			errorList.add("End time is not Valid"); }
		return errorList;
	}

	public boolean deleteAllTimeSlot(VaccinationCentreDetails centre) {
		try {
			Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
			String deleteSlotsQuery = TimeSlotsQuery.instance().deleteSlots(centre.getCentre_id());
			int rowCount=statement.executeUpdate(deleteSlotsQuery);
			if (rowCount >= 0) {
				BookAppointmentQuery book_query = new BookAppointmentQuery();
				String query=book_query.deleteAppointmentByTimeSlot(centre.getCentre_id());
				statement.executeUpdate(query);
				return true;
			}
			return false;
		}
		catch(Exception e) {
			DatabaseConnection.instance().stopDatabaseConnection();
			e.printStackTrace();
			return false;
		}
	}
}
