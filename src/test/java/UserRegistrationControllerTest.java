import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import controller.userRegistration.UserRegistrationController;
import model.user.User;
import model.user.UserRegistrationImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class UserRegistrationControllerTest {

	private UserRegistrationController userRegistrationController;
	private UserRegistrationImpl userRegistrationImpl;
	User user=new User();

	@BeforeAll
	public void setup() {
		userRegistrationImpl= Mockito.mock(UserRegistrationImpl.class);
		userRegistrationController=new UserRegistrationController(userRegistrationImpl);
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
	public void userRegistrationTestSuccess() {
		when(userRegistrationImpl.register(user)).thenReturn(true);
		assertEquals(true,userRegistrationController.register(user));
	}

	@Test
	public void userRegistrationTestFailure() {
		when(userRegistrationImpl.register(null)).thenReturn(false);
		assertEquals(false,userRegistrationController.register(null));
	}

}
