public class WeatherStationSimulator {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread stationThread = new Thread(weatherStation);

        PhoneDisplay phone1 = new PhoneDisplay("Trang");
        PhoneDisplay phone2 = new PhoneDisplay("Cindy");
        LEDScreenDisplay ledDisplay = new LEDScreenDisplay();

        weatherStation.addObserver(phone1);
        weatherStation.addObserver(phone2);
        weatherStation.addObserver(ledDisplay);

        stationThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Removing Trang's phone display...");
        weatherStation.removeObserver(phone2);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        weatherStation.stop();
    }
}
