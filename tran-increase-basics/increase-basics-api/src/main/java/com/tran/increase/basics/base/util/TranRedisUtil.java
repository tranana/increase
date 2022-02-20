package com.tran.increase.basics.base.util;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.tran.increase.basics.base.configbean.TranRedisPrefix;
import com.tran.increase.config.redis.RedisPoolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author luxiangqian
 * 2022/2/19
 */
@Component
public class TranRedisUtil {

    @Autowired
    private RedisPoolFactory redisPoolFactory;

    /**
     * 获取值
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(TranRedisPrefix tranRedisPrefix, String key, Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String value = jedis.get(tranRedisPrefix.expirationTime()+key);
            return stringToBean(value,clazz);
        }finally {
            resultsJedisPool(jedis);
        }
    }



    /**
     * 存入值
     * @param key
     * @param value
     * @return
     */
    public <T> String set(TranRedisPrefix tranRedisPrefix,String key,T value){
        Jedis jedis = null;
        String strValue = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            strValue = beanToValue(value);
            if (StrUtil.isNotBlank(strValue)){
                if (tranRedisPrefix.expirationTime() <= 0){
                    jedis.set(tranRedisPrefix.prefix()+key,strValue);
                }else {
                    jedis.setex(tranRedisPrefix.prefix()+key,tranRedisPrefix.expirationTime(),strValue);
                }
            }
        }finally {
            resultsJedisPool(jedis);
        }
        return strValue;
    }

    /**
     * key 是否存在
     * @param tranRedisPrefix
     * @param key
     * @return
     */
    public boolean exists(TranRedisPrefix tranRedisPrefix,String key){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            return jedis.exists(tranRedisPrefix.prefix()+key);
        }finally {
            resultsJedisPool(jedis);
        }
    }

    /**
     * 增加 原子操作
     * @param tranRedisPrefix
     * @param key
     * @return
     */
    public Long incr(TranRedisPrefix tranRedisPrefix,String key){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            return jedis.incr(tranRedisPrefix.prefix()+key);
        }finally {
            resultsJedisPool(jedis);
        }
    }

    /**
     * 减少 原子操作
     * @param tranRedisPrefix
     * @param key
     * @return
     */
    public Long decr(TranRedisPrefix tranRedisPrefix,String key){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            return jedis.decr(tranRedisPrefix.prefix()+key);
        }finally {
            resultsJedisPool(jedis);
        }
    }

    /**
     * 将对象转为 json
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToValue(T value) {
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class || clazz == long.class || clazz == Long.class){
            return "" + value;
        }else if (clazz == String.class){
            return (String) value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String value,Class<T> clazz) {
        if (value == null){
            return null;
        }
        if (clazz == int.class || clazz == Integer.class ){
            return (T)Integer.valueOf(value);
        }else if (clazz == String.class){
            return (T) value;
        }else if ( clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(value);
        } else {
            return JSON.toJavaObject(JSON.parseObject(value),clazz);
        }
    }



    /**
     * 放入连接池中
     *
     * @param jedis
     */
    private void resultsJedisPool(Jedis jedis) {
        if (null != jedis){
            jedis.close();
        }
    }


}
