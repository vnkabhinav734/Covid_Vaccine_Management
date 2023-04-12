package model.login;

import model.user.UserDatabaseColumns;

public class LoginQuery implements ILoginQuery {
	
	 private static LoginQuery instance;

	 public static LoginQuery instance() {
		 if (instance == null) {
			 instance = new LoginQuery();
		 }
		 return instance;
	 }

	@Override
	public String loginByEmail(String email) {
		return "Select * From "+ UserDatabaseColumns.user_table+" where "+UserDatabaseColumns.user_email+ "='"+email+"' LIMIT 1";
	}

	@Override
	public String loginByMobile(String mobile) {

		return "Select * From "+UserDatabaseColumns.user_table+" where "+UserDatabaseColumns.user_mobile+ "='"+mobile+"' LIMIT 1";
	}

}
