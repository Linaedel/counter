package linte.counter.service.Impl;

import linte.counter.model.CounterRepository;
import linte.counter.service.CounterService;
import linte.counter.view.general.ErrorView;
import linte.counter.view.general.FilledResponseView;
import linte.counter.view.general.ResponseView;
import linte.counter.view.general.SuccessfulResult;
import linte.counter.view.particular.ValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {
    private CounterRepository repository;

    @Autowired
    public CounterServiceImpl(CounterRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseView create(String name) {
        return repository.createCounter(name)?
                new SuccessfulResult() :
                new ErrorView("Counter with [" + name + "] name is already exists.");
    }

    @Override
    public ResponseView increment(String name) {
        return repository.incrementCounter(name)?
                new SuccessfulResult() :
                new ErrorView("Counter with [" + name + "] name does not exist.");
    }

    @Override
    public ResponseView getValue(String name) {
        String counterValue = repository.getCounterValue(name);
        return counterValue.equals("COUNTER_NOT_EXIST")?
                new ErrorView("Counter with [" + name + "] name does not exist.") :
                new FilledResponseView<>(new ValueResponse(counterValue));
    }

    @Override
    public ResponseView delete(String name) {
        return repository.deleteCounter(name)?
                new SuccessfulResult() :
                new ErrorView("Counter with [" + name + "] name does not exist.");
    }

    @Override
    public ResponseView getTotalValue() {
        return new FilledResponseView<>(new ValueResponse(repository.getTotalValue()));
    }

    @Override
    public ResponseView list() {
        return new FilledResponseView<>(repository.getCountersList());
    }

}
