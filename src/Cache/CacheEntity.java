package Cache;

/**
 * 缓存实体类
 * @author node1
 *
 */
public class CacheEntity {
	private long timestamp;
    private int period = -1;
    private Object data;

    /**
     * @param data
     * @param period -1 表示永不过期，大于0表示过期的时间，单位分钟
     */
    public CacheEntity(Object data, int period) {
        timestamp = System.currentTimeMillis();
        this.data = data;
        this.period = period;
    }

    public Object getObject() {
        return data;
    }
    /**
     * 检查是否超时
     * @return true 没有超时  false 超时
     */
    public boolean isValid() {
        if (period == -1 || System.currentTimeMillis() < (timestamp + period * 60000)) {
            return true;
        }
        return false;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }
}
