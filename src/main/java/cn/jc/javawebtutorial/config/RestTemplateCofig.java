package cn.jc.javawebtutorial.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCofig {

    private static final String CHARSET = "utf-8";
    private static final Integer READ_TIMEOUT = 15000;
    private static final Integer CONNECT_TIMEOUT = 15000;

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate resteTemplate = new RestTemplate(factory);
        List<HttpMessageConverter<?>> converters = resteTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                // remove old ISO-8859-1 codec
                iterator.remove();
            }
        }
        converters.add(getStringHttpMessageConverter());
        // keep Jackson but put FastJson on top
        converters.add(0, getFastJsonHttpMessageConverter());
        return resteTemplate;
    }

    private StringHttpMessageConverter getStringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName(CHARSET));
    }

    private FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonConverter.setDefaultCharset(Charset.forName(CHARSET));
        fastJsonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return fastJsonConverter;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(READ_TIMEOUT);
        factory.setConnectTimeout(CONNECT_TIMEOUT);
        return factory;
    }
}
