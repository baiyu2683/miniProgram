package com.zh.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.nio.charset.Charset;

/**
 * @Author zh2683
 */
@Configuration
public class RedisSerializerConfig {

    @Value("${redis.dateformat}")
    private String dateFormat;

    @Bean
    public FastJsonRedisSerializer<Object> fastJsonRedisSerializer() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat(dateFormat);
//        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        fastJsonConfig.setSerializerFeatures(new SerializerFeature[]{
            SerializerFeature.WriteDateUseDateFormat
        });
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        fastJsonRedisSerializer.setFastJsonConfig(fastJsonConfig);
        return fastJsonRedisSerializer;
    }
}
