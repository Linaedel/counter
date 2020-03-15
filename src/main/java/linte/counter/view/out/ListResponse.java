package linte.counter.view.out;

import java.util.List;

/**
 * Обёртка для возвращения списка счётчиков
 * (формат ответа не оговорён, исправить проще, чем писать с нуля)
 */
public class ListResponse {
    private List<String> counters;

    public List<String> getCounters() {
        return counters;
    }

    public void setCounters(List<String> counters) {
        this.counters = counters;
    }

    public ListResponse(List<String> counters) {
        this.counters = counters;
    }
}
