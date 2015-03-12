package net.itistukai.core.domain.core;

import javax.persistence.*;
import java.util.Comparator;

/**
 * Created by adel on 18.02.15.
 */
@Entity
public class Part {

    @Id
    @SequenceGenerator(name = "partGenerator", sequenceName = "part_sequence")
    @GeneratedValue(generator = "partGenerator")
    private Long id;
    private Long number;
    @ManyToOne
    private Composition composition;
    private String text;

    public static Comparator<Part> BY_NUMBER_COMPARATOR = new Comparator<Part>() {
        @Override
        public int compare(Part o1, Part o2) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
