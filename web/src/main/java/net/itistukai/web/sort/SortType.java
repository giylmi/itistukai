package net.itistukai.web.sort;

import org.springframework.data.domain.Sort;

/**
 * Created by giylmi on 13.03.2015.
 */
public enum SortType {

    BY_DATE_DESC("date_desc"),
    BY_NUMBER_ASC("part.number_asc");

    private String value;
    private String fieldName;
    private Sort.Direction direction;

    SortType(String s) {
        this.value = s;
        fieldName = s.substring(0, s.indexOf('_'));
        direction = Sort.Direction.fromString(s.substring(s.indexOf('_') + 1));
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public static SortType byValue(String value){
        for (SortType sortType: SortType.values())
            if (sortType.value.equals(value))
                return sortType;
        return null;
    }

}
