package br.com.restlabs.config;

import br.com.restlabs.serealization.converter.YamlJackson2HttpConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public static final MediaType MEDIA_TYPE_YAML
            = MediaType.valueOf("application/x-yaml");

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

               configurer.favorParameter(false)
               .ignoreAcceptHeader(false)
               .useRegisteredExtensionsOnly(false)
               .defaultContentType(MediaType.APPLICATION_JSON)
               .mediaType("json",MediaType.APPLICATION_JSON)
               .mediaType("xml",MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_YAML);

    }
}
