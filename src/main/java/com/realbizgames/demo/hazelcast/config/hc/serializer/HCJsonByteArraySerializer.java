package com.realbizgames.demo.hazelcast.config.hc.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.nio.serialization.ByteArraySerializer;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HCJsonByteArraySerializer<T> implements ByteArraySerializer<T> {
    private ObjectMapper objectMapper;
    private Class<T> genericType;
    private int typeId;

    public HCJsonByteArraySerializer(int typeId, Class<T> genericType, ObjectMapper objectMapper) {
        this.typeId = typeId;
        this.genericType = genericType;
        this.objectMapper = objectMapper;
    }

    public byte[] write(T topic) throws IOException {
        String jsonString = this.objectMapper.writeValueAsString(topic);
        return jsonString.getBytes(StandardCharsets.UTF_8);
    }

    public T read(byte[] bytes) throws IOException {
        return this.objectMapper.readValue(bytes, this.genericType);
    }

    public int getTypeId() {
        return this.typeId;
    }
}
