import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Observer {
    void update(int temperature);
}

// Subject (Observable) Class
class WeatherStation implements Runnable {
    private final List<Observer> observers = new ArrayList<>();
    private int temperature;
    private final Random random = new Random();
    private boolean running = true;

    public WeatherStation() {
        this.temperature = random.nextInt(30) + 1;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            int change = random.nextBoolean() ? 1 : -1;
            temperature = Math.max(0, Math.min(40, temperature + change));

            notifyObservers();
        }
    }

    public void stop() {
        running = false;
    }
}