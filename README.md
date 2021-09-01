# springboot-hazelcast-demo

## MapStore
### Write behind the Cache
```
EvictionConfig evictionConfig = new EvictionConfig();
evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
evictionConfig.setMaxSizePolicy(MaxSizePolicy.PER_NODE);
evictionConfig.setSize(10000);

MapStoreConfig mapStoreConfig = new MapStoreConfig();
mapStoreConfig.setEnabled(true);
mapStoreConfig.setImplementation(mapStoreImpl);
mapStoreConfig.setInitialLoadMode(InitialLoadMode.LAZY);

mapStoreConfig.setWriteBatchSize(batchSize);
mapStoreConfig.setWriteDelaySeconds(writeDelaySeconds);
mapStoreConfig.setWriteCoalescing(true);

MapConfig customerMapConfig = new MapConfig(mapName);
customerMapConfig.setTimeToLiveSeconds(3600);
customerMapConfig.setMaxIdleSeconds(600);
customerMapConfig.setEvictionConfig(evictionConfig);
customerMapConfig.setMapStoreConfig(mapStoreConfig);
```

### Write through Cache
```
EvictionConfig evictionConfig = new EvictionConfig();
evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
evictionConfig.setMaxSizePolicy(MaxSizePolicy.PER_NODE);
evictionConfig.setSize(10000);

MapStoreConfig mapStoreConfig = new MapStoreConfig();
mapStoreConfig.setEnabled(true);
mapStoreConfig.setImplementation(mapStoreImpl);
mapStoreConfig.setInitialLoadMode(InitialLoadMode.LAZY);

MapConfig customerMapConfig = new MapConfig(mapName);
customerMapConfig.setTimeToLiveSeconds(3600);
customerMapConfig.setMaxIdleSeconds(600);
customerMapConfig.setEvictionConfig(evictionConfig);
customerMapConfig.setMapStoreConfig(mapStoreConfig);
```

### Normal cache
```
EvictionConfig evictionConfig = new EvictionConfig();
evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
evictionConfig.setMaxSizePolicy(MaxSizePolicy.PER_NODE);
evictionConfig.setSize(noItem);

MapConfig customerMapConfig = new MapConfig(mapName);
customerMapConfig.setTimeToLiveSeconds(3600);
customerMapConfig.setMaxIdleSeconds(600);
customerMapConfig.setEvictionConfig(evictionConfig);
```
