import java.util.*;

public class NotificationManager<T> {
    // use wildcard super to create flexible observers
    private List<Observer<? super T>> observers = new ArrayList<>();

    public void registerObserver(Observer<? super T> observer) {
        observers.add(observer);
    }

    public void sendObserver(Notification<T> notification) {
        for (Observer<? super T> obs : observers) {
            ((Observer<T>) obs).update(notification); // fixed an issue where .update caused a compilation error
                                                      // changed so it still uses a bounded wildcard but does result in
                                                      // an unchecked cast 
        }
    }
}
