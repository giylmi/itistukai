package net.itistukai.web.converter;

import net.itistukai.web.sort.SortType;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by giylmi on 14.03.2015.
 */
public class StringToSortTypeConverter implements Converter<String, SortType> {
    @Override
    public SortType convert(String s) {
        return SortType.byValue(s);
    }
}
