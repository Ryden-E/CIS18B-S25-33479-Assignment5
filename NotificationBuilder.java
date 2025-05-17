// create generic builder class with methods for building notification
// and setting the content 
public class NotificationBuilder<T> {
    private T content;

    public NotificationBuilder(T content) {
        this.content = content;
    }

    public NotificationBuilder<T> setContent(T content) {
        this.content = content;
        return this;
    }

    public Notification<T> build(NotificationFactory<T> factory) {
        return factory.createNotification(content);
    }
}