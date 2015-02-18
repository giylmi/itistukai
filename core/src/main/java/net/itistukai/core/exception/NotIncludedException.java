package net.itistukai.core.exception;

/**
 * Created by adel on 18.02.15.
 */
public class NotIncludedException extends RuntimeException {

    public NotIncludedException() {
    }

    public NotIncludedException(String message) {
        super(message);
    }

    public NotIncludedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotIncludedException(Throwable cause) {
        super(cause);
    }

    public NotIncludedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
