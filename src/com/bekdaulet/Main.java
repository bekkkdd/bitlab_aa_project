package com.bekdaulet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBManager db = new DBManager();
        db.connect();

        System.out.println("Hello, " + in.next() + "!!");

        while (true) {

            System.out.println("[1] ADD CAR");
            System.out.println("[2] LIST CARS");
            System.out.println("[3] TO UPDATE CAR");
            System.out.println("[4] TO DELETE CAR");
            System.out.println("[0] EXIT");

            String choice = in.next();

            if (choice.equals("1")) {

                System.out.println("Insert name: ");
                String name = in.next();
                System.out.println("Insert price: ");
                int price = in.nextInt();
                System.out.println("Insert engine volume: ");
                double engineVolume = in.nextDouble();

                //Именно поэтому мы и сделали Long id. Чтобы передавать в конструктор null.
                Car car = new Car(null, name, price, engineVolume);
                db.addCar(car);

            } else if (choice.equals("2")) {

                ArrayList<Car> cars = db.getAllCar();

                for (Car c : cars) {
                    System.out.println(c);
                }

            } else if (choice.equals("0")) {
                System.exit(0);
            } else if (choice.equals("3")) {
                ArrayList<Car> cars = db.getAllCar();

                for (Car c : cars) {
                    System.out.println(c);
                }

                System.out.println("Choose id:");
                Long updateId = in.nextLong();
                System.out.println("Insert name:");
                String name = in.next();
                System.out.println("Insert price:");
                int price = in.nextInt();
                System.out.println("Insert EV:");
                double ev = in.nextDouble();
                Car car = new Car(updateId, name, price, ev);
                db.updateCar(car);
            } else if (choice.equals("4")) {
                ArrayList<Car> cars = db.getAllCar();

                for (Car c : cars) {
                    System.out.println(c);
                }

                System.out.println("Choose id:");
                Long deleteId = in.nextLong();
                db.deleteCar(deleteId);
            }
        }
    }
}
