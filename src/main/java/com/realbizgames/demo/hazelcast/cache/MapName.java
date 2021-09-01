package com.realbizgames.demo.hazelcast.cache;

public enum MapName {
    USER_ENTITY("user-entity"),//
    DEVICE_ENTITY("device-entity"),
    ;

    MapName(String mapName) {
        this.mapName = mapName;
    }

    private String mapName;

    public String getMapName() {
        return mapName;
    }
}
