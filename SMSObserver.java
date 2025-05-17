// 1 of 2 observer classes; meant for SMS
public class SMSObserver implements Observer<String> {
    @Override
    public void update(Notification<String> notification) {
        System.out.println("New SMS:" + notification.getContent());
    }

}
