
import backend.Gender;
import backend.UserFieldValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserFieldValidationTest {	
	@Test
	public void nameValidationTest() {
		Assertions.assertTrue(!!UserFieldValidation.nameValidation("***"));
		Assertions.assertFalse(!!UserFieldValidation.nameValidation("TestName"));
	}

	@Test
	public void genderValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.genderValidation(Gender.male));
		Assertions.assertFalse(!UserFieldValidation.genderValidation("NotAValidGender"));
	}
	
	@Test
	public void dateValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.dateValidation("02-02-2020"));
		Assertions.assertFalse(!UserFieldValidation.dateValidation("99-99-9999"));
	}

	@Test
	public void emailValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.emailValidation("nikhil@gmail.com"));
		Assertions.assertFalse(!UserFieldValidation.emailValidation("test@com"));
	}

	@Test
	public void passwordValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.passwordValidation("Test@123"));
		Assertions.assertFalse(!UserFieldValidation.passwordValidation("NotAValidPassword"));
	}
	
	@Test
	public void mobileNumberValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.mobileNumberValidation("123456789"));
		Assertions.assertFalse(!UserFieldValidation.mobileNumberValidation("testNumber"));
	}
	
	@Test
	public void areaCodeValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.areaCodeValidation("B3K9K3"));
		Assertions.assertFalse(!UserFieldValidation.areaCodeValidation("AreaCodeTest"));
	}
	
	@Test
	public void isEmptyStringTest() {
		Assertions.assertTrue(!UserFieldValidation.isEmptyString("EmptyStringTest"));
		Assertions.assertFalse(!UserFieldValidation.isEmptyString(null));
	}
	
	@Test
	public void timeValidationTest() {
		Assertions.assertTrue(!UserFieldValidation.timeValidation("12:00"));
		Assertions.assertFalse(!UserFieldValidation.timeValidation("99:99"));
	}
	
}
