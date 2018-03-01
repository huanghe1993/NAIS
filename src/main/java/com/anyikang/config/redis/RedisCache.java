package com.anyikang.config.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;

import com.anyikang.utils.RedisUtils;
import com.anyikang.utils.SerializeUtils;

/**
 * @author wangwei
 * @date 2017年7月5日
 * @param <K>
 * @param <V>
 */
public class RedisCache<K, V> implements Cache<K, V> {

	private RedisUtils redisUtil;
	private String keyPrefix = "shiro_redis_cache:";

	

	public RedisCache(String prefix) {
		this.redisUtil = new RedisUtils();
		this.keyPrefix = prefix;
	}

	private byte[] getByteKey(K key) {
		if (key instanceof String) {
			String preKey = this.keyPrefix + key;
			return preKey.getBytes();
		} else if (key instanceof PrincipalCollection) {
			String sessionId = (String) SecurityUtils.getSubject().getSession()
					.getId();
			String preKey = this.keyPrefix + sessionId.toString();
			return preKey.getBytes();
		} else {
			return SerializeUtils.serialize(key);
		}
	}

	@Override
	public V get(K key) throws CacheException {
		try {
			if (key == null) {
				return null;
			} else {
				byte[] rawValue = redisUtil.get(this.getByteKey(key));
				@SuppressWarnings("unchecked")
				V value = (V) SerializeUtils.deserialize(rawValue);
				return value;
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@Override
	public V put(K key, V value) throws CacheException {
		try {
			redisUtil.set(getByteKey(key), SerializeUtils.serialize(value), 0);
			return value;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@Override
	public V remove(K key) throws CacheException {
		System.out.println("从redis中删除 key [" + key + "]");
		try {
			V previous = get(key);
			redisUtil.remove(getByteKey(key));
			return previous;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@Override
	public void clear() throws CacheException {
		redisUtil.flushDB();
	}

	@Override
	public int size() {
		Long dbsize = redisUtil.dbSize();
		return dbsize.intValue();
	}

	@Override
	public Set<K> keys() {
		try {
			Set<byte[]> keys = redisUtil.keys(this.keyPrefix + "*");
			if (CollectionUtils.isEmpty(keys)) {
				return Collections.emptySet();
			} else {
				Set<K> newKeys = new HashSet<K>();
				for (byte[] key : keys) {
					newKeys.add((K) key);
				}
				return newKeys;
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@Override
	public Collection<V> values() {
		Set<byte[]> keys = redisUtil.keys(this.keyPrefix + "*");
		List<V> list = new ArrayList<V>();
		if (CollectionUtils.isNotEmpty(keys)) {
			for (byte[] key : keys) {
				byte[] rawValue = redisUtil.get(key);
				@SuppressWarnings("unchecked")
				V value = (V) SerializeUtils.deserialize(rawValue);
				list.add(value);
			}
		}
		return list;
	}
}
