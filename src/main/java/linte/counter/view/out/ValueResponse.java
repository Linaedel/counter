package linte.counter.view.out;

/**
 * Обёртка для возвращения значений счётчиков
 * (формат ответа не оговорён, исправить проще, чем писать с нуля)
 */
public class ValueResponse {
    private String value;

    public ValueResponse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
