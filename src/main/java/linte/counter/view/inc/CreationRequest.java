package linte.counter.view.inc;


/**
 * Шаблон для входящего запроса на создание счётчика
 * (формат запроса не оговорён, исправить проще, чем писать с нуля)
 */
public class CreationRequest {
    private String name;

    public CreationRequest() {
    }

    public CreationRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
