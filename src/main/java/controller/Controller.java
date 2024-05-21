package controller;

import Administrator.CreateNewCarWindow.entity.Car;
import Administrator.SendDriverWindow.entity.Application;
import Driver.entity.Driver;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private List<Car> cars = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    //URL Cars_FILE_PATH = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Cars.txt").toURL();
    private final String Cars_FILE_PATH = "C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Cars.txt";
    //URL Drivers_FILE_PATH = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Drivers.txt").toURL();
    private final String Drivers_FILE_PATH = "C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Drivers.txt";

    public Controller() {
        loadCarsFile();
        loadDriversFile();
    }

    public void createDriver(String firstName, String secondName, Application application) {
        Driver newDriver = new Driver(firstName, secondName, application);
        drivers.add(newDriver);
        saveDriversInFile();
    }

    public void createCar(String mark, int mileage){
        Car newCar = new Car(mark, mileage);
        cars.add(newCar);
        saveCarsInFile();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void sortCarsByMileage(){
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Integer.compare(c1.getMileage(), (c2.getMileage()));
            }
        });
    }

    public void saveCarsInFile(){
        try {
            FileOutputStream fos= new FileOutputStream(Cars_FILE_PATH.toString());
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(cars);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDriversInFile(){
        try {
            FileOutputStream fos= new FileOutputStream(Drivers_FILE_PATH.toString());
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(drivers);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadCarsFile(){
        try {
            FileInputStream fis = new FileInputStream(Cars_FILE_PATH.toString());

            ObjectInputStream ois = new ObjectInputStream(fis);
            this.cars = (List<Car>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadDriversFile(){
        try {
            FileInputStream fis = new FileInputStream(Drivers_FILE_PATH.toString());

            ObjectInputStream ois = new ObjectInputStream(fis);
            this.drivers = (List<Driver>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
