package headfirst.designpatterns.combining.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class MallardDuck extends java.util.Observable implements Quackable {		// java.util.Observable을 사용하기 위해 상속한다.
	//Observable observable;
	ArrayList<Observer> observers = new ArrayList<Observer>();	// 오리 객체 자체에서 등록돼야 하므로 오리가 들어갈 객체 배열이 있어야 한다.
	java.util.Observer observer;		// register 메소드를 통해 등록되는 observer를 notify에도 사용하기 위해 저장하는 객체.
 
	public MallardDuck() {
		//observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}
	public void registerObserver(java.util.Observer observer) {
		//observable.registerObserver(observer);
		//observers.add(observer);		// ArrayList에 등록하는 것이므로 add 메소드를 이용한다.
		addObserver(observer);		// java.util.Observable에 있는 메소드를 사용해 등록한다.
		this.observer = observer;		// 다른 메소드에서 이용하기 위해 전해받은 observer를 해당 객체에 만들어진 Observer에 저장한다.
	}
	@Override
	public void registerObserver(Observer observer) {

	}

	public void notifyObservers() {
		//observable.notifyObservers();
		/*Iterator<Observer> iterator = observers.iterator();	// observable에 있는 메소드와 비슷한 구조로 진행된다.
		while (iterator.hasNext()) {
			Observer observer = iterator.next();
			observer.update(this);		// observable이 없고, 각 오리 객체에서 옵저버가 등록되고 업데이트 돼야 하므로, 'observable' 대신 this로 해당 오리 객체가 들어가야 한다.
		}*/
		notifyObservers(observer);		// register 메소드를 통해 저장된 observer를 사용해서 상황을 알리는 java.util.Observable의 notify 메소드를 사용한다.
	}
	public String toString() {
		return "Mallard Duck";
	}
}
