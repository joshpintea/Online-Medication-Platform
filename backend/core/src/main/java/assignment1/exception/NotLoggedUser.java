package assignment1.exception;

public class NotLoggedUser extends Exception {
    public NotLoggedUser() {
    }

    public NotLoggedUser(String message) {
        super(message);
    }
}
