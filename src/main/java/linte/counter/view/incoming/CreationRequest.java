package linte.counter.view.incoming;

public class CreationRequest {
    public String name;

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
