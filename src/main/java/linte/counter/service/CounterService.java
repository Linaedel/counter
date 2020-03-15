package linte.counter.service;

import linte.counter.view.general.ResponseView;

public interface CounterService {
    ResponseView create(String name);
    ResponseView increment(String name);
    ResponseView getValue(String name);
    ResponseView delete(String name);
    ResponseView getTotalValue();
    ResponseView list();
}
