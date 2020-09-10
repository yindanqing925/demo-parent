package org.nh.demo.common.cache;

import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yindanqing
 * @date 2019/5/14 2:09
 * @description 缓存标准接口
 */
public interface Cache {



	/**
	 * 列出所有的key
	 * @return
	 */
	public Set<?> getKeys();

	/**
	 * 列出所有的key
	 * @param db数据库名称
	 * @return
	 */
	public Set<?> getKeys(String db);

	public Set<?> getKeys(String keyClue, String db);

	/**
	 * 检查给定key是否存在
	 *
	 * @param key
	 * @return
	 */
	public Boolean exists(String key);

	/**
	 * 检查给定key是否存在
	 *
	 * @param key
	 * @param db数据库名称
	 * @return
	 */
	public Boolean exists(String key, String db);

	/**
	 * 移除给定的一个或多个key。如果key不存在，则忽略该命令。
	 *
	 * @param key
	 */
	public Long del(String key);
	public void del(String key, String db);


	public void delByte(String key);
	public void delByte(String key, String db);

	/**
	 * 简单的字符串设置
	 *
	 * @param key
	 * @param value
	 */
	public void set(String key, String value);

	/**
	 *
	 * @param key
	 * @param value
	 * @param expiration
	 */
	public void set(String key, String value, Integer expiration);

	/**
	 * 设置字符串
	 *
	 * @param key
	 * @param value
	 * @param db
	 */
	public void set(String key, String value, String db);
	public void setByte(String key, byte[] value);
	public void setByte(String key, byte[] value, String db);

	public String lpop(String key);

	/**
	 * 返回key所关联的字符串值
	 *
	 * @param key
	 * @return
	 */
	public String get(String key);

	/**
	 *
	 * @param key
	 *            键值
	 * @param db
	 *            数据库名称
	 * @return
	 */
	public String get(String key, String db);
	public byte[] getByte(String key);
	public byte[] getByte(String key, String db);

	/**
	 * 同时设置一个或多个key-value对 ("haha", "111", "xixi", "222")
	 *
	 * @param keyvalues
	 */
	public void mset(String... keyvalues);

	/**
	 * 返回所有(一个或多个)给定key的值
	 *
	 * @param keys
	 * @return
	 */
	public List<?> mget(String... keys);

	/**
	 * key seconds 为给定key设置生存时间。当key过期时，它会被自动删除。
	 *
	 * @param key
	 * @param expire
	 */
	public void expire(String key, int expire);

	public void expire(String key, String db, int timestamp);
	
	public void expireAt(String key, long timestamp);

	// 查看一个键的所剩的有效期
	public long ttl(String key, String db);

	public void expireByte(String key, int expire);

	/**
	 * 如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
	 *
	 * @param key
	 * @param value
	 */
	public void append(String key, String value);

	/**
	 * HASH操作 将哈希表key中的域field的值设为value。
	 *
	 * @param key
	 * @param field
	 * @param value
	 */
	public void hset(String key, String field, String value);

	public void hsetObject(String key, Object field, Object value);
	/**
	 * HASH操作 返回哈希表key中给定域field的值。
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public String hget(String key, String field);

	public Object hgetObject(String key, Object field);

	/**
	 * HASH操作 value(域-值)对设置到哈希表key中。
	 *
	 * @param key
	 * @param map
	 */
	public void hmset(String key, Map<?, ?> map);

	/**
	 * HASH操作 返回哈希表key中，一个或多个给定域的值。
	 *
	 * @param key
	 * @param fields
	 * @return
	 */
	public List<?> hmget(String key, String... fields);

	/**
	 * HASH操作 返回哈希表key中，所有的域和值。
	 *
	 * @param key
	 * @return
	 */
	public Map<String, String> hgetAll(String key);

	public Map<Object, Object> hgetAllObject(String key);

	/**
	 * LIST操作 LPUSH key value [value ...]将值value插入到列表key的表头。
	 *
	 * @param key
	 * @param value
	 */
	public void lpush(String key, String value);
	public void lpush(String key, String value, String db);
	public void rpush(String key, String value, String db);
	public void lpushByte(String key, byte[][] value);
	public void lpushByte(String key, byte[] value);
	public void lpushByte(String key, byte[] value, String db);

	/**
	 * LIST操作 top返回列表key中指定区间内的元素，区间以偏移量start和stop指定。 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
	 * 你也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
	 *
	 * @param key
	 * @param start
	 * @param stop
	 * @return
	 */
	public List<?> lrange(String key, int start, int stop);
	public List<?> lrange(String key, int start, int stop, String db);
	public List<?> lrangeByte(String key, int start, int stop);
    public List<?> lrangeByte(String key, int start, int stop, String db);

	/**
	 * SET 操作 将member元素加入到集合key当中。
	 *
	 * @param key
	 * @param value
	 */
	public void sadd(String key, String value);

	/**
	 * SET 操作 SREM key member移除集合中的member元素。
	 *
	 * @param key
	 * @param value
	 */
	public void srem(String key, String value);

	/**
	 * SET 操作 SMEMBERS key返回集合key中的所有成员。
	 *
	 * @param key
	 * @return
	 */
	public Set<?> smembers(String key);

	/**
	 * 检查给定key是否存在
	 *
	 * @param key
	 * @param db数据库名称
	 * @return
	 */
	public void hmset(String key, Map<?, ?> map, String db);

	public List<String> brpop(int timeout, String db, String... keys);
	public List<byte[]> brpop(int timeout, byte[]... keys);

	/**
	 * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
	 *
	 * @param key
	 * @param cnt
	 *            > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。 < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。 = 0 : 移除表中所有与 value 相等的值。
	 * @param value
	 */
	public Long lrem(String key, long cnt, String value, String dbs);

	/**
	 * 获取旧值返回新值，不存在返回nil
	 *
	 * @param key
	 * @param newValue
	 * @param db
	 * @return 旧值
	 */
	public String getset(String key, String newValue, String db);

	/**
	 * 分布锁
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public Long setnx(String key, String value, String db);

	/**
	 * 计数器
	 */
	public Long hincrBy(String key, String field, Integer value, String db);

	/**
	 * 计数器
	 */
	public Long incrBy(String key, Integer value, String db);

	/**
	 * 判断key是否存在
	 *
	 * @param key
	 * @param field
	 * @param db
	 * @return
	 */
	public Boolean hexists(String key, String field, String db);

	public void hset(String key, String field, String value, String db);

	/**
	 * 删除key field
	 *
	 * @param key
	 * @param fields
	 * @param db
	 */
	public void hdel(String key, String fields, String db);

	public void hdelObject(String key, Object fields);


	/**
	 * 添加或设置zset中的member
	 *
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	public Long zadd(String key, double score, String member);

	/**
	 * 删除zset中的member
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public Long zrem(String key, String... member);

	/**
	 * 获取zset中某member的分数
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public Double zscore(String key, String member);

	/**
	 * 获取zset中某member的排名(按 score 从大到小排序)
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public Long zrank(String key, String member);


	/**
	 * 获取zset中某member的排名(按 score 从大到小排序)
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public Long zrevrank(String key, String member);

	/**
	 * 返回名称为 key 的 zset（按 score 从大到小排序）中的 index 从 start 到 end 的所有元素
	 *
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public Set<Tuple> zrevrangeWithScores(String key, Long start, Long end);

	public Object eval(String script, List<String> keys, List<String> params);

	public Long incrBy4Expire(String key, Integer value, int second, int db);

	/**
	 * @Description HASH操作 将哈希表key中的域field的值设为value,并设置过期时间
	 */
	public void hsetEx(String key, String field, String value, int seconds);

	/**
	 * hash hincrBy
	 */
	Long hincrBy(String key, String field, Integer value, int db, int expireTime);

	/**
	 * 增加或设置zset中的member的值
	 *
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	Double zincrby(String key, double score, String member);
}
