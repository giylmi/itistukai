package net.itistukai.core.domain.core;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

/**
 * Created by adel on 18.02.15.
 */
@Entity
public class Composition {

    @Id
    @SequenceGenerator(name = "compositionGenerator", sequenceName = "composition_sequence")
    @GeneratedValue(generator = "compositionGenerator")
    private Long id;
    private String name;
    private CompositionStatus status;
    @OneToMany(mappedBy = "composition")
    private List<Part> parts;

    public static Comparator<Composition> BY_NAME_COMPARATOR = new Comparator<Composition>() {
        @Override
        public int compare(Composition o1, Composition o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public List<Part> getParts() {
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
