package assignment1.exception;

public class UsernameIsTaken extends Exception {

    public UsernameIsTaken() {
        super("Username is already used");
    }

    public UsernameIsTaken(String message) {
        super(message);
    }
}
