package lrucache;

import java.util.LinkedHashMap;


public class LRUCacheV2<K, V> extends LinkedHashMap<K, V>{
	
	private static final int MAX_ENTRIES = 3;
	
	/**
	 * super class constructor arguments are
	 * cache size = MAX_ENTRIES
	 * load factor = 0.75F
	 * access order = true
	 */
	public LRUCacheV2(){
		super(MAX_ENTRIES,0.075F,true);
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> entry) {
		return size() > MAX_ENTRIES;
	}
	
	public static void main(String[] args) {
		LRUCacheV2<String, Integer> cache = new LRUCacheV2<String, Integer>();
		cache.put("abc", 1);
		cache.put("def", 2);
		cache.put("ghi", 3);
		cache.put("jkl", 4);
		cache.put("mno", 5);
		cache.put("abc", 1);
		System.out.println(cache);
	}
}
