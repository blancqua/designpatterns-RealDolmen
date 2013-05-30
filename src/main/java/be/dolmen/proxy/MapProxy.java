package be.dolmen.proxy;

import java.util.WeakHashMap;

public class MapProxy implements AbstractMap {

    private String fileName;
    private WeakHashMap<String, String> hashtable = new WeakHashMap<String, String> ();

    private Map map;

    public MapProxy(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public String find(String key) throws Exception
    {
        String value = get(key);
        if (value == null) {
            value = map().find(key);
            put(key, value);
        }

    	return value;
    }

    @Override
    public void add(String key, String value) throws Exception
    {
        map().add(key, value);
        put(key, value);
    }

    private synchronized String get(String key)
    {
    	return hashtable.get(key);
    }

    private synchronized void put(String key, String value)
    {
    	hashtable.put(key, value);
    }

    private synchronized Map map() {
        if (map == null) {
            map = new Map(fileName);
        }
        return map;
    }
}
