package linte.counter.service.Impl;

import linte.counter.model.Counter;
import linte.counter.model.CounterRepositoryImpl;
import linte.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    private CounterRepositoryImpl repository;

    @Autowired
    public CounterServiceImpl(CounterRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(String name) {
        boolean completedSuccessfully = false;
        if (!repository.exists(name)){
            repository.addCounter(new Counter(name));
            completedSuccessfully = true;
        }
        return completedSuccessfully;
    }

    @Override
    public boolean increment(String name) {
        boolean completedSuccessfully = false;
        if(repository.exists(name)){
            Counter counter = repository.getCounter(name);
            counter.increment();
            repository.updateCounter(counter);
            completedSuccessfully = true;
        }
        return completedSuccessfully;
    }

    @Override
    public String getValue(String name) {
        String counterValue = "";
        if(repository.exists(name)){
            counterValue = String.valueOf(repository.getCounter(name).getValue());
        }
        return counterValue;
    }

    @Override
    public boolean delete(String name) {
        boolean completedSuccessfully = false;
        if(repository.exists(name)){
            repository.deleteCounter(name);
            completedSuccessfully = true;
        }
        return completedSuccessfully;
    }

    @Override
    public String getTotalValue() {
        Collection<Counter> snapshot = repository.getCounters();
        Long totalCount = 0L;
        for (Counter counter : snapshot){
            totalCount += counter.getValue();
        }
        return String.valueOf(totalCount);
    }

    @Override
    public List<String> list() {
        return repository.getCounterNames();
    }
}
