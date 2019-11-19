package assignment1.exception;

public class InvalidInterval extends Exception {
    public InvalidInterval() {
        super("Current time is not within the intake interval");
    }
}
