package linte.counter.model;

import java.util.Collection;
import java.util.List;

public interface CounterRepository {

    /**
     * Проверить наличие счётчика по имени.
     *
     * @param name - имя счётчика
     * @return Возвращает true при наличии счётчика с переданным именем.
     */
     boolean exists(String name);

    /**
     * Добавить счётчик в репозиторий.
     *
     * @param counter - добавляемый счётчик
     */
     void addCounter(Counter counter);

    /**
     * Обновить состояние счётчика в репозитории.
     *
     * @param counter - обновляемый счётчик
     */
     void updateCounter(Counter counter);

    /**
     * Получить счётчик из репозитория.
     *
     * @param name - имя запрашиваемого счётчика
     * @return Возвращает запрашиваемый счётчик.
     */
     Counter getCounter(String name);

    /**
     * Удалить счётчик из репозитория.
     *
     * @param name - имя удаляемого счётчика
     */
     void deleteCounter(String name);

    /**
     * Получить коллекцию всех счётчиков.
     *
     * @return Возвращает снэпшот-коллекцию всех счётчиков, существующих в данный момент на сервисе
     */
     Collection<Counter> getCounters();

    /**
     * Получить список названий всех счётчиков.
     *
     * @return Возвращает список названий всех счётчиков, существующих в данный момент на сервисе
     */
     List<String> getCounterNames();
}
