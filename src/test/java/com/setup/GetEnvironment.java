package com.setup;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ahmetbaltaci on 22.12.2017.
 */


public class GetEnvironment {

    private String env = System.getProperty("getEnvironment");

   public String getEnvironment(String param)  {
        JsonObject jsonObject = null;
        try {
            JsonParser parser = new JsonParser();
            String filePath = "src/test/resources/env.json";
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JsonObject) obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        env = env == null ?"local":env;
        assert jsonObject != null;
        return jsonObject.getAsJsonObject(env).getAsJsonPrimitive(param).getAsString();
    }
}
