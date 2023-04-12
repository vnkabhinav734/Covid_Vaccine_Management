import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import backend.LoginController;
import backend.LoginImpl;
import backend.User;

@TestInstance(Lifecycle.PER_CLASS)
public class LoginControllerTest {
	
	LoginController loginController;
	LoginImpl loginImpl;
	static User user=new User();
	
	@BeforeAll
	public void setup() {
		loginImpl= Mockito.mock(LoginImpl.class);
		loginController=new LoginController(loginImpl);
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
	public void userLoginByEmailTestSuccess() {
		try {
			when(loginImpl.getPasswordByEmail(user.getEmailId())).thenReturn(user);
			when(loginImpl.userCheck(user, user.getPassword())).thenReturn(user);
			assertEquals(user,loginController.userLoginByEmail(user.getEmailId(), user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void userLoginByEmailTestFailure() {
		try {
			when(loginImpl.getPasswordByEmail(user.getEmailId())).thenReturn(user);
			when(loginImpl.userCheck(user, user.getPassword())).thenReturn(user);
			assertEquals(null,loginController.userLoginByEmail(user.getEmailId(), "abc"));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void userLoginByPhoneTestSuccess() {
		try {
			when(loginImpl.getPasswordByPhoneNumber(user.getMobileNumber())).thenReturn(user);
			when(loginImpl.userCheck(user, user.getPassword())).thenReturn(user);
			assertEquals(user,loginController.userLoginByPhone(user.getMobileNumber(), user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void userLoginByPhoneTestFailure() {
		try {
			when(loginImpl.getPasswordByPhoneNumber(user.getMobileNumber())).thenReturn(user);
			when(loginImpl.userCheck(user, user.getPassword())).thenReturn(user);
			assertEquals(null,loginController.userLoginByPhone(user.getMobileNumber(), "abc"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
