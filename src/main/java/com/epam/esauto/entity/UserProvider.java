package com.epam.esauto.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

@Component
public class UserProvider {

    private static Map<String, User> usersMap;

    private void setUsersMap(Map<String, User> usersMap) {
        UserProvider.usersMap = usersMap;
    }

    public static User getUser(String username) {
        return usersMap.get(username);
    }

    @PostConstruct
    public void initUsers() throws FileNotFoundException {
        Type usersMap = new TypeToken<Map<String, User>>() {}.getType();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/users.json"));
        setUsersMap(new Gson().fromJson(reader, usersMap));
    }
}
