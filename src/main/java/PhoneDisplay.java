// Concrete Observer Classes
class PhoneDisplay implements Observer {
    private final String name;

    public PhoneDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " Phone Display: Current temperature is " + temperature + "°C");
    }
}