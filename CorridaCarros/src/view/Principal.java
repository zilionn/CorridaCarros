package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CarController;

public class Principal {
    private static JFrame frame;
    private static JPanel raceTrack;
    private static JLabel car1Label;
    private static JLabel car2Label;
    private static JTextField winnerTextField;
    private static JTextField loserTextField;
    private static JPanel car1;
    private static JPanel car2;

    public static void main(String[] args) {
        frame = new JFrame("Corrida de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        raceTrack = new JPanel();
        raceTrack.setLayout(new GridLayout(2, 1));
        car1Label = new JLabel("Carro 1");
        car2Label = new JLabel("Carro 2");
        winnerTextField = new JTextField("Vencedor");
        loserTextField = new JTextField("Perdedor");

        raceTrack.add(car1Label);
        raceTrack.add(car2Label);
        
        car1 = createCar(Color.RED);
        car2 = createCar(Color.BLUE);

        raceTrack.add(car1);
        raceTrack.add(car2);

        frame.add(raceTrack, BorderLayout.CENTER);
        frame.add(winnerTextField, BorderLayout.NORTH);
        frame.add(loserTextField, BorderLayout.SOUTH);

        JButton startButton = new JButton("Correr");
        startButton.addActionListener(e -> startRace());
        frame.add(startButton, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public static void carCrossedFinishLine(CarController car) {
        if (winnerTextField.getText().equals("Vencedor")) {
            winnerTextField.setText(car.getCarName());
        } else {
            loserTextField.setText(car.getCarName());
        }
    }

    private static void startRace() {
        CarController car1 = new CarController("Carro 1", 800, 10);
        CarController car2 = new CarController("Carro 2", 800, 10);
        car1.start();
        car2.start();

        frame.getComponent(4).setEnabled(false);
    }
    
    public static void updateCarPosition(CarController car) {
        int positionX = car.getCurrentSpeed(); // Use a velocidade como posição (simplesmente para ilustração)
        if (car.getCarName().equals("Carro 1")) {
            car1.setLocation(positionX, car1.getY());
        } else if (car.getCarName().equals("Carro 2")) {
            car2.setLocation(positionX, car2.getY());
        }
    }
    
    private static JPanel createCar(Color color) {
        JPanel car = new JPanel();
        car.setBackground(color);
        car.setSize(40, 20); // Tamanho do carro
        return car;
    }
}
