package src.main.java.com.silentlunar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        printStartGame();
        simulation.initMap();
        Scanner scannerMenu;
        boolean isSimulationGame = true;
        while (isSimulationGame) {
            scannerMenu = printMenuGame();
            switch (scannerMenu.next()) {
                case "1":
                    simulation.nextTurn();
                    break;
                case "2":
                    try {
                        simulation.startSimulation();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    simulation.pauseSimulation();
                    isSimulationGame = false;
                    break;
            }
        }
    }

    public static Scanner printMenuGame() {
        System.out.println("~~~~~~~~~~~~~~~~~Меню~~~~~~~~~~~~~~~~~");
        System.out.println("1~~~~~~~Симуляция~одного~хода~~~~~~~~~");
        System.out.println("2~~~Бесконечная~симуляция~аквариума~~~");
        System.out.println("3~~~~~~~~~~~~Закончить~игру~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return new Scanner(System.in);
    }
    public static void printStartGame(){
        System.out.println("~~~~~~~~~~~~~Игра~Симуляция~~~~~~~~~~~");
        System.out.println("~~~~~~Сгенерированное~гровое~поле~~~~~");
    }
}
