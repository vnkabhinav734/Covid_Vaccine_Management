import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.bookAppointment.BookAppointmentController;
import model.bookAppointment.BookAppointment;
import model.bookAppointment.BookAppointmentImpl;
import model.timeSlots.TimeSlots;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

@TestInstance(Lifecycle.PER_CLASS)
public class BookAppointmentControllerTest {

	private BookAppointmentController bookAppointmentController;
	private BookAppointmentImpl bookAppointmentImpl;
	private User user=new User();
	TimeSlots timeSlots=new TimeSlots();
	VaccinationCentreDetails vaccinationCentreDetails=new VaccinationCentreDetails();

	@BeforeAll
	public void mockTimeSlots() {
		timeSlots.setCentreId("1001");
		timeSlots.setTime_slot_id("300");
		timeSlots.setStartTime("10:00");
		timeSlots.setEndTime("10:20");
		timeSlots.setDate("29-12-2022");
	}

	@BeforeAll
	public void mockUser() {
		user.setUserId("10000");
		user.setFirstName("MockUserFistName");
		user.setLastName("MockUserLastName");
		user.setGender("MALE");
		user.setMobileNumber("7898918377");
		user.setEmailId("mock@gmail.com");
		user.setDateOfBirth("21-1-1997");
		user.setAddress("mockAddress");
		user.setAddressCity("Halifax");
		user.setAddressZipCode("B3L901");
		user.setRole("USER");
		user.setPassword("password");
	}

	@BeforeAll
	public void setup() {
		bookAppointmentImpl= Mockito.mock(BookAppointmentImpl.class);
		bookAppointmentController=new BookAppointmentController(bookAppointmentImpl);
	}

	@Test
	public void addAppointmentTestSuccess() {
		when(bookAppointmentImpl.bookAppointment(timeSlots, user)).thenReturn(true);
		assertEquals(true,bookAppointmentController.addAppointment(timeSlots, user));
	}

	@Test
	public void addAppointmentTestFailure() {
		when(bookAppointmentImpl.bookAppointment(timeSlots,null)).thenReturn(false);
		assertEquals(false,bookAppointmentController.addAppointment(timeSlots, user));
	}

	@Test
	public void getAvailableTimeSlotsTestSuccess() {
		List<TimeSlots> timeSlots=new ArrayList<TimeSlots>();
		when(bookAppointmentImpl
				.getAvailableAppointmentSlots(vaccinationCentreDetails)).thenReturn(timeSlots);
		assertEquals(timeSlots,bookAppointmentController.getAvailableAppointmentSlots(vaccinationCentreDetails));
	}

	@Test
	public void getAvailableTimeSlotsTestFailure() {
		when(bookAppointmentImpl
				.getAvailableAppointmentSlots(vaccinationCentreDetails)).thenReturn(null);
		assertEquals(null,bookAppointmentController.getAvailableAppointmentSlots(vaccinationCentreDetails));
	}

	@Test
	public void getUserAppointmentTestSuccess() {
		List<BookAppointment> listOfBookedAppointment= new ArrayList<BookAppointment>();
		when(bookAppointmentImpl.getBookedAppointments(user)).thenReturn(listOfBookedAppointment);
		assertEquals(listOfBookedAppointment,bookAppointmentController.getUserAppointments(user));
	}

	@Test
	public void getUserAppointmentTestFailure() {
		List<BookAppointment> listOfBookedAppointment= new ArrayList<BookAppointment>();
		when(bookAppointmentImpl.getBookedAppointments(null)).thenReturn(listOfBookedAppointment);
		assertEquals(listOfBookedAppointment,bookAppointmentController.getUserAppointments(null));
	}
}
