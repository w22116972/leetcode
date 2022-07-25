package example;

public class OtherService {

    private final ServiceInterface service;

    public OtherService(ServiceInterface service) {
        this.service = service;
    }


    public void doSomething() {
        new OtherService(new ServiceImpl1());
    }
}
