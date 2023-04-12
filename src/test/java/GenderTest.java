import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.user.Gender;

public class GenderTest {

	@Test
	public void isGenderValidTest() {
		Assertions.assertTrue(Gender.isGenderValid("MALE"));
		Assertions.assertTrue(Gender.isGenderValid("FEMALE"));
		Assertions.assertTrue(Gender.isGenderValid("OTHER"));
		Assertions.assertFalse(Gender.isGenderValid("NegativeTest"));
	}

}
