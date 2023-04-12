import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import backend.UserUpdateController;
import backend.UserUpdateImpl;
import backend.HealthWorkerUpdateController;
import backend.HealthWorkerUpdateImpl;
import backend.IUserQuery;
import backend.User;
import backend.UserDatabaseColumns;
import backend.UserQuery;
import database.DatabaseConnection;
import database.IDatabaseConnection;

@TestInstance(Lifecycle.PER_CLASS)
public class UserUpdateControllerTest
{
	public UserUpdateController userUpdateController;
	public UserUpdateImpl userUpdateImpl;
	static User user=new User();
	
	@BeforeAll
	public void setup() {
	    userUpdateImpl= Mockito.mock(UserUpdateImpl.class);
		userUpdateController=new UserUpdateController(userUpdateImpl);
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
	public void getUserTestSuccess() {
		when(userUpdateImpl.getUser(user.getFirstName(), user.getLastName(), user.getEmailId())).thenReturn(user);
		assertEquals(user,userUpdateController.getUser(user.getFirstName(), user.getLastName(), user.getEmailId()));
	}
	
	@Test
	public void getUserTestFailure() {
		when(userUpdateImpl.getUser(null, null, user.getEmailId())).thenReturn(null);
		assertEquals(null,userUpdateController.getUser(null, null, user.getEmailId()));
	}
	
	@Test
	public void checkUserExistsSuccess() {
		when(userUpdateImpl.checkUserExists(user.getFirstName(),user.getLastName(),user.getEmailId())).thenReturn(user);
		assertEquals(user,userUpdateController.checkUserExists(user.getFirstName(),user.getLastName(),user.getEmailId()));
	}
	
	@Test
	public void checkUserExistsFailure() {
		when(userUpdateImpl.checkUserExists(null,null,user.getEmailId())).thenReturn(null);
		assertEquals(null,userUpdateController.checkUserExists(null,null,user.getEmailId()));
	}
	
	@Test
	public void updateHealthWorkerDetailsTestSuccess() {
		HashMap<String,String> updateValues=new HashMap<String,String>();
		updateValues.put(UserDatabaseColumns.user_first_name, user.getFirstName());
		when(userUpdateImpl.updateUserDetails(user,updateValues)).thenReturn(true);
		assertEquals(true,userUpdateController.updateUserDetails(user, updateValues));		
	}
	
	@Test
	public void updateHealthWorkerDetailsTestFailure() {
		HashMap<String,String> updateValues=new HashMap<String,String>();
		updateValues.put(UserDatabaseColumns.user_first_name, user.getFirstName());
		when(userUpdateImpl.updateUserDetails(null,updateValues)).thenReturn(false);
		assertEquals(false,userUpdateController.updateUserDetails(null, updateValues));		
	}
}
