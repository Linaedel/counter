package linte.counter.view.general;

public class FilledResponseView<T> extends ResponseView {
    private T data;

    public FilledResponseView(T value) {
        this.data = value;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}




