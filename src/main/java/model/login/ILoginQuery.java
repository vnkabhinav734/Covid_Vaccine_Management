package model.login;

public interface ILoginQuery {
	public String loginByEmail(String email);
	public String loginByMobile(String mobile);
}
