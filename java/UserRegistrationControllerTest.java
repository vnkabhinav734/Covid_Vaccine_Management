import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Statement;
import java.util.Base64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import backend.IUserQuery;
import backend.IUserRegistrationController;
import backend.User;
import backend.UserDatabaseColumns;
import backend.UserQuery;
import backend.UserRegistrationController;
import backend.UserRegistrationImpl;
import backend.UserType;
import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsController;
import backend.VaccinationCentreDetailsImpl;
import database.DatabaseConnection;
import database.IDatabaseConnection;

@TestInstance(Lifecycle.PER_CLASS)
public class UserRegistrationControllerTest {
	
	UserRegistrationController userRegistrationController;
	UserRegistrationImpl userRegistrationImpl;
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
