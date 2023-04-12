package model.vaccinationCentre;

public class VaccinationCentreDetails {

	public String centre_code;
	public String centre_name;
	public String centre_address;
	public String centre_city;
	public String centre_zip;
	public String centre_id;

	public String getCentre_code() {
		return centre_code;
	}
	public VaccinationCentreDetails() {
		super();
	}
	public void setCentre_code(String centre_code) {
		this.centre_code = centre_code;
	}
	public VaccinationCentreDetails(String centre_code, String centre_name, String centre_address, String centre_city,
			String centre_zip) {
		super();
		this.centre_code = centre_code;
		this.centre_name = centre_name;
		this.centre_address = centre_address;
		this.centre_city = centre_city;
		this.centre_zip = centre_zip;
	}
	public String getCentre_name() {
		return centre_name;
	}
	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}
	public String getCentre_address() {
		return centre_address;
	}
	public void setCentre_address(String centre_address) {
		this.centre_address = centre_address;
	}
	public String getCentre_city() {
		return centre_city;
	}
	public void setCentre_city(String centre_city) {
		this.centre_city = centre_city;
	}
	public String getCentre_zip() {
		return centre_zip;
	}
	public void setCentre_zip(String centre_zip) {
		this.centre_zip = centre_zip;
	}
	public String getCentre_id() {
		return centre_id;
	}
	public void setCentre_id(String centre_id) {
		this.centre_id = centre_id;
	}

}
