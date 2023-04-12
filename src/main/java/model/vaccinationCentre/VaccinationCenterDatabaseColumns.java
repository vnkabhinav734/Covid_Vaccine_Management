package model.vaccinationCentre;

public class VaccinationCenterDatabaseColumns {

	public static VaccinationCenterDatabaseColumns vaccinationCentreDatabaseColumns;

	public static VaccinationCenterDatabaseColumns instance() {
		if (vaccinationCentreDatabaseColumns == null) {
			vaccinationCentreDatabaseColumns= new VaccinationCenterDatabaseColumns();
		}
		return vaccinationCentreDatabaseColumns;
	}
	public static final String vaccination_centre_details_table ="vaccine_centre_details";
	public static final String centre_id ="centre_id";
	public static final String centre_code ="centre_code";
	public static final String centre_name ="centre_name";
	public static final String centre_address="centre_address";
	public static final String centre_city ="centre_city";
	public static final String centre_zip ="centre_zip";
}
