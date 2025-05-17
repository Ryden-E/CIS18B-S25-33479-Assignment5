// create a generic notification class 
public abstract class Notification<T> {
    private T content;

    public Notification(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

class EmailNotification extends Notification<String> {
    public EmailNotification(String content) {
        super(content);
    }
}

class SMSNotification extends Notification<String> {
    public SMSNotification(String content) {
        super(content);
    }
}