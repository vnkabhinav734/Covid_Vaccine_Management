package model.vaccinationCentre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.timeSlots.TimeSlotsQuery;
import model.user.User;
import model.user.UserFieldValidation;

public class VaccinationCentreDetailsImpl {
	List<VaccinationCentreDetails> vac_centres = new ArrayList<>();
	public static VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl;


	public String updateVaccinationCentreDetails(String centreCode,String updateParameterName, String value) {
		try {
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String selectResult=VaccinationCentreQuery.instance().validCentreNumber(centreCode);
			ResultSet rs=statement.executeQuery(selectResult);
			if(rs.next())
			{
				Statement updateStatement= connection.createStatement();
				String updateResult= VaccinationCentreQuery.instance().updateCentreDetails(centreCode, updateParameterName,value);
				updateStatement.executeUpdate(updateResult);
				connection.close();
				return "update successful";
			}
			else
			{
				return "wrong centre code";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "wrong centre code";
		}
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}

	public String deleteVaccinationCentreDetails(String centreCode) {
		try
		{
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String selectResult=VaccinationCentreQuery.instance().validCentreNumber(centreCode);
			ResultSet rs=statement.executeQuery(selectResult);
			if(rs.next())
			{
				Statement deleteSlotsQuery=connection.createStatement();
				TimeSlotsQuery vaccinationSlotsQuery=new TimeSlotsQuery();
				String deleteSlots=vaccinationSlotsQuery.deleteSlots(rs.getString(VaccinationCenterDatabaseColumns.centre_id));
				deleteSlotsQuery.execute(deleteSlots);
				Statement deleteCentreQuery=connection.createStatement();
				deleteCentreQuery.execute(VaccinationCentreQuery.instance().deleteCentreDetails(centreCode));
				connection.close();
				return "deleted successfully";
			}
			else
			{
				return "wrong centre code";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
		return centreCode;
	}

	public boolean addVaccinationCentreDetails(VaccinationCentreDetails vaccineCentreDetails) {
		try
		{ 
			ArrayList<String> errorList=validateVaccineCentreDetails(vaccineCentreDetails);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}

			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String insertQuery=VaccinationCentreQuery.instance().addCentreDetails(vaccineCentreDetails);
			int result=statement.executeUpdate(insertQuery);
			if(result>=1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}

	private ArrayList<String> validateVaccineCentreDetails(VaccinationCentreDetails vaccineCentreDetails){
		ArrayList<String> errorList=new ArrayList<String>();

		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_code())) {
			errorList.add("Centre Code is null/empty"); }
		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_name())) {
			errorList.add("Centre Name is null/empty"); }
		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_address())) {
			errorList.add("Centre Address is null/empty"); }
		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_city())) {
			errorList.add("Centre City is null/empty"); }
		if(UserFieldValidation.areaCodeValidation(vaccineCentreDetails.getCentre_zip())) {
			errorList.add("Centre Area Code is not valid"); }
		return errorList;
	}

	public VaccinationCentreDetails checkVaccineCentreExists(String centreCode) {
		try
		{ 
			if(UserFieldValidation.isEmptyString(centreCode)) {
				System.out.println("Centre Code is null/empty");
				return null;
			}
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String selectQuery=VaccinationCentreQuery.instance().validCentreNumber(centreCode);
			ResultSet rs=statement.executeQuery(selectQuery);
			if(rs.next())
			{
				VaccinationCentreDetails vaccineCentre= new VaccinationCentreDetails();
				vaccineCentre.setCentre_id(rs.getString(VaccinationCenterDatabaseColumns.centre_id));
				vaccineCentre.setCentre_name(rs.getString(VaccinationCenterDatabaseColumns.centre_name));
				vaccineCentre.setCentre_code(rs.getString(VaccinationCenterDatabaseColumns.centre_code));
				vaccineCentre.setCentre_address(rs.getString(VaccinationCenterDatabaseColumns.centre_address));
				vaccineCentre.setCentre_zip(rs.getString(VaccinationCenterDatabaseColumns.centre_zip));
				vaccineCentre.setCentre_city(rs.getString(VaccinationCenterDatabaseColumns.centre_city));
				return vaccineCentre;
			}
			else
			{
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}
	public List<VaccinationCentreDetails> getVaccinationCentres(User user) {
		try {
			Connection connection = DatabaseConnection.instance().getDatabaseConnection();
			Statement statement = connection.createStatement();
			String vacCentreQuery = VaccinationCentreQuery.instance().getVaccinationCentreQuery(user.getAddressCity());
			ResultSet rs = statement.executeQuery(vacCentreQuery);
			if(rs.isBeforeFirst()) {
				vac_centres = resultVaccinationCentres(rs);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return vac_centres;
	}

	public List<VaccinationCentreDetails> resultVaccinationCentres(ResultSet rs){
		try{
			while (rs.next()) {
				VaccinationCentreDetails vac_centre = new VaccinationCentreDetails();
				vac_centre.setCentre_id(rs.getString(VaccinationCenterDatabaseColumns.centre_id));
				vac_centre.setCentre_city(rs.getString(VaccinationCenterDatabaseColumns.centre_city));
				vac_centre.setCentre_name(rs.getString(VaccinationCenterDatabaseColumns.centre_name));
				vac_centre.setCentre_address(rs.getString(VaccinationCenterDatabaseColumns.centre_address));
				vac_centre.setCentre_code(rs.getString(VaccinationCenterDatabaseColumns.centre_code));
				vac_centre.setCentre_zip(rs.getString(VaccinationCenterDatabaseColumns.centre_zip));
				vac_centres.add(vac_centre);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
		return vac_centres;
	}
}
