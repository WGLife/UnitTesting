package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private static final GsonBuilder gsonBuilder = new GsonBuilder();

    public static void registerType(
            RuntimeTypeAdapterFactory<?> adapter) {
        gsonBuilder.registerTypeAdapterFactory(adapter);
    }

    public static Gson getGson() {
        return gsonBuilder.create();
    }
}