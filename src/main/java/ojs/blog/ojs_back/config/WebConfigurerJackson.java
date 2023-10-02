package ojs.blog.ojs_back.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class WebConfigurerJackson {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer configure_Jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilderCustomizer() {

            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
                builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                // ignore missing filters
                builder.filters(new SimpleFilterProvider().setDefaultFilter(SimpleBeanPropertyFilter.serializeAll()));
                // ignore missing view
                builder.defaultViewInclusion(true);
            }
        };
    }
}
