package linte.counter.view.inc;

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
