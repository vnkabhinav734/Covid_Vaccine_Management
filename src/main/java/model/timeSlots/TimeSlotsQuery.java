package model.timeSlots;

public class TimeSlotsQuery implements ITimeSlotsQuery {

	private static TimeSlotsQuery instance;

	public static TimeSlotsQuery instance() {
		if (instance == null) {
			instance = new TimeSlotsQuery();
		}
		return instance;
	}

	@Override
	public String deleteSlots(String centreid) {
		return "Delete From "+TimeSlotsDatabaseColumns.time_slots_table+
				" where "+TimeSlotsDatabaseColumns.centre_id+ "="+centreid;
	}
	@Override
	public String insertSlots(TimeSlots timeSlotEntry) {
		return "insert into " + TimeSlotsDatabaseColumns.time_slots_table + "(" +
				TimeSlotsDatabaseColumns.start_time + ", " +
				TimeSlotsDatabaseColumns.end_time + ", " +
				TimeSlotsDatabaseColumns.centre_id + ", " +
				TimeSlotsDatabaseColumns.date + ")" +
				"values (" +
				"'" + timeSlotEntry.getStartTime() + "', " +
				"'" + timeSlotEntry.getEndTime() + "', " +
				"'" + timeSlotEntry.getCentreId() + "', " +
				"'" + timeSlotEntry.getDate()+ "');";
	}
}
