package linte.counter.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Некий аналог DAO, обеспечивающий работу с "репозиторием", в котором хранятся значения.
 * UPD: Перераспределил функционал между мапой и сервисом для разграничения ответственности.
 */
@Component
public class CounterRepository {
    private ConcurrentHashMap<String,Counter> counterMap;

    public CounterRepository() {
        this.counterMap = new ConcurrentHashMap<>();
    }

    public boolean exists(String name){
        return this.counterMap.containsKey(name);
    }

    public void addCounter(Counter counter){
        this.counterMap.put(counter.getName(),counter);
    }

    public void updateCounter(Counter counter) {
        this.counterMap.replace(counter.getName(),counter);
    }

    public Counter getCounter(String name){
        return this.counterMap.get(name);
    }

    public void deleteCounter(String name){
        this.counterMap.remove(name);
    }

    public ConcurrentHashMap<String,Counter> getCounters(){
        return new ConcurrentHashMap<>(this.counterMap);
    }

}
