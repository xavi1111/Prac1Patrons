package exceptions;

public class LocatorError extends Exception {
    public LocatorError(ClassCastException ex) {
        super(ex);
    }

    public LocatorError() {
        super();
    }
}
