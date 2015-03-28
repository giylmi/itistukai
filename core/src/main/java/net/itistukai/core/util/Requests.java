package net.itistukai.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created by ainurminibaev on 28.03.15.
 */
public class Requests {

    public static String getRequestParams(Map<String, Object> params) {
        StringBuilder request = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            request.append(param.getKey() + "=" + param.getValue());
            request.append('&');
        }
        return request.toString();
    }


    public static <T> T requestForObject(String urlStr, Class<T> clazz) throws IOException {
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(connection.getInputStream(), clazz);
    }
}
