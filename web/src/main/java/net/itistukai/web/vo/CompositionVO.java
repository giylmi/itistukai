package net.itistukai.web.vo;

import net.itistukai.core.domain.core.CompositionStatus;

/**
 * Created by giylmi on 11.03.2015.
 */
public class CompositionVO {

    private Long id;
    private String name;
    private CompositionStatus status;

    public CompositionVO(Long id, String name, CompositionStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
