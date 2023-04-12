package model.user;

public final class Gender {
	public static final String male = "MALE";

	public static final String female = "FEMALE";

	public static final String other = "OTHER";

	public static boolean isGenderValid(final String gender) {
		switch (gender) {
		case male:
		case female:
		case other:
			return true;
		default:
			return false;
		}
	}
}
