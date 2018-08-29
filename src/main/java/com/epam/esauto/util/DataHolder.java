package com.epam.esauto.util;

import com.epam.esauto.entity.Order;
import com.epam.esauto.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataHolder {

    private Map<String, Object> map = new ConcurrentHashMap<>();

    public Object getByKey(String key) {
        return map.get(key);
    }

    public void put(String key, Object object) {
        this.map.putIfAbsent(key,object);
    }
}
