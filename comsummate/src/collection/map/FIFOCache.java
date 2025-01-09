package collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/** 一个固定大小的FIFO替换策略的缓存 */
class FIFOCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;
    public FIFOCache(int cacheSize){
        this.cacheSize = cacheSize;
    }

    // 当Entry个数超过cacheSize时，删除最老的Entry
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
       return size() > cacheSize;
    }

    public static void main(String[] args) {
        Map<String, String> map = new FIFOCache<>(1);
        map.put("aa", "aa");
        map.put("aa", "aa");
    }
}
