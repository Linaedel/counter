package linte.counter.model;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Некий аналог DAO, обеспечивающий работу с "репозиторием", в котором хранятся значения.
 * UPD: Перераспределил функционал между мапой и сервисом для разграничения ответственности.
 */
@Component
public class CounterRepositoryImpl implements CounterRepository {
    private ConcurrentHashMap<String,Counter> counterMap;

    public CounterRepositoryImpl() {
        this.counterMap = new ConcurrentHashMap<>();
    }

    public boolean exists(String name){
        return this.counterMap.containsKey(name);
    }

    public void addCounter(Counter counter){
        this.counterMap.put(counter.getName(),counter);
    }

    //Не уверен, что replace в данной ситуации будет работать корректно на больших нагрузках.
    public void updateCounter(Counter counter) {
        this.counterMap.replace(counter.getName(),counter);
    }

    public Counter getCounter(String name){
        return this.counterMap.get(name);
    }

    public void deleteCounter(String name){
        this.counterMap.remove(name);
    }

    public Collection<Counter> getCounters(){
        return this.counterMap.values();
    }

    public List<String> getCounterNames(){
        return Collections.list(this.counterMap.keys());
    }
}
