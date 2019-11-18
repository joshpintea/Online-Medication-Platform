package assignment1.exception;

public class IncorrectInterval extends Exception {
    public IncorrectInterval() {
        super("Current time is not within the intake interval");
    }
}
