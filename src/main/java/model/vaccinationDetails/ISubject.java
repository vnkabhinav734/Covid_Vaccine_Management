package model.vaccinationDetails;

import model.user.User;

public interface ISubject {
	public void attach(IObserver observer);
	public void detach(IObserver observer);
	public void notifyObservers(User user);
}
