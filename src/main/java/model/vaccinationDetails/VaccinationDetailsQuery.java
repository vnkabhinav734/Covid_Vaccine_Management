package model.vaccinationDetails;

public final class VaccinationDetailsQuery{

	private static final String no = "No";

	private static final String not_vaccinated = "";

	public static String fetchVaccinationDetailsQuery(String userId) {
		return "Select * from "+ VaccinationDetailsDatabaseColumns.vaccination_details_table +" where "+VaccinationDetailsDatabaseColumns.user_id+ "='"+userId+"' LIMIT 1";
	}

	public static String insertVaccinationDetails(String userId){
		return "insert into " + VaccinationDetailsDatabaseColumns.vaccination_details_table+ "(" +
		VaccinationDetailsDatabaseColumns.user_id + ", " +
		VaccinationDetailsDatabaseColumns.vaccination_status + ", " +
		VaccinationDetailsDatabaseColumns.dose1 + ", " +
		VaccinationDetailsDatabaseColumns.dose2 + ")" +
		"values (" +
		"'" + userId + "', " +
		"'" + not_vaccinated + "', " +
		"'" + no + "', " +
		"'" + no + "');";
	}
}
