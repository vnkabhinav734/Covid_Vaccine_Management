package controller.userUpdate;

import java.util.HashMap;

import model.user.User;

public interface IUserUpdateController {
    User checkUserExists(final String firstName,final String lastName,final String emailId);
    User getUser(final String firstName,final String lastName,final String emailId);
    boolean updateUserDetails(final User user,final HashMap<String,String> updateValues);
}
