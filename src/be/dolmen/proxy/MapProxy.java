package be.dolmen.proxy;

import java.util.HashMap;

public class MapProxy implements AbstractMap {

    public MapProxy(String fileName)
    {


    }

    public String find(String key) throws Exception
    {
    	// TODO implement method
    	return null;
    }

    public void add(String key, String value) throws Exception
    {


    }

    private String get(String key)
    {
    	return (String) hashtable.get(key);
    }

    private void put(String key, String value)
    {
    	hashtable.put(key, value);
    }

    private String fileName;
    private HashMap hashtable = new HashMap();
}
