class LEDScreenDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("LED Screen Display: Temperature updated to " + temperature + "°C");
    }
}
