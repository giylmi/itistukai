package net.itistukai.core.domain.core;

/**
 * Created by adel on 18.02.15.
 */
public enum CompositionStatus {

    ON(0), ARCHIVED(1);
    private final Integer value;

    CompositionStatus(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
