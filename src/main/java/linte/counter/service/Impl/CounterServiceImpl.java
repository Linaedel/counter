package linte.counter.service.Impl;

import linte.counter.model.CounterRepository;
import linte.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    private CounterRepository repository;

    @Autowired
    public CounterServiceImpl(CounterRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(String name) {
        return repository.createCounter(name);
    }

    @Override
    public boolean increment(String name) {
        return repository.incrementCounter(name);
    }

    @Override
    public String getValue(String name) {
        return repository.getCounterValue(name);
    }

    @Override
    public boolean delete(String name) {
        return repository.deleteCounter(name);
    }

    @Override
    public String getTotalValue() {
        return repository.getTotalValue();
    }

    @Override
    public List<String> list() {
        return repository.getCountersList();
    }

}
