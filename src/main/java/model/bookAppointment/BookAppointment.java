package model.bookAppointment;

public abstract class BookAppointment {
	private String user_id;
	private String time_slot_id;
	private String centre_id;

	public String getTime_slot_id() {
		return this.time_slot_id;
	}

	public void setTime_slot_id(String time_slot_id) {
		this.time_slot_id = time_slot_id;
	}
	public String getUser_id() {
		return this.user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setCentre_id(String centre_id) {
		this.centre_id = centre_id;
	}

	public String getCentre_id() {
		return this.centre_id;
	}
}
