package net.itistukai.core.domain.core;

/**
 * Created by adel on 18.02.15.
 */
public enum VideoStatus {

    BANNED(0), NEW(1), VIEWED(2), OK(3);
    private final int value;

    VideoStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
