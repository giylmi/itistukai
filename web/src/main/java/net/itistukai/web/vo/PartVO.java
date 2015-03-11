package net.itistukai.web.vo;

/**
 * Created by giylmi on 11.03.2015.
 */
public class PartVO {

    private Long id;
    private String text;
    private CompositionVO composition;

    public PartVO(Long id, String text, CompositionVO composition) {
        this.id = id;
        this.text = text;
        this.composition = composition;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CompositionVO getComposition() {
        return composition;
    }

    public void setComposition(CompositionVO composition) {
        this.composition = composition;
    }
}
