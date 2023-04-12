import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.userUpdate.HealthWorkerUpdateController;
import model.user.HealthWorkerUpdateImpl;
import model.user.User;
import model.user.UserDatabaseColumns;

@TestInstance(Lifecycle.PER_CLASS)
public class HealthWorkerUpdateControllerTest {

	private HealthWorkerUpdateController healthWorkerUpdateController;
	private HealthWorkerUpdateImpl healthWorkerUpdateImpl;
	static User user=new User();

	@BeforeAll
	public void setup() {
		healthWorkerUpdateImpl= Mockito.mock(HealthWorkerUpdateImpl.class);
		healthWorkerUpdateController=new HealthWorkerUpdateController(healthWorkerUpdateImpl);
	}

	@BeforeAll
	public void mockObject() {
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

	@Test
	public void getHealthWorkerTestSuccess() {
		when(healthWorkerUpdateImpl.getUser(user.getFirstName(), user.getLastName(),user.getEmailId())).thenReturn(user);
		assertEquals(user,healthWorkerUpdateController.getHealthWorker(user.getFirstName(),user.getLastName(),user.getEmailId()));
	}

	@Test
	public void getHealthWorkerTestFailure() {
		when(healthWorkerUpdateImpl.getUser(null,null,null)).thenReturn(null);
		assertEquals(null,healthWorkerUpdateController.getHealthWorker(null,null,null));
	}

	@Test
	public void checkUserExistsSuccess() {
		when(healthWorkerUpdateImpl.checkUserExists(user.getFirstName(),user.getLastName(),user.getEmailId())).thenReturn(user);
		assertEquals(user,healthWorkerUpdateController.checkHealthWorkerExists(user.getFirstName(),user.getLastName(),user.getEmailId()));
	}

	@Test
	public void checkUserExistsFailure() {
		when(healthWorkerUpdateImpl.checkUserExists(null,null,null)).thenReturn(null);
		assertEquals(null,healthWorkerUpdateController.checkHealthWorkerExists(null,null,null));
	}

	@Test
	public void updateHealthWorkerDetailsTestSuccess() {
		HashMap<String,String> updateValues=new HashMap<String,String>();
		updateValues.put(UserDatabaseColumns.user_first_name, user.getFirstName());
		when(healthWorkerUpdateImpl.updateUserDetails(user,updateValues)).thenReturn(true);
		assertEquals(true,healthWorkerUpdateController.updateHealthWorkerDetails(user, updateValues));		
	}

	@Test
	public void updateHealthWorkerDetailsTestFailure() {
		HashMap<String,String> updateValues=new HashMap<String,String>();
		updateValues.put(UserDatabaseColumns.user_first_name, user.getFirstName());
		when(healthWorkerUpdateImpl.updateUserDetails(null,updateValues)).thenReturn(false);
		assertEquals(false,healthWorkerUpdateController.updateHealthWorkerDetails(null, updateValues));		
	}
}
