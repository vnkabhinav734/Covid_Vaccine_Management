package model.vaccinationCentre;

public class VaccinationCentreQuery implements IVaccinationCentreQuery {

	private static VaccinationCentreQuery vaccinationCentreQuery;

	public static VaccinationCentreQuery instance() {
		if (vaccinationCentreQuery == null) {
			vaccinationCentreQuery= new VaccinationCentreQuery();
		}
		return vaccinationCentreQuery;
	}

	@Override
	public String validCentreNumber(String centreCode) {
		return "Select * From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" where "+VaccinationCenterDatabaseColumns.centre_code+ "='"+centreCode+"' LIMIT 1";
	}

	@Override
	public String updateCentreDetails(String centreCode, String updateParameterName,String updateParameterValue) {
		return "Update "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" set "+updateParameterName+"='"+updateParameterValue+
				"' where "+VaccinationCenterDatabaseColumns.centre_code+ "='"+centreCode+"' LIMIT 1";
	}

	@Override
	public String deleteCentreDetails(String centreCode) {
		return "Delete From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" where "+VaccinationCenterDatabaseColumns.centre_code+ "="+centreCode;
	}

	@Override
	public String addCentreDetails(VaccinationCentreDetails vaccineCentreDetails) {
		return "insert into " + VaccinationCenterDatabaseColumns.vaccination_centre_details_table + "(" +
				VaccinationCenterDatabaseColumns.centre_code + ", " +
				VaccinationCenterDatabaseColumns.centre_name + ", " +
				VaccinationCenterDatabaseColumns.centre_address + ", " +
				VaccinationCenterDatabaseColumns.centre_city + ", " +
				VaccinationCenterDatabaseColumns.centre_zip + ")" +	
				"values (" +
				"'" + vaccineCentreDetails.getCentre_code() + "', " +
				"'" + vaccineCentreDetails.getCentre_name() + "', " +
				"'" + vaccineCentreDetails.getCentre_address() + "', " +
				"'" + vaccineCentreDetails.getCentre_city() + "', " +
				"'" + vaccineCentreDetails.getCentre_zip()+ "');";
	}

	public String getVaccinationCentreQuery(String user_city){
		return "Select * From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+" where "+VaccinationCenterDatabaseColumns.centre_city+ "='"+user_city+"'";
	}

}
