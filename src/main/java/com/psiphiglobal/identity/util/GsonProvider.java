package com.psiphiglobal.identity.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;

public class GsonProvider
{
    private static GsonBuilder gsonBuilder;
    private static Gson gson;

    static
    {
        gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeParser.Serializer())
                .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeParser.Deserializer())
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        gson = gsonBuilder.create();
    }

    public static Gson get()
    {
        return gson;
    }

    public static GsonBuilder getGsonBuilder()
    {
        return gsonBuilder;
    }

    public static class OffsetDateTimeParser
    {
        public static class Serializer implements JsonSerializer<OffsetDateTime>
        {
            @Override
            public JsonElement serialize(OffsetDateTime offsetDateTime, Type type, JsonSerializationContext jsonSerializationContext)
            {
                return new JsonPrimitive(offsetDateTime.toString());
            }
        }

        public static class Deserializer implements JsonDeserializer<OffsetDateTime>
        {
            @Override
            public OffsetDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
            {
                return OffsetDateTime.parse(jsonElement.getAsString());
            }
        }
    }
}
