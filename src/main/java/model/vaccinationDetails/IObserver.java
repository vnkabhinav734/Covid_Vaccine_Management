package model.vaccinationDetails;

import model.user.User;

public interface IObserver {
    public void update(User user);
}
