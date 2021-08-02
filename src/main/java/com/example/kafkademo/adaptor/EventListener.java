package com.example.kafkademo.adaptor;

public interface EventListener<K, V> {

    void listen(K k, V v);

    void consume(K k, V v);

    default void consumeEvent(K k, V v) {
        throw new ConsumeEventException();
    }

    default void consumeTombstoneEvent(K k) {
        throw new ConsumeEventException();
    }
}
