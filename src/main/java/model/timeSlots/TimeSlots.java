package model.timeSlots;

public class TimeSlots {

	private String startTime;
	private String endTime;
	private String centreId;
	private String date;
	private String time_slot_id;
	
	public TimeSlots() {
		super();
	}

	public TimeSlots(String startTime, String endTime, String centreId, String date) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.centreId = centreId;
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime_slot_id(String time_slot_id) {
		this.time_slot_id = time_slot_id;
	}

	public String getTime_slot_id() {
		return this.time_slot_id;
	}
}

