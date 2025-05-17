// create abstract factory pattern
public interface NotificationFactory<T> {
    Notification<T> createNotification(T content);

}
