package observerInterfaces;

import java.util.LinkedList;
import java.util.List;

public class Subject {
	private List<Observer> registeredObservers = new LinkedList<Observer>();
	
	public void registerObserver(observerInterfaces.Observer observer) {
		registeredObservers.add(observer);
	}

	public void removeObserver(observerInterfaces.Observer observer) {
		registeredObservers.remove(observer);
	}

	public void notifyObservers() {
		for(Observer observer : registeredObservers) {
			observer.update();
		}
	}
}
