package org.aisbreaker.api.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonConverter {
    protected static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        //objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        // deprecated: objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        // better alternative:
        objectMapper.setSerializationInclusion(Include.NON_NULL);
    }

    /** Generate JSON */
    public static String obj2Json(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }
    public static byte[] obj2JsonBytes(Object obj) throws IOException {
        return objectMapper.writeValueAsBytes(obj);
    }

    /** Parse JSON */
    public static <T> T json2Obj(String json, Class<T> valueType) throws IOException {
        return objectMapper.readValue(json, valueType);
    }
}
