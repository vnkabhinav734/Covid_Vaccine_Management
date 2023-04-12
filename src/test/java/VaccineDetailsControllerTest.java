import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.vaccinationDetails.VaccinationDetailsController;
import model.user.User;
import model.vaccinationDetails.VaccinationDetails;
import model.vaccinationDetails.VaccinationDetailsImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
public class VaccineDetailsControllerTest {

	private VaccinationDetailsController vaccinationDetailsController;
	private VaccinationDetailsImpl vaccinationDetailsImpl;
	VaccinationDetails vaccinationDetails=new VaccinationDetails();
	User user=new User();

	@BeforeAll
	public void setup() {
		vaccinationDetailsImpl=Mockito.mock(VaccinationDetailsImpl.class);
		vaccinationDetailsController=new VaccinationDetailsController(vaccinationDetailsImpl);
	}

	@Test
	public void fetchVaccinationDetailsTestSuccess() {
		when(vaccinationDetailsImpl.selectVaccinationDetails(user))
		.thenReturn(vaccinationDetails);
		assertEquals(vaccinationDetails,vaccinationDetailsController.fetchVaccinationDetails(user));
	}

	@Test
	public void fetchVaccinationDetailsTestFailure() {
		when(vaccinationDetailsImpl.selectVaccinationDetails(null))
		.thenReturn(null);
		assertEquals(null,vaccinationDetailsController.fetchVaccinationDetails(null));
	}

}
