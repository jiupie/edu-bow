package com.wl.core.jetcache.config;

import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.alicp.jetcache.anno.support.DefaultSpringEncoderParser;
import com.alicp.jetcache.anno.support.DefaultSpringKeyConvertorParser;
import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.embedded.CaffeineCacheBuilder;
import com.alicp.jetcache.embedded.EmbeddedCacheBuilder;
import com.alicp.jetcache.redis.springdata.RedisSpringDataCacheBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.common.factory.YamlPropertySourceFactory;
import com.wl.core.jetcache.jackson.JacksonKeyConvertor;
import com.wl.core.jetcache.jackson.JacksonValueDecoder;
import com.wl.core.jetcache.jackson.JacksonValueEncoder;
import com.wl.core.jetcache.props.JetcacheProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * JetCache配置
 * @author 南顾北衫
 */
@Configuration
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.wl")
@EnableConfigurationProperties(JetcacheProperties.class)
@PropertySource(factory = YamlPropertySourceFactory.class,value = "classpath:edu-jetcache.yaml")
public class JetCacheConfiguration implements InitializingBean {
    private ObjectMapper cacheMapper;
    @Autowired
    private JetcacheProperties jetcacheProperties;

    @Bean("jacksonKeyConvertor")
    public JacksonKeyConvertor jacksonKeyConvertor() {
        return new JacksonKeyConvertor(new ObjectMapper());
    }

    @Bean("jacksonValueDecoder")
    public JacksonValueDecoder jacksonValueDecoder() {
        return new JacksonValueDecoder(cacheMapper);
    }

    @Bean("jacksonValueEncoder")
    public JacksonValueEncoder jacksonValueEncoder() {
        return new JacksonValueEncoder(cacheMapper);
    }


    @Bean
    public SpringConfigProvider springConfigProvider(ApplicationContext applicationContext) {
        DefaultSpringKeyConvertorParser convertorParser = new DefaultSpringKeyConvertorParser();
        convertorParser.setApplicationContext(applicationContext);
        SpringConfigProvider springConfigProvider = new SpringConfigProvider();
        springConfigProvider.setKeyConvertorParser(convertorParser);
        springConfigProvider.setApplicationContext(applicationContext);
        DefaultSpringEncoderParser encoderParser = new DefaultSpringEncoderParser();
        encoderParser.setApplicationContext(applicationContext);
        springConfigProvider.setEncoderParser(encoderParser);
        return springConfigProvider;
    }

    @Override
    public void afterPropertiesSet() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        this.cacheMapper = mapper;
    }

    @Bean
    public GlobalCacheConfig globalCacheConfig(JacksonKeyConvertor jacksonKeyConvertor,
                                               JacksonValueDecoder jacksonValueDecoder,
                                               JacksonValueEncoder jacksonValueEncoder,
                                               RedisConnectionFactory redisConnectionFactory) {
        EmbeddedCacheBuilder<CaffeineCacheBuilder.CaffeineCacheBuilderImpl> localBuilder = CaffeineCacheBuilder.createCaffeineCacheBuilder().keyConvertor(jacksonKeyConvertor);

        Map<String, CacheBuilder> localBuilders = new HashMap<>(6);
        localBuilders.put(CacheConsts.DEFAULT_AREA, localBuilder);


        RedisSpringDataCacheBuilder<?> redisSpringDataCacheBuilder = RedisSpringDataCacheBuilder.createBuilder()
                .keyConvertor(jacksonKeyConvertor)
                .valueEncoder(jacksonValueEncoder)
                .valueDecoder(jacksonValueDecoder)
                //redis连接
                .connectionFactory(redisConnectionFactory);


        Map<String, CacheBuilder> remoteBuilders = new HashMap<>(6);
        remoteBuilders.put(CacheConsts.DEFAULT_AREA, redisSpringDataCacheBuilder);

        GlobalCacheConfig globalCacheConfig = new GlobalCacheConfig();
        globalCacheConfig.setLocalCacheBuilders(localBuilders);
        globalCacheConfig.setRemoteCacheBuilders(remoteBuilders);
        globalCacheConfig.setAreaInCacheName(false);

        if(jetcacheProperties.getEnableLog()){
            globalCacheConfig.setStatIntervalMinutes(jetcacheProperties.getMinutes());
        }
        return globalCacheConfig;
    }

}
