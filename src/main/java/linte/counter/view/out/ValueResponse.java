package linte.counter.view.out;

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
