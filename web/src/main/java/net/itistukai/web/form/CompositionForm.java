package net.itistukai.web.form;

import net.itistukai.core.domain.core.CompositionStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by giylmi on 03.03.2015.
 */
public class CompositionForm {

    private String name;
    private MultipartFile file;
    private MultipartFile poster;
    private CompositionStatus status;

    public MultipartFile getPoster() {
        return poster;
    }

    public void setPoster(MultipartFile poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public CompositionStatus getStatus() {
        return status;
    }

    public void setStatus(CompositionStatus status) {
        this.status = status;
    }
}
