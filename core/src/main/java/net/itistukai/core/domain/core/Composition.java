package net.itistukai.core.domain.core;

import net.itistukai.core.exception.NotIncludedException;

import java.util.List;

/**
 * Created by adel on 18.02.15.
 */
public class Composition {

    private Long id;
    private String name;
    private CompositionStatus status;
    private List<Part> parts;

    public List<Part> getParts() {
        if (parts == null) throw new NotIncludedException("Parts were not included sql query");
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompositionStatus getStatus() {
        return status;
    }

    public void setStatus(CompositionStatus status) {
        this.status = status;
    }
}
