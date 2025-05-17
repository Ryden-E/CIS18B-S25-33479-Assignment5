public class Main {
    public static void main(String[] args) {
        // Sets up factories
        NotificationFactory<String> emailFactory = new EmailNotificationFactory();
        NotificationFactory<String> smsFactory = new SMSNotificationFactory();

        // Create notifications
        Notification<String> email = emailFactory.createNotification("Welcome to MarketBridge!");
        Notification<String> sms = smsFactory.createNotification("New Messages Available");

        Notification<String> builderEmail = new NotificationBuilder<>("Your order has been placed. ETA: 2-5 business days")
            .setContent("Your order has been placed. ETA: 2-5 business days")
            .build(emailFactory);
        Notification<String> builderSMS = new NotificationBuilder<>("Your order has been placed")
            .setContent("Your order has been placed")
            .build(smsFactory);

        // Create observers 
        EmailObserver emailObserver = new EmailObserver();
        SMSObserver smsObserver = new SMSObserver();

        // Sets up manager and observers 
        NotificationManager<String> manager = new NotificationManager<>();
        manager.registerObserver(smsObserver);
        manager.registerObserver(emailObserver);

        // Sends notifications
        manager.sendObserver(email);
        manager.sendObserver(sms);
        manager.sendObserver(builderEmail);
        manager.sendObserver(builderSMS);


        // Demonstrate Type Erasure Awareness: 
        // Parameterized types are erased at runtime so a call like:
        // if (email instanceof Notification<String>) {}
        // wouldn't work because the type information is erased.
        // However, a call without a parameterized type like:
        // if (email instanceof Notification) {}
        // would work because it isn't looking for a generic that has been erased.

        // Demonstrate generic restriction: 
        // Arrays cannot be made with a parameterized type and attempting to do so
        // will result in a compilation error. For example:
        // Notification<String>[] array = new Notification<String>[10];
        // would not work because of the <String> parameter
    }
}
