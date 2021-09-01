package com.realbizgames.demo.hazelcast.config.hc.serializer;

public enum SerializerId {
    USER_ENTITY(1),//
    DEVICE_ENTITY(2)//
    ;

    private int id;

    SerializerId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
