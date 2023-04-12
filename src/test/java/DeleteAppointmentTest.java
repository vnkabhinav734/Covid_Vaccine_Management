import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.deleteAppointment.DeleteAppointmentController;
import model.bookAppointment.BookAppointmentImpl;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;


@TestInstance(Lifecycle.PER_CLASS)
public class DeleteAppointmentTest {

	private DeleteAppointmentController deleteAppointmentController;
	private BookAppointmentImpl deleteAppointmentImpl;
	User user=new User();
	VaccinationCentreDetails vaccinationCentreDetails=new VaccinationCentreDetails();

	@BeforeAll
	public void setup() {
		deleteAppointmentImpl= Mockito.mock(BookAppointmentImpl.class);
		deleteAppointmentController=new DeleteAppointmentController(deleteAppointmentImpl);
	}

	@BeforeAll
	public void mockUserObject() {
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
	public void mockCentreDetailsObject() {
		vaccinationCentreDetails.setCentre_id("1298");
		vaccinationCentreDetails.setCentre_name("dal hospital");
		vaccinationCentreDetails.setCentre_address("university");
		vaccinationCentreDetails.setCentre_city("halifax");
		vaccinationCentreDetails.setCentre_code("5691000");
		vaccinationCentreDetails.setCentre_zip("B3L987");
	}

	@Test
	public void deleteAppointmentForUserAndCentreTestSuccess() {
		when(deleteAppointmentImpl.deleteAppointmentForUserAndCentre(user, vaccinationCentreDetails)).thenReturn(true);
		assertEquals(true,deleteAppointmentController.deleteAppointmentForUserAndCentre(user, vaccinationCentreDetails));
	}

	@Test
	public void deleteAppointmentForUserAndCentreTestFailure() {
		when(deleteAppointmentImpl.deleteAppointmentForUserAndCentre(user,null)).thenReturn(false);
		assertEquals(false,deleteAppointmentController.deleteAppointmentForUserAndCentre(user,null));
	}

}
