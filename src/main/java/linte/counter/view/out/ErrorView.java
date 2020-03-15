package linte.counter.view.out;

import java.io.Serializable;

/**
 * Обёртка для возвращения сообщений об ошибках в произвольном формате
 */
public class ErrorView implements Serializable {
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
