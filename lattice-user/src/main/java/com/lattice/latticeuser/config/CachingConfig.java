package com.lattice.latticeuser.config;

import java.time.Duration;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 21:17
 **/
@Configuration
@EnableCaching
public class CachingConfig {
    
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 设置缓存有效期一小时
        RedisCacheConfiguration redisCacheConfiguration =
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1));
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
            .cacheDefaults(redisCacheConfiguration)
            .build();
        
    }
    
    @Bean
    public CacheErrorHandler errorHandler() {
        return new RedisCacheErrorHandler();
    }
    
    @Slf4j
    private static class RedisCacheErrorHandler extends SimpleCacheErrorHandler {
        
        @Override
        public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
            log.error("handleCacheGetError key = {}, value = {}", key, cache);
            log.error("cache get error", exception);
        }
        
        @Override
        public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
            log.error("handleCachePutError key = {}, value = {}", key, cache);
            log.error("cache put error", exception);
        }
        
        @Override
        public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
            log.error("handleCacheEvictError key = {}, value = {}", key, cache);
            log.error("cache evict error", exception);
        }
        
        @Override
        public void handleCacheClearError(RuntimeException exception, Cache cache) {
            log.error("handleCacheClearError value = {}", cache);
            log.error("cache clear error", exception);
        }
    }
}
