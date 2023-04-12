package model.vaccinationDetails;

import model.user.User;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Subject implements ISubject{
	private List<IObserver> observers;
	private static Subject uniqueInstance = null;
	private Subject(){
		observers = new CopyOnWriteArrayList<IObserver>();
	}
	public static Subject Instance(){
		if(null == uniqueInstance){
			uniqueInstance = new Subject();
		}
		return uniqueInstance;
	}
	@Override
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(User user) {

		for(Iterator<IObserver> itr = observers.iterator(); itr.hasNext();)
		{
			itr.next().update(user);
		}
	}
}
