package linte.counter.model;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private String name;
    private AtomicLong value;

    public Counter(String name) {
        this.name = name;
        this.value = new AtomicLong();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value.get();
    }

    public void increment() {
        this.value.incrementAndGet();
    }
}
