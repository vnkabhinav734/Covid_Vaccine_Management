import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.vaccinationCentreDetails.VaccinationCentreDetailsController;
import model.user.User;
import model.vaccinationCentre.VaccinationCenterDatabaseColumns;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationCentre.VaccinationCentreDetailsImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class VaccinationCentreDetailsControllerTest {

	VaccinationCentreDetailsController vaccinationCentreDetailsController;
	VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl;
	VaccinationCentreDetails vaccinationCentreDetails=new VaccinationCentreDetails();
	User user=new User();

	@BeforeAll
	public void setup() {
		vaccinationCentreDetailsImpl= Mockito.mock(VaccinationCentreDetailsImpl.class);
		vaccinationCentreDetailsController=new VaccinationCentreDetailsController(vaccinationCentreDetailsImpl);
	}

	@BeforeAll
	public void mockObject() {
		vaccinationCentreDetails.setCentre_id("1298");
		vaccinationCentreDetails.setCentre_name("dal hospital");
		vaccinationCentreDetails.setCentre_address("university");
		vaccinationCentreDetails.setCentre_city("halifax");
		vaccinationCentreDetails.setCentre_code("5691000");
		vaccinationCentreDetails.setCentre_zip("B3L987");
	}

	@Test
	public void updateVaccinationCentreDetailsTestSuccess() {
		when(vaccinationCentreDetailsImpl
				.updateVaccinationCentreDetails(vaccinationCentreDetails.getCentre_id(),VaccinationCenterDatabaseColumns.centre_city, "vancouver"))
		.thenReturn("update successful");
		assertEquals("update successful",vaccinationCentreDetailsController
				.updateVaccinationCentreDetailsController(vaccinationCentreDetails.getCentre_id(),VaccinationCenterDatabaseColumns.centre_city, "vancouver"));
	}

	@Test
	public void updateVaccinationCentreDetailsTestFailure() {
		when(vaccinationCentreDetailsImpl
				.updateVaccinationCentreDetails("1234",VaccinationCenterDatabaseColumns.centre_city, "vancouver"))
		.thenReturn("wrong centre code");
		assertEquals("wrong centre code",vaccinationCentreDetailsController
				.updateVaccinationCentreDetailsController("1234",VaccinationCenterDatabaseColumns.centre_city, "vancouver"));
	}

	@Test
	public void deleteVaccinationCentreDetailsTestSuccess() {
		when(vaccinationCentreDetailsImpl.deleteVaccinationCentreDetails(vaccinationCentreDetails.getCentre_id())).thenReturn("deleted successfully");
		assertEquals("deleted successfully",vaccinationCentreDetailsController
				.deleteVaccinationCentreDetailsController(vaccinationCentreDetails.getCentre_id()));
	}

	@Test
	public void deleteVaccinationCentreDetailsTestFailure() {
		when(vaccinationCentreDetailsImpl.deleteVaccinationCentreDetails("1234")).thenReturn("wrong centre code");
		assertEquals("wrong centre code",vaccinationCentreDetailsController
				.deleteVaccinationCentreDetailsController("1234"));
	}

	@Test
	public void addVaccinationCentreDetailsTestSuccess() {
		when(vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails)).thenReturn(true);
		assertEquals(true,vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails));
	}

	@Test
	public void addVaccinationCentreDetailsTestFailure() {
		when(vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails)).thenReturn(false);
		assertEquals(false,vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccinationCentreDetails));
	}

	@Test
	public void selectVaccinationCentresTestSuccess() {
		List<VaccinationCentreDetails> vaccinationCentres=new ArrayList<VaccinationCentreDetails>();
		when(vaccinationCentreDetailsImpl.getVaccinationCentres(user)).thenReturn(vaccinationCentres);
		assertEquals(vaccinationCentres,vaccinationCentreDetailsController.selectVaccinationCentres(user));
	}

	@Test
	public void selectVaccinationCentresTestFailure() {
		List<VaccinationCentreDetails> vaccinationCentres=new ArrayList<VaccinationCentreDetails>();
		when(vaccinationCentreDetailsImpl.getVaccinationCentres(null)).thenReturn(vaccinationCentres);
		assertEquals(vaccinationCentres,vaccinationCentreDetailsController.selectVaccinationCentres(null));
	}
}
