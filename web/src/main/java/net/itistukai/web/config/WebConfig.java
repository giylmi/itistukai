package net.itistukai.web.config;

import freemarker.template.TemplateException;
import net.itistukai.web.converter.StringToSortTypeConverter;
import net.itistukai.web.interceptor.JsDataInjectionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by giylmi on 02.01.15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"net.itistukai.web.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(10000000);
        return commonsMultipartResolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/templates/");
        configurer.setDefaultEncoding("UTF-8");
        configurer.setFreemarkerSettings(new Properties() {{
            this.put("default_encoding", "UTF-8");
            this.put("url_escaping_charset", "UTF-8");
        }});
        return configurer;
    }

    @Bean
    @Autowired
    public freemarker.template.Configuration freeMarkerConfiguration(
            FreeMarkerConfig configurer) {
        return configurer.getConfiguration();
    }

    @Bean
    public ViewResolver setupViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(false);
        viewResolver.setSuffix(".ftl");
        viewResolver.setPrefix("");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setRequestContextAttribute("rc");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(86400);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages/userForm", "messages/site");
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        DefaultMessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();
        messageCodesResolver.setMessageCodeFormatter(DefaultMessageCodesResolver.Format.POSTFIX_ERROR_CODE);
        return messageCodesResolver;
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.forLanguageTag("ru"));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JsDataInjectionInterceptor());
        registry.addInterceptor(localeChangeInterceptor());
//        registry.addInterceptor(new StaticMappingInjectionInterceptor());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToSortTypeConverter());
    }

    @Bean
    public static WebApplicationContextAware applicationContextAware(){
        return new WebApplicationContextAware();
    }
}
