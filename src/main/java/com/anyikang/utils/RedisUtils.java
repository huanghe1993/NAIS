/**
 * 
 */
package com.anyikang.utils;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
  
/**
 * 
 * @author wangwei
 * @date 2017年2月17日
 */
@Component  
public class RedisUtils {  
  
    @SuppressWarnings("rawtypes")  
    @Autowired  
    private RedisTemplate redisTemplate;  
  
    /** 
     * 批量删除对应的value 
     *  
     * @param keys 
     */  
    public void remove(final String... keys) {  
        for (String key : keys) {  
            remove(key);  
        }  
    }  
    
    
  
    /** 
     * 批量删除key 
     *  
     * @param pattern 
     */  
    @SuppressWarnings("unchecked")  
    public void removePattern(final String pattern) {  
        Set<Serializable> keys = redisTemplate.keys(pattern);  
        if (keys.size() > 0)  
            redisTemplate.delete(keys);  
    }  
    
    /** 
     * 删除对应的value 
     *  
     * @param key 
     */  
    @SuppressWarnings("unchecked")  
    public void remove(final String key) {  
        if (exists(key)) {  
            redisTemplate.delete(key);  
        }  
    }  
    
	/**
	 * 删除对应的value
	 * @param byteKey
	 */
	@SuppressWarnings("unchecked")
	public void remove(final byte[] byteKey) {
		  redisTemplate.execute(new RedisCallback() {
	            @Override
				public Long doInRedis(RedisConnection connection) throws DataAccessException {
	                 return connection.del(byteKey);
	            }
	        });
	}

  
    /** 
     * 判断缓存中是否有对应的value 
     *  
     * @param key 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public boolean exists(final String key) {  
        return redisTemplate.hasKey(key);  
    }  
  
    /** 
     * 读取缓存 
     *  
     * @param key 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public Object get(final String key) {  
        Object result = null;  
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
        result = operations.get(key);  
        return result;  
    }  
    
    public Set<String> getKeys(final String pattern){
		Set<String> keys = redisTemplate.keys(pattern);
		return keys;
	}
	
	
	public byte[] getValue(final String key) {
		byte[] result = (byte[]) redisTemplate.opsForValue().get(key);
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public byte[] get(final byte[] key) {
        return (byte[]) redisTemplate.execute(new RedisCallback() {
            @Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                 return connection.get(key);
            }
        });
    }
  
    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public boolean set(final String key, Object value) {  
        boolean result = false;  
        try {  
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
            operations.set(key, value);  
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public boolean set(final String key, Object value, Long expireTime) {  
        boolean result = false;  
        try {  
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
            operations.set(key, value);  
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);  
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
    
    
    
    //================
    
    /**
	 * 获取库的大小
	 * @return
	 */
	public long dbSize() {
	        return (Long) redisTemplate.execute(new RedisCallback() {
	            @Override
				public Long doInRedis(RedisConnection connection) throws DataAccessException {
	                return connection.dbSize();
	            }
	        });
	}
	
	/**
	 * 清空所有的redis的数据
	 * @return
	 */
	public String flushDB() {
        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }
	
	/**
	 * 批量获取keys
	 * @param string
	 * @return
	 */
	public Set keys(String string) {
		Set keys = redisTemplate.keys(string);
		return keys;
	}
	
  
	
	
	
	
	@SuppressWarnings("unchecked")
	public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            @Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }
	
	
	
	
	
	
	
	
	
	
	
	
}  
