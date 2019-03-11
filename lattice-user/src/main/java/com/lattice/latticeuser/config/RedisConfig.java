package com.lattice.latticeuser.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.lattice.latticeuser.utils.RedisUtil;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 20:08
 **/
@Configuration
@PropertySource("classpath:redis.properties")
@EnableCaching
public class RedisConfig {
    
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    
    @Value("${redis.hostName}")
    private String hostName;
    
    @Value("${redis.timeout}")
    private Integer timeout;
    
    @Value("${redis.port}")
    private Integer port;
    
    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    
    @Value("${redis.maxWaitMillis}")
    private Integer maxWaitMillis;
    
    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    
    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;
    
    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    
    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;
    
    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;
    
    @Value("${redis.database}")
    private Integer database;
    
    /**
     * JedisPoolConfig 连接池
     *
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }
    
    /**
     * 单机版配置
     *
     * @param @param jedisPoolConfig
     * @param @return
     * @return JedisConnectionFactory
     * @throws @Title: JedisConnectionFactory
     * @autor lpl
     * @date 2018年2月24日
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(database);
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration =
            JedisClientConfiguration.builder();
        // connection timeout
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
        JedisConnectionFactory factory =
            new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration.build());
        
        return factory;
    }
    
    /**
     * 实例化 RedisTemplate 对象
     *
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }
    
    /**
     * 设置数据存入 redis 的序列化方式,并开启事务
     *
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        // 如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }
    
    /**
     * 注入封装RedisTemplate
     *
     * @return RedisUtil
     * @throws @Title: redisUtil
     * @autor lpl
     * @date 2017年12月21日
     */
    @Bean(name = "redisUtil")
    public RedisUtil redisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }
    
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator()
        {
            // 为给定的方法及其参数生成一个键
            // 格式为：com.frog.mvcdemo.controller.FrogTestController-show-[params]
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                // 类名
                sb.append(target.getClass().getName());
                sb.append(".");
                // 方法名
                sb.append(method.getName());
                sb.append("(");
                for (Object param : params) {
                    // 参数
                    sb.append(param.toString() + ", ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
                return sb.toString();
            }
        };
    }
    
}
