package br.com.api.config;

import br.com.api.serialization.converter.YamlJacksonToHttpMessageConverter;
import br.com.api.utils.MediaTypeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf(MediaTypeUtils.APPLICATION_YML);

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJacksonToHttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        /** Configuration to content negotiation via Query Param
         configurer.favorParameter(true)
         .parameterName("mediaType")
         .ignoreAcceptHeader(true)
         .useRegisteredExtensionsOnly(false)
         .defaultContentType(MediaType.APPLICATION_JSON)
         .mediaType("json", MediaType.APPLICATION_JSON)
         .mediaType("xml", MediaType.APPLICATION_XML)
         ;
         **/

        configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML)
        ;

    }
}
