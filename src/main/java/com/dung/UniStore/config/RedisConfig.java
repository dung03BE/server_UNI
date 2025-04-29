    package com.dung.UniStore.config;


    import org.springframework.cache.CacheManager;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.data.redis.cache.RedisCacheConfiguration;
    import org.springframework.data.redis.cache.RedisCacheManager;
    import org.springframework.data.redis.connection.RedisConnectionFactory;
    import org.springframework.data.redis.connection.RedisPassword;
    import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
    import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
    import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
    import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
    import org.springframework.data.redis.core.RedisTemplate;
    import org.springframework.data.redis.serializer.*;

    import java.time.Duration;
    import java.util.HashMap;
    import java.util.Map;
//
//    @Configuration
//    public class RedisConfig {
//        @Bean
//        public JedisConnectionFactory redisConnectionFactory() {
//            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("modern-flounder-30255.upstash.io", 6379);
//            config.setPassword("AXYvAAIjcDE0MGQ5ZjUxZGI4ODQ0MTRjODE5MTQ4Yjg4NjY0NjIzNHAxMA");
//            JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder().build();
//            return new JedisConnectionFactory(config, clientConfiguration);
//        }
//
//        @Bean
//        public RedisTemplate<String, Object> redisTemplate() {
//            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(redisConnectionFactory());
//            redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//            return redisTemplate;
//        }
//        @Bean
//        public CacheManager cacheManager(JedisConnectionFactory redisConnectionFactory) {
//            RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
//                    .entryTtl(Duration.ofMinutes(10))
//                    .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//            Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
//            cacheConfigurations.put("products", defaultConfig.entryTtl(Duration.ofMinutes(5)));
//            cacheConfigurations.put("users", defaultConfig.entryTtl(Duration.ofHours(1)));
//
//            // Thêm các cấu hình cache khác tại đây nếu cần
//
//            return RedisCacheManager.builder(redisConnectionFactory)
//                    .cacheDefaults(defaultConfig)
//                    .withInitialCacheConfigurations(cacheConfigurations)
//                    .build();
//        }
//    }
@Configuration
public class RedisConfig {
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("modern-flounder-30255.upstash.io", 6379); // Dùng đúng port
//        config.setPassword(RedisPassword.of("AXYvAAIjcDE0MGQ5ZjUxZGI4ODQ0MTRjODE5MTQ4Yjg4NjY0NjIzNHAxMA"));
//        LettuceConnectionFactory factory = new LettuceConnectionFactory(config);
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//        return redisTemplate;
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(10))
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
//        cacheConfigurations.put("products", defaultConfig.entryTtl(Duration.ofMinutes(5)));
//        cacheConfigurations.put("users", defaultConfig.entryTtl(Duration.ofHours(1)));
//
//        return RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(defaultConfig)
//                .withInitialCacheConfigurations(cacheConfigurations)
//                .build();
//    }


    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues()
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(
                                new Jackson2JsonRedisSerializer<>(Object.class)
                        )
                );
    }

}
