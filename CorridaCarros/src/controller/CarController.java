package controller;

import view.Principal;

public class CarController extends Thread {
    private String name;
    private int distance;
    private int maxSpeed;
    private int currentSpeed;

    public CarController(String name, int distance, int maxSpeed) {
        this.name = name;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }

    @Override
    public void run() {
        while (distance > 0) {
            try {
                Thread.sleep(100); // Espera 100ms
                accelerate();
                distance -= currentSpeed;
                Principal.updateCarPosition(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Principal.carCrossedFinishLine(this);
    }

    public String getCarName() {
        return name;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    private void accelerate() {
        currentSpeed = (int) (Math.random() * (maxSpeed + 1));
    }
}
