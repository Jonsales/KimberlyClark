package br.com.john.kimberlyclark.ConnectionAPI.Deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Jonathan on 01/06/16.
 */
public class ProcessDeserializer implements JsonDeserializer<Object> {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement car = json.getAsJsonObject();

        if( json.getAsJsonObject().get("process") != null ){
            car = json.getAsJsonObject().get("process");
        }

        return ( new Gson().fromJson( car, Process.class ));
    }
}
