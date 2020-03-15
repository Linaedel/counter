package linte.counter.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Некий аналог Entity, структурный элемент модели приложения.
 * С практической точки зрения не настолько необходим в данном приложении,
 * но как только появится необходимость, например, ввести для него какой-либо идентификатор
 * или сопутствующую информацию, - проще будет редактировать готовый класс, чем искать в недрах сервиса.
 */
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
