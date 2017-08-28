package Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据请求中对cache进行管理
 * 2017-7-20 15:16:36
 */

public class CacheManager {
	private static Map<String, CacheEntity> cacheMap = new HashMap<>();

    /**
     * 添加到cache
     *
     * @param key
     * @param data
     * @param period
     */
    public static void addData(String key, Object data, int period) {
    	CacheEntity cacheEntity = getData(key);
        if (cacheEntity != null) {
            /**
             * 如果类型不同，便重新加入到缓存中
             */
            if (period != cacheEntity.getPeriod()) {
            	cacheEntity.setPeriod(period);
                /**
                 * 移除老的value
                 */
                removeInvalidData(key);
                /**
                 * 重新putvalue
                 */
                cacheMap.put(key, cacheEntity);
            }
        } else {
            cacheEntity = new CacheEntity(data, period);
            cacheMap.put(key, cacheEntity);
        }
    }

    /**
     * 获取cache
     *
     * @param key
     * @return
     */
    public static CacheEntity getData(String key) {
    	CacheEntity cacheEntity = cacheMap.get(key);
        if (cacheEntity != null) {
            /**
             * 判断缓存是否过期
             */
            if (cacheEntity.isValid()) {
                return cacheEntity;
            } else {
                removeInvalidData(key);
            }
        }
        return null;
    }

    /**
     * 移除过期的key
     *
     * @param key
     */
    public static void removeInvalidData(String key) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        }
    }
}
