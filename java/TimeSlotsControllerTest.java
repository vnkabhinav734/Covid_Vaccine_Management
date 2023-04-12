import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import backend.TimeSlotsController;
import backend.TimeSlotsDatabaseColumns;
import backend.TimeSlotsImpl;
import backend.TimeSlotsQuery;
import backend.VaccinationCentreDetails;
import backend.ITimeSlotsController;
import backend.ITimeSlotsQuery;
import backend.LoginController;
import backend.LoginImpl;
import backend.TimeSlots;
import database.DatabaseConnection;
import database.IDatabaseConnection;

@TestInstance(Lifecycle.PER_CLASS)
public class TimeSlotsControllerTest {
	
	TimeSlotsController timeSlotsController;
	TimeSlotsImpl timeSlotsImpl;
	TimeSlots timeSlots=new TimeSlots();
	
	@BeforeAll
	public void setup() {
		timeSlotsImpl= Mockito.mock(TimeSlotsImpl.class);
		timeSlotsController=new TimeSlotsController(timeSlotsImpl);
	}
	
	@BeforeAll
	public void mockObject() {
		timeSlots.setCentreId("1001");
		timeSlots.setDate("13-12-2022");
		timeSlots.setStartTime("10:00");
		timeSlots.setEndTime("10:15");
		timeSlots.setTime_slot_id("20");
	}
	
	@Test
	public void addTimeSlotTestSuccess() {
		when(timeSlotsImpl.addTimeSlot(timeSlots)).thenReturn(true);
		assertEquals(true,timeSlotsController.addTimeSlot(timeSlots));
	}
	
	@Test
	public void addTimeSlotTestFailure() {
		when(timeSlotsImpl.addTimeSlot(null)).thenReturn(false);
		assertEquals(false,timeSlotsController.addTimeSlot(null));
	}
	
	@Test
	public void deleteTimeSlotTestSuccess() {
		VaccinationCentreDetails vaccinationCentreDetails=new VaccinationCentreDetails();
		vaccinationCentreDetails.setCentre_id("191");
		vaccinationCentreDetails.setCentre_name("hospital");
		vaccinationCentreDetails.setCentre_city("toronto");
		vaccinationCentreDetails.setCentre_address("testAddress");
		vaccinationCentreDetails.setCentre_code("9001");
		vaccinationCentreDetails.setCentre_zip("B3K901");
		when(timeSlotsImpl.deleteAllTimeSlot(vaccinationCentreDetails)).thenReturn(true);
		assertEquals(true,timeSlotsController.deleteAllTimeSlot(vaccinationCentreDetails));
	}
	
	@Test
	public void deleteTimeSlotTestFailure() {
		when(timeSlotsImpl.deleteAllTimeSlot(null)).thenReturn(false);
		assertEquals(false,timeSlotsController.deleteAllTimeSlot(null));
	}
}
