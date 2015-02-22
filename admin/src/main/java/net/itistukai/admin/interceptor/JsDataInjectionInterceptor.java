package net.itistukai.admin.interceptor;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JsDataInjectionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle( HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler,
                            ModelAndView modelAndView ) throws Exception {
//
        if (null == modelAndView) return;

        Map<String, Object> jsObjects = null;
        for ( Map.Entry<String, Object> entry : modelAndView.getModelMap().entrySet() ) {
            if (entry.getKey().startsWith( "js_" )) {
                if (null == jsObjects)
                    jsObjects = new HashMap<>( );
                jsObjects.put( entry.getKey().substring(3), entry.getValue() );
            }
        }
        if (jsObjects != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            String jsData = mapper.writeValueAsString( jsObjects );
            modelAndView.getModelMap().addAttribute( "__js_data__",
                    jsData
            );
        }
    }
}