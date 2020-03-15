package linte.counter.model;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CounterRepository {
    private ConcurrentHashMap<String,Counter> counterMap;

    public CounterRepository() {
        this.counterMap = new ConcurrentHashMap<>();
    }

    public boolean createCounter(String name) {
        boolean completedSuccessfully = false;
        if (!counterMap.containsKey(name)){
            this.counterMap.put(name, new Counter(name));
            completedSuccessfully = true;
        }
        return completedSuccessfully;
    }

    public boolean incrementCounter(String name) {
        boolean completedSuccessfully = false;
        if (counterMap.containsKey(name)) {
            this.counterMap.get(name).increment();
            completedSuccessfully = true;
        }
        return completedSuccessfully;
    }

    public String getCounterValue(String name) {
        String counterValue = "";
        if (counterMap.containsKey(name)) {
            counterValue = String.valueOf(this.counterMap.get(name).getValue());
        }
        return counterValue;
    }

    public boolean deleteCounter(String name) {
        boolean completedSuccessfully = false;
        if (counterMap.containsKey(name)) {
            this.counterMap.remove(name);
            completedSuccessfully = true;
        }
        return completedSuccessfully;
    }

    public String getTotalValue() {
        ConcurrentHashMap<String, Counter> snapshot = new ConcurrentHashMap<>(counterMap);
        Long totalCount = 0L;
        for (String name : snapshot.keySet()){
            totalCount += snapshot.get(name).getValue();
        }
        return String.valueOf(totalCount);
    }

    public List<String> getCountersList() {
        return Collections.list(this.counterMap.keys());
    }
}
