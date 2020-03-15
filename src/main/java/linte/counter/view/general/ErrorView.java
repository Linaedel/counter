package linte.counter.view.general;

public class ErrorView extends ResponseView {
    private String error;

    public ErrorView(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
