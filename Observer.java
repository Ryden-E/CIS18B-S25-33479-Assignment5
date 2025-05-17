// Implement generic observer interface
public interface Observer<T> {
    void update(Notification<T> notification);

}
