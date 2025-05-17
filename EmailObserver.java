// 1 of 2 observer classes; meant for emails
public class EmailObserver implements Observer<String> {
    @Override
    public void update(Notification<String> notification) {
        System.out.println("New Email:" + notification.getContent());
    }
}
