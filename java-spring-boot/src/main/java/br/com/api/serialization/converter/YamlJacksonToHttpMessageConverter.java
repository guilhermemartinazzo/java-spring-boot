package br.com.api.serialization.converter;

import br.com.api.utils.MediaTypeUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YamlJacksonToHttpMessageConverter extends AbstractJackson2HttpMessageConverter {
    public YamlJacksonToHttpMessageConverter() {
        super(
                new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL),
                MediaType.parseMediaType(MediaTypeUtils.APPLICATION_YML)
        );
    }
}
