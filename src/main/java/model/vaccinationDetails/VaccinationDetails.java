package model.vaccinationDetails;

public class VaccinationDetails{
	private String user_id;
	private String vaccination_status;
	private String vaccine_name;
	private String dose1;
	private String dose1_date;
	private String dose1_healthworker;
	private String dose1_vaccinationcenter;
	private String dose2;
	private String dose2_date;
	private String dose2_healthworker;
	private String dose2_vaccinationcenter;


	public void setDose1(String dose1) {
		this.dose1 = dose1;
	}

	public void setDose1_date(String dose1_date) {
		this.dose1_date = dose1_date;
	}

	public void setDose1_healthworker(String dose1_healthworker) {
		this.dose1_healthworker = dose1_healthworker;
	}

	public void setDose1_vaccinationcenter(String dose1_vaccinationcenter) {
		this.dose1_vaccinationcenter = dose1_vaccinationcenter;
	}

	public void setDose2(String dose2) {
		this.dose2 = dose2;
	}

	public void setDose2_date(String dose2_date) {
		this.dose2_date = dose2_date;
	}

	public void setDose2_healthworker(String dose2_healthworker) {
		this.dose2_healthworker = dose2_healthworker;
	}

	public void setDose2_vaccinationcenter(String dose2_vaccinationcenter) {
		this.dose2_vaccinationcenter = dose2_vaccinationcenter;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setVaccination_status(String vaccination_status) {
		this.vaccination_status = vaccination_status;
	}

	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}

	public String getDose1() {
		return this.dose1;
	}

	public String getDose1_date() {
		return this.dose1_date;
	}

	public String getDose1_healthWorker() {
		return this.dose1_healthworker;
	}

	public String getDose1_vaccinationCenter() {
		return this.dose1_vaccinationcenter;
	}

	public String getDose2() {
		return this.dose2;
	}

	public String getDose2_date() {
		return this.dose2_date;
	}

	public String getDose2_healthWorker() {
		return this.dose2_healthworker;
	}

	public String getVaccination_status() {
		return this.vaccination_status;
	}

	public String getVaccine_name() {
		return vaccine_name;
	}

	public String getDose2_vaccinationCenter() {
		return dose2_vaccinationcenter;
	}

	public String getUser_id() {
		return user_id;
	}

}
