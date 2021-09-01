package com.realbizgames.demo.hazelcast.convertor;

import java.util.List;

public interface IConvertor<T, F> {
    T convert(F f);

    List<T> convert(Iterable<F> f);
}
