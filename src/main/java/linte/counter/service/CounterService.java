package linte.counter.service;

import java.util.List;

public interface CounterService {
    boolean create(String name);
    boolean increment(String name);
    String getValue(String name);
    boolean delete(String name);
    String getTotalValue();
    List<String> list();
}
