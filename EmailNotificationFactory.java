// 1 of 2 concrete factories; for emails
public class EmailNotificationFactory implements NotificationFactory<String> {
    @Override
    public Notification<String> createNotification(String content) {
        return new EmailNotification(content);
    }

}
