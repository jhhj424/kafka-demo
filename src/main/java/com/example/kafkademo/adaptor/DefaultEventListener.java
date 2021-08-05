package com.example.kafkademo.adaptor;

import java.util.Objects;

abstract class DefaultEventListener<K, V> implements EventListener<K, V>{

    @Override
    public void consume(K k, V v) {
        if (Objects.nonNull(v)) {
            consumeEvent(k, v);
            return;
        }
        consumeTombstoneEvent(k);
    }
}
